package org.edu.sagesse.data.base.support.factory;

import org.edu.sagesse.common.support.helper.TextHelper;
import org.edu.sagesse.common.support.logger.SaLogger;
import org.edu.sagesse.common.support.logger.SaLoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * <p>雪花算法，解决时间回拨问题</p>
 * <p>整合业务，需要根据业务编号生成id</p>
 *
 * @author hedwing
 * @since 2022/11/26
 **/
@SuppressWarnings("all")
public class SnowflakeFactory {
    private static final SaLogger LOGGER = SaLoggerFactory.getLogger(SnowflakeFactory.class);
    /**
     * 起始的时间戳 2022-11-01 00:00:00
     */
    private final static long START_TIMESTAMP = 1640966400000L;
    /**
     * 每一部分占用的位数
     */
    private final static long SEQUENCE_BIT = 12;
    private final static long MACHINE_BIT = 5;
    private final static long DATACENTER_BIT = 5;

    /**
     * 每一部分的最大值
     * MAX_DATACENTER_NUM = 31
     * MAX_MACHINE_NUM = 31
     * MAX_SEQUENCE = 4095
     */
    private final static long MAX_DATACENTER_NUM = ~(-1L << DATACENTER_BIT);
    private final static long MAX_MACHINE_NUM = ~(-1L << MACHINE_BIT);
    private final static long MAX_SEQUENCE = ~(-1L << SEQUENCE_BIT);

    /**
     * 每一部分向左的位移
     */
    private final static long MACHINE_LEFT = SEQUENCE_BIT;
    private final static long DATACENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
    private final static long TIMESTAMP_LEFT = DATACENTER_LEFT + DATACENTER_BIT;

    /**
     * 数据中心
     */
    private long datacenterId = 0;
    /**
     * 机器标识
     */
    private long machineId = 0;
    /**
     * 序列号
     */
    private long sequence = 0L;
    /**
     * 上一次时间戳
     */
    private long lastStamp = -1L;

    /**
     * 最大容忍时间, 单位毫秒, 即如果时钟只是回拨了该变量指定的时间, 那么等待相应的时间即可;
     * 考虑到sequence服务的高性能, 这个值不易过大
     */
    private static final long MAX_BACKWARD_MS = 5;

    /**
     * 最大扩展字段
     */
    private long maxExtension = 2L;
    /**
     * 保留machineId和lastTimestamp, 以及备用machineId和其对应的lastTimestamp
     */
    private static Map<Long, Long> machineIdLastTimeMap = new ConcurrentHashMap<>();

    /**
     * 初始化数据中心位，和机器标识
     * 0 < datacenterId < MAX_DATACENTER_NUM 31
     * 0 < machineId < MAX_MACHINE_NUM 31
     *
     * @param datacenterId 数据中心位
     * @param machineId    机器标识
     */
    public SnowflakeFactory(long datacenterId, long machineId) {
        LOGGER.info("雪花算法正在启动...[machineId={}, datacenterId={}]", machineId, datacenterId);
        if (datacenterId > MAX_DATACENTER_NUM || datacenterId < 0) {
            String errorMessage = "datacenterId不能大于 {},也不能小于0";
            LOGGER.error(errorMessage, MAX_DATACENTER_NUM);
            throw new IllegalArgumentException(TextHelper.build().format(errorMessage, MAX_DATACENTER_NUM));
        }
        if (machineId > MAX_MACHINE_NUM || machineId < 0) {
            String errorMessage = "machineId不能大于 {},也不能小于0";
            LOGGER.error(errorMessage, MAX_MACHINE_NUM);
            throw new IllegalArgumentException(TextHelper.build().format(errorMessage, MAX_MACHINE_NUM));
        }
        this.datacenterId = datacenterId;
        this.machineId = machineId;
        //初始化时间 machineIdLastTimeMap
        machineIdLastTimeMap.put(machineId, getNewStamp());
    }

    /**
     * 产生下一个ID
     */
    public synchronized Long nextId() {
        //现存的扩展字段
        long extension = 0L;
        //获取当前时间毫秒数
        long currStamp = getNewStamp();
        //lastStamp = currStamp + 100;
        if (currStamp < lastStamp) {
            //throw new RuntimeException("时钟向后移动,拒绝生成id");

            // 如果时钟回拨在可接受范围内, 等待即可
            long offset = lastStamp - currStamp;
            //如果回拨时间不超过5毫秒，就等待相应的时间
            if (offset <= MAX_BACKWARD_MS) {
                try {
                    //睡（lastTimestamp - currentTimestamp）ms让其追上
                    LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(offset));

                    currStamp = getNewStamp();
                    //如果时间还小于当前时间，那么利用扩展字段加1
                    //或者是采用抛异常并上报
                    if (currStamp < lastStamp) {
                        //扩展字段
                        extension += 1;
                        if (extension > maxExtension) {
                            //服务器时钟被调整了,ID生成器停止服务.
                            throw new RuntimeException(String.format("时钟向后移动。拒绝生成的id %d 毫秒", lastStamp - currStamp));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                //扩展字段
                extension += 1;
                if (extension > maxExtension) {
                    //服务器时钟被调整了,ID生成器停止服务.
                    throw new RuntimeException(String.format("时钟向后移动，超出扩展位，拒绝生成的id %d 毫秒", lastStamp - currStamp));
                }
                //获取可以用的workId，对应的时间戳，必须大于当前时间戳
                lastStamp = tryGenerateKeyOnBackup(currStamp);
            }
        }

        if (currStamp == lastStamp) {
            //相同毫秒内，序列号自增
            sequence = (sequence + 1) & MAX_SEQUENCE;
            //同一毫秒的序列数已经达到最大
            if (sequence == 0L) {
                currStamp = getNextMill();
            }
        } else {
            //不同毫秒内，序列号置为0
            sequence = 0L;
        }

        lastStamp = currStamp;

        return (currStamp - START_TIMESTAMP) << (TIMESTAMP_LEFT - extension)
                | datacenterId << DATACENTER_LEFT
                | machineId << MACHINE_LEFT
                | sequence;
    }

    /**
     * 自旋锁获取当前时间戳
     *
     * @return
     */
    private long getNextMill() {
        long mill = getNewStamp();
        while (mill <= lastStamp) {
            mill = getNewStamp();
        }
        return mill;
    }

    /**
     * 获取当前时间毫秒数
     *
     */
    private long getNewStamp() {
        return System.currentTimeMillis();
        //测试时间回拨
        //return 53501026489350000l;
    }

    /**
     * 尝试在machineId的备份machineId上生成
     * 核心优化代码在方法tryGenerateKeyOnBackup()中，BACKUP_COUNT即备份machineId数越多，
     * sequence服务避免时钟回拨影响的能力越强，但是可部署的sequence服务越少，
     * 设置BACKUP_COUNT为3，最多可以部署1024/(3+1)即256个sequence服务，完全够用，
     * 抗时钟回拨影响的能力也得到非常大的保障。
     *
     * @param currentMillis 当前时间
     */
    private long tryGenerateKeyOnBackup(long currentMillis) {
        // 遍历所有machineId(包括备用machineId, 查看哪些machineId可用)
        for (Map.Entry<Long, Long> entry : machineIdLastTimeMap.entrySet()) {
            this.machineId = entry.getKey();
            // 取得备用machineId的lastTime
            Long tempLastTime = entry.getValue();
            lastStamp = tempLastTime == null ? 0L : tempLastTime;

            // 如果找到了合适的machineId，返回合适的时间，
            if (lastStamp <= currentMillis) {
                return lastStamp;
            }
        }
        // 如果所有machineId以及备用machineId都处于时钟回拨, 那么抛出异常
        throw new IllegalStateException("时钟在向后移动，当前时间是 " + currentMillis + " 毫秒，machineId映射 = " + machineIdLastTimeMap);
    }
}
