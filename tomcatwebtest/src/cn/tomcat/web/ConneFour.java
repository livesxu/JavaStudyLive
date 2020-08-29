package cn.tomcat.web;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class ConneFour {

    public static void main(String[] args) throws Exception {

        Properties properties = new Properties();
        InputStream inputStream = ConneFour.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(inputStream);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        Connection connection = dataSource.getConnection();

        System.out.println(connection);

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from tbtest;");

        while (resultSet.next()) {

            System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
        }

        connection.close();
    }
}
