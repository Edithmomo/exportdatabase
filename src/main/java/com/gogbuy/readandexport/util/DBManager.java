package com.gogbuy.readandexport.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

/**
 * @author edith
 * @Description 配置jdbc连接
 * @date 2020/1/3 15:23
 */
public class DBManager {

    /**
     * 获取数据库连接
     *
     * @return 数据库连接
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            InputStream is = DBManager.class.getClassLoader().getResourceAsStream("dbconfig.properties");
            HashMap<String, String> map = LoadProperties.getInstance().getMap();
            String driver = map.get("jdbc.driver");
            String url = map.get("jdbc.url");
            String user = map.get("jdbc.user");
            String password = map.get("jdbc.password");
            Properties pros = new Properties();
            pros.setProperty("user", user);
            pros.setProperty("password", password);
            pros.setProperty("remarks", "true"); //设置可以获取remarks信息
            pros.setProperty("useInformationSchema", "true");//设置可以获取tables remarks信息
            Class.forName(driver);
            connection = DriverManager.getConnection(url,pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 释放数据库资源
     *
     * @param connection 数据库连接
     */
    public static void release(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
