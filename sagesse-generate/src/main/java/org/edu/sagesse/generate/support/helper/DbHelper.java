package org.edu.sagesse.generate.support.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <p>DB操作辅助类</p>
 *
 * @author guocq
 * @since 2022/11/28
 **/
public class DbHelper {
    private static Connection connection;

    public static Connection getConnection() {
        return connection;
    }

    public static synchronized Connection initDb(String className, String url, String user, String password) {
        if (connection == null) {
            try {
                Class.forName(className);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
