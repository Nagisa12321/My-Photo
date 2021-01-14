package com.jtchen.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/12 20:56
 */
public class ConnectionUtils {
    public static String urlPrefix;

    private static Connection conn = null;

    private static String user;

    private static String url;

    private static String password;

    static {
        try {
            InputStream inputStream = ConnectionUtils.class.getClassLoader().getResourceAsStream("/../config.properties");
//            InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("config.properties");
            Properties info = new Properties();
            info.load(inputStream);

            // set url, name, password, class
            url = info.getProperty("url");
            user = info.getProperty("user");
            password = info.getProperty("pwd");
            urlPrefix = info.getProperty("urlPrefix");
            String driverClass = info.getProperty("driverClass");

            // 使用数据库前, 需要先初始化驱动类
            Class.forName(driverClass);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
            System.out.println();
        }
    }

    public static Connection establishConnection() {
        // 打通链接
        try {
            if (conn != null) {
                closeConnection();
            }
            conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (SQLException e) {
            return null;
        }
    }

    public static void closeConnection() throws SQLException {
        if (conn != null)
            conn.close();
    }
}
