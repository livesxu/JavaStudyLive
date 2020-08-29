package cn.tomcat.web;

import java.sql.*;

public class ConneThree {

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        Statement statement = null;
        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest","root","bbobbo24");

//            String sqlString = "select * from tbtest where worker=? and score > ?;";
//
//            preparedStatement = connection.prepareStatement(sqlString);
//            preparedStatement.setInt(1,2);
//            preparedStatement.setDouble(2,80);
//
//            resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//
//                System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name"));
//            }

            try {
                // 开启事务
                connection.setAutoCommit(false);

                statement = connection.createStatement();

                statement.executeUpdate("update tbtest set score = score + 5 where score > 80;");

                //如果这儿发生了一个错误

                statement.executeUpdate("update tbtest set score = score - 5 where score < 80;");

                //提交事务
                connection.commit();

                System.out.println("成绩更新成功");
            } catch (Exception exception) {

                if (connection != null) {

                    try {
                        //回滚事务
                        connection.rollback();
                        System.out.println("回滚事务");
                    } catch (Exception exception1) {
                    }
                }

                System.out.println(exception.getMessage());
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (connection != null) {

                connection.close();
            }
            if (preparedStatement != null) {

                preparedStatement.close();
            }
            if (resultSet != null) {

                resultSet.close();
            }

            if (statement != null) {

                statement.close();
            }
        }
    }
}
