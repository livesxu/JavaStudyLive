package cn.tomcat.web;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import cn.tomcat.web.JDBCUtils;

public class ConneTwo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户id：");
        String s = scanner.nextLine();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConn();
            statement = connection.createStatement();

            String sqlString = String.format("select * from tbtest where id = %s;",s);
            resultSet = statement.executeQuery(sqlString);

            while (resultSet.next()) {

                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                System.out.println(id + " " + name);
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            JDBCUtils.close(connection,statement,resultSet);
        }
    }
}
