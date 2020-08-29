package cn.tomcat.web;

import java.net.URL;
import java.sql.ResultSet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {

    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    static  {

        Properties properties = new Properties();


        ClassLoader classLoader = JDBCUtils.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("jdbctest.properties");

        try {
            properties.load(inputStream);
        } catch (IOException e) {

        }
        url = properties.getProperty("url");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
        driver = properties.getProperty("driver");

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {

        }
    }

//    private JDBCUtils (){}
//
//    private static class JDBCHolder {
//
//        static JDBCUtils holder = new JDBCUtils();
//    }
//
//    static public JDBCUtils getInstance () {
//
//        return JDBCHolder.holder;
//    }

    public static Connection getConn () throws SQLException {

        return DriverManager.getConnection(url,user,password);
    }

    public static void close(Connection connection,Statement statement) {

        if (connection != null) {

            try {
                connection.close();
            } catch (SQLException e) {

            }
        }

        if (statement != null) {

            try {
                statement.close();
            } catch (SQLException e) {

            }
        }
    }

    public static void close(Connection connection, Statement statement, ResultSet resultset) {
        close(connection,statement);

        if (resultset != null) {

            try {
                resultset.close();
            } catch (SQLException e) {

            }
        }
    }

}
