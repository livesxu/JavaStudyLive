package dao;

import JDBC.JDBCUnit;
import bean.UserInfo;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class UserInfoDao {

    static public UserInfo registerUserInfo (UserInfo userInfo) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {

            connection = JDBCUnit.getConnection();

            String sqlString = "insert into userinfo(phone,password) values (?,?);";
            preparedStatement = connection.prepareStatement(sqlString);
            preparedStatement.setString(1,userInfo.getPhone());
            preparedStatement.setString(2,userInfo.getPassword());

            int count = preparedStatement.executeUpdate();

            if (count >0) {

                return userInfo;
            } else {

                return null;
            }

        } catch (Exception exception) {

            System.out.println(exception.getStackTrace().toString());

        } finally {

            JDBCUnit.close(connection,preparedStatement);
        }

        return null;

    }

    static public UserInfo loginUserInfo (UserInfo userInfo) {

//      //1.写法
        boolean doLogin = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {

            connection = JDBCUnit.getConnection();

            String sqlString = "select * from userinfo where phone=? and password=?;";
            preparedStatement = connection.prepareStatement(sqlString);
            preparedStatement.setString(1,userInfo.getPhone());
            preparedStatement.setString(2,userInfo.getPassword());

            resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {

                userInfo.setId(resultSet.getInt("id"));
                userInfo.setNickname(resultSet.getString("nickname"));
                userInfo.setBirthday(resultSet.getDate("birthday"));
                userInfo.setSex(resultSet.getInt("sex"));
                userInfo.setCreateTime(resultSet.getTimestamp("createTime"));

                doLogin = true;
            } else {


            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {

            JDBCUnit.close(connection,preparedStatement,resultSet);

            if (doLogin == true) {

                return userInfo;
            } else {

                return null;
            }
        }

//        //2.写法
//        String sqlString = "select * from userinfo where phone=? and password=?;";
//        List<UserInfo> userInfos = JDBCUnit.getJdbcTemplate().query(sqlString, new PreparedStatementSetter() {
//            @Override
//            public void setValues(PreparedStatement preparedStatement) throws SQLException {
//
//                preparedStatement.setString(1,userInfo.getPhone());
//                preparedStatement.setString(2,userInfo.getPassword());
//            }
//        }, new BeanPropertyRowMapper<>(UserInfo.class));
//
//        if (userInfos.size() > 0) {
//
//            return userInfos.get(0);
//        } else {
//
//            return null;
//        }
    }
}
