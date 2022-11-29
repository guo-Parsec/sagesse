-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sagesse_core_db
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- 数据库创建
create schema sagesse_core_db character set utf8mb4 collate utf8mb4_unicode_ci;
create schema sagesse_nacos_db character set utf8mb4 collate utf8mb4_unicode_ci;
--
-- Table structure for table `sys_dict_category`
--

DROP TABLE IF EXISTS `sys_dict_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_dict_category` (
  `id` bigint NOT NULL COMMENT '主键',
  `category_code` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '类别码',
  `category_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '类别名称',
  `sort` int NOT NULL DEFAULT '10' COMMENT '排序',
  `data_status` tinyint NOT NULL DEFAULT '0' COMMENT '数据状态',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  UNIQUE KEY `sys_dict_category_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='系统字典类别表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict_category`
--

/*!40000 ALTER TABLE `sys_dict_category` DISABLE KEYS */;
INSERT INTO `sys_dict_category` (`id`, `category_code`, `category_name`, `sort`, `data_status`, `gmt_create`, `gmt_modify`) VALUES (1,'data_status','数据状态',10,0,'2022-10-19 09:28:01','2022-10-23 18:30:31'),(2,'sex','性别字典',20,0,'2022-10-23 18:30:26','2022-10-23 18:32:45'),(3,'user_type','用户类型',30,0,'2022-10-19 09:56:16','2022-10-23 18:32:48'),(4,'access_result','访问结果',40,0,'2022-11-28 10:27:40','2022-11-28 10:27:49'),(5,'access_type','访问类型',50,0,'2022-11-28 10:29:46','2022-11-28 10:29:46'),(35406823058182144,'visible_status','显示状态',60,0,'2022-11-18 16:54:04','2022-11-28 10:29:46');
/*!40000 ALTER TABLE `sys_dict_category` ENABLE KEYS */;

--
-- Table structure for table `sys_dict_detail`
--

DROP TABLE IF EXISTS `sys_dict_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_dict_detail` (
  `id` bigint NOT NULL COMMENT '主键',
  `sys_dict_category_id` bigint NOT NULL COMMENT '字典类别表主键',
  `dict_code` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '字典码',
  `dict_value` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '字典值',
  `dict_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '字典名称',
  `sort` int NOT NULL DEFAULT '10' COMMENT '排序',
  `parent_id` bigint DEFAULT NULL COMMENT '上级字典id',
  `data_status` tinyint NOT NULL DEFAULT '0' COMMENT '数据状态',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='系统字典详情表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict_detail`
--

/*!40000 ALTER TABLE `sys_dict_detail` DISABLE KEYS */;
INSERT INTO `sys_dict_detail` (`id`, `sys_dict_category_id`, `dict_code`, `dict_value`, `dict_name`, `sort`, `parent_id`, `data_status`, `gmt_create`, `gmt_modify`) VALUES (1,1,'enable','0','启用状态',10,NULL,0,'2022-10-23 18:31:48','2022-10-23 18:34:31'),(2,1,'disable','1','禁用状态',20,NULL,0,'2022-10-23 18:32:21','2022-10-23 18:34:31'),(3,1,'delete','2','删除状态',30,NULL,0,'2022-10-23 18:32:21','2022-10-23 18:34:31'),(4,2,'unknown','0','未知',10,NULL,0,'2022-10-23 18:34:31','2022-10-23 18:34:31'),(5,2,'female','1','女性',20,NULL,0,'2022-10-23 18:34:31','2022-10-23 18:34:31'),(6,2,'male','2','男性',30,NULL,0,'2022-10-23 18:34:31','2022-10-23 18:34:31'),(7,4,'success','0','成功',10,NULL,0,'2022-11-28 10:28:44','2022-11-28 10:28:44'),(8,4,'failed','1','失败',20,NULL,0,'2022-11-28 10:28:44','2022-11-28 10:28:44'),(9,5,'get','0','GET请求',10,NULL,0,'2022-11-28 10:30:55','2022-11-28 10:30:55'),(10,5,'post','1','POST请求',20,NULL,0,'2022-11-28 10:30:55','2022-11-28 10:30:55'),(11,5,'put','2','PUT请求',30,NULL,0,'2022-11-28 10:30:55','2022-11-28 10:30:55'),(12,5,'delete','3','DELETE请求',40,NULL,0,'2022-11-28 10:30:55','2022-11-28 10:30:55'),(35407092705792000,35406823058182144,'visible','0','可见',10,NULL,0,'2022-11-18 16:55:09','2022-11-18 16:55:09'),(35407175094505472,35406823058182144,'invisible','1','不可见',20,NULL,0,'2022-11-18 16:55:28','2022-11-18 16:56:08');
/*!40000 ALTER TABLE `sys_dict_detail` ENABLE KEYS */;

--
-- Table structure for table `sys_hi_login`
--

DROP TABLE IF EXISTS `sys_hi_login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_hi_login` (
  `id` bigint NOT NULL COMMENT '主键',
  `login_ip` varchar(18) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '登录ip',
  `login_account` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '登录账户',
  `login_equipment` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '登录设备',
  `time_consuming` bigint NOT NULL COMMENT '耗时时间(ms)',
  `error_code` int DEFAULT NULL COMMENT '错误码',
  `error_message` longtext COLLATE utf8mb4_unicode_ci COMMENT '错误信息',
  `login_result` tinyint NOT NULL DEFAULT '0' COMMENT '登录是否成功 0-成功 1-失败',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  PRIMARY KEY (`id`),
  KEY `sys_hi_login_login_account_time_consuming_gmt_create_index` (`login_account`,`time_consuming`,`gmt_create`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='登录历史记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_hi_login`
--

/*!40000 ALTER TABLE `sys_hi_login` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_hi_login` ENABLE KEYS */;

--
-- Table structure for table `sys_hi_operate`
--

DROP TABLE IF EXISTS `sys_hi_operate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_hi_operate` (
  `id` bigint NOT NULL COMMENT '主键',
  `access_url` text COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '访问路径',
  `access_server` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '访问应用',
  `operate_user_id` bigint NOT NULL COMMENT '操作人id',
  `operate_user_account` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '操作用户账户',
  `time_consuming` bigint NOT NULL COMMENT '耗时时间(ms)',
  `access_type` tinyint NOT NULL COMMENT '访问类型',
  `request_param` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '请求参数',
  `request_result` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '请求结果',
  `error_code` int DEFAULT NULL COMMENT '错误码',
  `error_message` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '错误信息',
  `access_result` tinyint NOT NULL DEFAULT '0' COMMENT '访问结果',
  `remark` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '备注',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='操作历史记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_hi_operate`
--

/*!40000 ALTER TABLE `sys_hi_operate` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_hi_operate` ENABLE KEYS */;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_menu` (
  `id` bigint NOT NULL COMMENT '主键',
  `parent_id` bigint DEFAULT NULL COMMENT '上级菜单id',
  `hierarchical_path` varchar(225) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '/' COMMENT '层级路径',
  `menu_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '菜单标识',
  `menu_title` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '菜单标题',
  `menu_icon` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '菜单图标',
  `visible_status` tinyint NOT NULL DEFAULT '0' COMMENT '显示状态(数据字典 0-显示 1-隐藏)',
  `menu_level` tinyint NOT NULL DEFAULT '0' COMMENT '菜单级别',
  `sort` int NOT NULL DEFAULT '10' COMMENT '排序',
  `component` varchar(225) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '前端组件',
  `menu_url` varchar(225) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '菜单访问url',
  `remark` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '菜单描述',
  `data_status` tinyint NOT NULL DEFAULT '0' COMMENT '数据状态',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `sys_menu_menu_code_uindex` (`menu_code`),
  KEY `sys_menu_parent_id_sort_gmt_create_index` (`parent_id`,`sort`,`gmt_create`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='系统菜单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` (`id`, `parent_id`, `hierarchical_path`, `menu_code`, `menu_title`, `menu_icon`, `visible_status`, `menu_level`, `sort`, `component`, `menu_url`, `remark`, `data_status`, `gmt_create`, `gmt_modify`) VALUES (1,0,'/','root','根目录','',1,0,10,'','/starrism/edu','根目录',0,'2022-11-18 15:52:39','2022-11-18 15:52:39'),(2,1,'/0','workbench','工作台','',0,1,20,'','/workbench','',0,'2022-11-18 15:56:24','2022-11-18 15:56:24'),(3,1,'/0','admin','系统管理','',0,1,30,'','/admin','',0,'2022-11-18 15:56:24','2022-11-18 15:56:24'),(4,3,'/0/3','user-management ','用户管理','',0,2,40,'','/user','',0,'2022-11-18 15:56:24','2022-11-18 15:56:24'),(5,3,'/0/3','role-management ','角色管理','',0,2,50,'','/role','',0,'2022-11-18 15:58:39','2022-11-18 15:58:39'),(6,3,'/0/3','permission-management ','权限管理','',0,2,60,'','/permission','',0,'2022-11-18 15:58:39','2022-11-18 15:58:39'),(7,3,'/0/3','dict-management','字典管理','',0,2,70,'','','',0,'2022-11-18 15:58:40','2022-11-18 15:58:40'),(8,3,'/0/3','log-management','日志管理','',0,2,80,'','','',0,'2022-11-18 15:58:40','2022-11-18 15:58:40');
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;

--
-- Table structure for table `sys_param`
--

DROP TABLE IF EXISTS `sys_param`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_param` (
  `id` bigint NOT NULL COMMENT '主键',
  `category_code` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'single_category' COMMENT '类别码',
  `category_name` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '无分组信息' COMMENT '类别名称',
  `param_name` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '参数名称',
  `param_code` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '参数码',
  `param_value` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '参数值',
  `data_status` tinyint NOT NULL DEFAULT '0' COMMENT '数据状态',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='系统参数表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_param`
--

/*!40000 ALTER TABLE `sys_param` DISABLE KEYS */;
INSERT INTO `sys_param` (`id`, `category_code`, `category_name`, `param_name`, `param_code`, `param_value`, `data_status`, `gmt_create`, `gmt_modify`) VALUES (1,'single_category','无分组信息','默认密码策略器','password_strategy','sePasswordMd5',0,'2022-11-07 19:26:37','2022-11-28 10:39:16'),(2,'page','分页参数','默认页大小','default_page_size','10',0,'2022-11-11 13:48:45','2022-11-28 10:39:16'),(3,'page','分页参数','默认当前页','default_current_page','1',0,'2022-11-11 13:48:45','2022-11-28 10:39:16'),(4,'single_category','无分组信息','默认密码','default_password','123456',0,'2022-11-28 10:38:06','2022-11-28 10:39:16');
/*!40000 ALTER TABLE `sys_param` ENABLE KEYS */;

--
-- Table structure for table `sys_resource`
--

DROP TABLE IF EXISTS `sys_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_resource` (
  `id` bigint NOT NULL COMMENT '主键',
  `category_code` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '分类码',
  `category_name` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '分类名称',
  `resource_code` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '权限编码',
  `resource_name` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '权限名称',
  `request_action_url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '请求操作url',
  `sort` int NOT NULL DEFAULT '10' COMMENT '排序',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注信息',
  `data_status` tinyint NOT NULL DEFAULT '0' COMMENT '数据状态',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='系统资源表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_resource`
--

/*!40000 ALTER TABLE `sys_resource` DISABLE KEYS */;
INSERT INTO `sys_resource` (`id`, `category_code`, `category_name`, `resource_code`, `resource_name`, `request_action_url`, `sort`, `remark`, `data_status`, `gmt_create`, `gmt_modify`) VALUES (1,'authenticated_permission','权限认证','*:*:*','全权限','/**',10,NULL,0,'2022-11-10 16:41:02','2022-11-28 10:04:09'),(2,'anonymous','匿名认证','logout','登出','/auth/logout.do',20,NULL,0,'2022-11-10 16:42:03','2022-11-28 10:04:09'),(3,'anonymous','匿名认证','login','登录','/auth/login.do',30,NULL,0,'2022-11-06 21:52:46','2022-11-28 10:04:09'),(35319636375506944,'authenticated_permission','权限认证','admin:self-role:query','获取角色码：根据用户id获取','/admin/sys/role/find/code/by/roles',40,'',0,'2022-11-18 11:07:38','2022-11-28 10:04:09'),(35319636392284160,'authenticated_permission','权限认证','admin:dict-detail:query-page','字典详情数据分页查询','/admin/sys/dict/detail/page',50,'',0,'2022-11-18 11:07:38','2022-11-28 10:04:09'),(35319636392284161,'authenticated_permission','权限认证','admin:self-permission:query','字典类别数据更新','/admin/sys/permission/find/url/by/roles',60,'',0,'2022-11-18 11:07:38','2022-11-28 10:04:09'),(35319636392284162,'authenticated_permission','权限认证','admin:dict-category:write','字典类别数据新增','/admin/sys/dict/category/create.do',70,'',0,'2022-11-18 11:07:38','2022-11-28 10:04:09'),(35319636392284163,'authenticated_permission','权限认证','admin:dict-detail:query-list','字典详情数据非分页查询','/admin/sys/dict/detail/list',80,'',0,'2022-11-18 11:07:38','2022-11-28 10:04:09'),(35319636396478464,'authenticated_permission','权限认证','admin:dict-detail:write','字典详情数据更新','/admin/sys/dict/detail/put.do',90,'',0,'2022-11-18 11:07:38','2022-11-28 10:04:09'),(35319636396478465,'authenticated_permission','权限认证','admin:self-user:query','根据账户查询用户','/admin/sys/user/find/by/account',100,'',0,'2022-11-18 11:07:38','2022-11-28 10:04:09'),(35319636396478466,'authenticated_permission','权限认证','admin:self-permission:query','字典类别数据更新','/admin/sys/permission/find/url/by/userId',110,'',0,'2022-11-18 11:07:38','2022-11-28 10:04:09'),(35319636400672768,'authenticated_permission','权限认证','admin:dict-detail:write','字典详情数据新增','/admin/sys/dict/detail/create.do',120,'',0,'2022-11-18 11:07:38','2022-11-28 10:04:09'),(35319636400672769,'authenticated_permission','权限认证','admin:dict-category:write','字典类别数据删除','/admin/sys/dict/category/delete.do',130,'',0,'2022-11-18 11:07:38','2022-11-28 10:04:09'),(35319636400672770,'authenticated_permission','权限认证','admin:dict-detail:write','字典详情数据删除','/admin/sys/dict/detail/delete.do',140,'',0,'2022-11-18 11:07:38','2022-11-28 10:04:09'),(35319636404867072,'authenticated_permission','权限认证','admin:dict-category:write','字典类别数据更新','/admin/sys/dict/category/put.do',150,'',0,'2022-11-18 11:07:38','2022-11-28 10:04:09'),(35319636404867073,'authenticated_permission','权限认证','admin:role:query-page','角色分页查询','/admin/sys/role/query',160,'',0,'2022-11-18 11:07:38','2022-11-28 10:04:09'),(35319636404867074,'authenticated_permission','权限认证','admin:self-permission:query','查询角色权限：根据用户id查询权限码','/admin/sys/permission/find/code/by/userId',170,'',0,'2022-11-18 11:07:38','2022-11-28 10:04:09'),(35357115686195200,'authenticated_permission','权限认证','admin:online-user:query','查询全部在线用户','/auth/find/all/online/user',180,'',0,'2022-11-18 13:36:33','2022-11-28 10:04:09'),(35408264875347968,'authenticated_permission','权限认证','admin:self-menu:query','查询用户的菜单树形结构列表','/admin/sys/menu/find/menu-tree/of/user-id',190,'',0,'2022-11-18 16:59:48','2022-11-28 10:04:09'),(35408264883736576,'authenticated_permission','权限认证','admin:self-menu:query','查询用户的菜单id列表','/admin/sys/menu/find/menu-ids/of/user-id',200,'',0,'2022-11-18 16:59:48','2022-11-28 10:04:09');
/*!40000 ALTER TABLE `sys_resource` ENABLE KEYS */;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role` (
  `id` bigint NOT NULL COMMENT '主键',
  `role_code` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色编码',
  `role_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色名称',
  `sort` int NOT NULL DEFAULT '10' COMMENT '排序',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注信息',
  `data_status` tinyint NOT NULL DEFAULT '0' COMMENT '数据状态',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='系统角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` (`id`, `role_code`, `role_name`, `sort`, `remark`, `data_status`, `gmt_create`, `gmt_modify`) VALUES (1,'full-admin','超级管理员',10,NULL,0,'2022-10-20 10:57:51','2022-10-20 10:58:05'),(2,'school-level-admin','校级管理员',20,NULL,0,'2022-10-20 10:57:51','2022-10-20 10:58:17'),(3,'school-eduction-office','校级教务',30,NULL,0,'2022-10-20 11:05:07','2022-10-20 11:06:56'),(4,'school-financial','校级财务',40,NULL,0,'2022-10-20 11:06:31','2022-10-20 11:07:00'),(5,'school-student-affairs','校级学务',50,NULL,0,'2022-10-20 11:09:22','2022-10-20 11:09:22'),(6,'college-level-admin','院级管理员',60,NULL,0,'2022-10-20 10:57:51','2022-10-20 11:09:34'),(7,'college-eduction-office','院级教务',70,NULL,0,'2022-10-20 11:05:34','2022-10-20 11:09:34'),(8,'college-financial','院级财务',80,NULL,0,'2022-10-20 11:10:28','2022-10-20 11:10:28'),(9,'college-student-affairs','院级学务',90,NULL,0,'2022-10-20 11:10:28','2022-10-20 11:10:28'),(10,'major-level-admin','系级管理员',100,NULL,0,'2022-10-20 11:15:28','2022-10-20 11:15:28'),(11,'major-eduction-office','系级教务',110,NULL,0,'2022-10-20 11:15:28','2022-10-20 11:15:28'),(12,'major-student-affairs','系级学务',120,NULL,0,'2022-10-20 11:15:28','2022-10-20 11:15:28'),(13,'counselor','辅导员',130,NULL,0,'2022-10-20 11:15:28','2022-10-20 11:15:28'),(14,'class-head-teacher','班主任',140,NULL,0,'2022-10-20 11:15:28','2022-10-20 11:15:28'),(15,'class-monitor','班长',150,NULL,0,'2022-10-20 11:15:28','2022-10-20 11:15:28'),(16,'class-committee','班委',160,NULL,0,'2022-10-20 11:15:28','2022-10-20 11:15:28'),(17,'teacher','任课教师',170,NULL,0,'2022-10-20 11:15:28','2022-10-20 11:15:28'),(18,'student','学生',180,NULL,0,'2022-10-20 11:15:28','2022-10-20 11:15:43');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;

--
-- Table structure for table `sys_role_menu`
--

DROP TABLE IF EXISTS `sys_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role_menu` (
  `role_id` bigint NOT NULL COMMENT '角色id',
  `menu_id` bigint NOT NULL COMMENT '权限id',
  KEY `fk_sys_role_menu_role_id_re_sys_role_id` (`role_id`) USING BTREE,
  KEY `fk_sys_role_menu_menu_id_re_sys_menu_id` (`menu_id`) USING BTREE,
  CONSTRAINT `fk_sys_role_menu_menu_id_re_sys_menu_id` FOREIGN KEY (`menu_id`) REFERENCES `sys_menu` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_sys_role_menu_role_id_re_sys_role_id` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='角色菜单关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_menu`
--

/*!40000 ALTER TABLE `sys_role_menu` DISABLE KEYS */;
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8);
/*!40000 ALTER TABLE `sys_role_menu` ENABLE KEYS */;

--
-- Table structure for table `sys_role_resource`
--

DROP TABLE IF EXISTS `sys_role_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role_resource` (
  `role_id` bigint NOT NULL COMMENT '角色id',
  `resource_id` bigint NOT NULL COMMENT '权限id',
  KEY `sys_role_resource_sys_role_id_fk` (`role_id`),
  KEY `sys_role_resource_sys_resource_id_fk` (`resource_id`),
  CONSTRAINT `sys_role_resource_sys_resource_id_fk` FOREIGN KEY (`resource_id`) REFERENCES `sys_resource` (`id`),
  CONSTRAINT `sys_role_resource_sys_role_id_fk` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='角色权限关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_resource`
--

/*!40000 ALTER TABLE `sys_role_resource` DISABLE KEYS */;
INSERT INTO `sys_role_resource` (`role_id`, `resource_id`) VALUES (1,1);
/*!40000 ALTER TABLE `sys_role_resource` ENABLE KEYS */;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user` (
  `id` bigint NOT NULL COMMENT '用户主键',
  `account` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '账户信息',
  `password` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `nickname` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户昵称',
  `sex` tinyint NOT NULL DEFAULT '0' COMMENT '性别',
  `avatar_url` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头像地址',
  `birthday` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '出生日期',
  `user_type` tinyint NOT NULL DEFAULT '0' COMMENT '用户类型',
  `data_status` tinyint NOT NULL DEFAULT '0' COMMENT '数据状态',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE COMMENT '账户唯一索引',
  UNIQUE KEY `index_unique_sys_user_account_id_asce` (`id`) USING BTREE COMMENT '账户唯一索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='系统用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` (`id`, `account`, `password`, `nickname`, `sex`, `avatar_url`, `birthday`, `user_type`, `data_status`, `gmt_create`, `gmt_modify`) VALUES (31135640900997120,'admin','37029f3c646ca4d471884ac903754946','超级管理员',0,NULL,'2022-10-20 00:00:00',0,0,'2022-10-19 09:25:24','2022-11-06 22:03:14'),(31135640900997122,'tjnu_admin','e53fd9d14810434b93a248dbfe4bde7d','教务系统管理员',1,NULL,'1958-09-10 00:00:00',0,0,'2022-10-20 11:20:37','2022-11-06 22:03:14');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user_role` (
  `user_id` bigint NOT NULL COMMENT '用户id',
  `role_id` bigint NOT NULL COMMENT '角色id',
  KEY `fk_sys_user_role_role_id_re_sys_role_id` (`role_id`) USING BTREE,
  KEY `fk_sys_user_role_user_id_re_sys_user_id` (`user_id`) USING BTREE,
  CONSTRAINT `fk_sys_user_role_role_id_re_sys_role_id` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_sys_user_role_user_id_re_sys_user_id` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='用户角色关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` (`user_id`, `role_id`) VALUES (31135640900997120,1),(31135640900997122,2);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-28 10:42:30
