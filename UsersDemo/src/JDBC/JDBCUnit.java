package JDBC;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//链接数据库，获取连接对象，销毁
public class JDBCUnit {

    static private DataSource dataSource = null;

    static private JdbcTemplate jdbcTemplate = null;

    static {

        Properties properties = new Properties();

        InputStream inputStream = JDBCUnit.class.getClassLoader().getResourceAsStream("JDBC/UserDB.properties");

        try {
            properties.load(inputStream);

            dataSource = DruidDataSourceFactory.createDataSource(properties);

            jdbcTemplate = new JdbcTemplate(dataSource);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    static public Connection getConnection() throws SQLException {

        return dataSource.getConnection();
    }

    static public JdbcTemplate getJdbcTemplate () {

        return jdbcTemplate;
    }

    static public void close(Connection connection, Statement statement, ResultSet resultSet) {

        if (connection != null) {

            try {
                connection.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }

        }

        if (resultSet != null) {
            try {

                resultSet.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }

        }
    }

    static public void close(Connection connection, Statement statement) {

        close(connection,statement,null);
    }
}
