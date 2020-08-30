package cn.tomcat.web;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCRALUtils {

    private static DataSource dataSource = null;

    private static JdbcTemplate jdbcTemplate = null;

    private static Connection connection = null;

    static {
        Properties properties = new Properties();
        InputStream inputStream = JDBCRALUtils.class.getClassLoader().getResourceAsStream("druid.properties");

        try {
            properties.load(inputStream);

            dataSource = DruidDataSourceFactory.createDataSource(properties);

            jdbcTemplate = new JdbcTemplate(dataSource);

        } catch (Exception e) {

            System.out.println(e.getStackTrace());
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
