package cn.tomcat.web;

import java.sql.*;

public class Conne {

    public static void main(String[] args) throws ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = null;

        Statement statement = null;

        ResultSet resultset = null;
        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest","root","bbobbo24");

            statement = connection.createStatement();

//              //增删改
//            {
//                String sqlString = "insert into tbtest(id,name) values (10,'徐波')";
////            String sqlString = "update tbtest set name='徐大波',score=100 where id=10;";
////            String sqlString = "delete from tbtest where id=10;";
//
//                int count = statement.executeUpdate(sqlString);
//
//                if (count > 0) {
//
//                    System.out.println("操作成功");
//                } else {
//
//                    System.out.println("操作失败");
//                }
//            }
            //查
//            String sqlString = "select * from tbtest;";
//            String sqlString = "select id,name from tbtest where score > 80;";
            String sqlString = "select * from tbtest where score <= 70 or score >= 90;";

            resultset = statement.executeQuery(sqlString);
            while (resultset.next()) {

                int id = resultset.getInt("id");
                String name = resultset.getString("name");

                System.out.println(id + "  " + name);
            }

        }catch (SQLException exception) {

            System.out.println(exception.getMessage());

        } finally {

            if (connection != null) {

                try {
                    connection.close();
                }catch (SQLException e) {

                }
            }
            if (statement != null) {

                try {
                    statement.close();
                } catch (SQLException e) {

                }
            }
            if (resultset != null) {

                try{
                    resultset.close();
                } catch (SQLException e) {

                }
            }
        }
//        Class.forName("com.mysql.cj.jdbc.Driver");
//
//        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest","root","bbobbo24");
//
//        String sqlString = "delete from tbtest where id = 8;";
//
//        Statement statement = connection.createStatement();
//
//        int count = statement.executeUpdate(sqlString);
//
//        System.out.println(count);
//
//        statement.close();
//
//        connection.close();
    }
}
