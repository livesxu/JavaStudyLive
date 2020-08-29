package cn.tomcat.web;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class ConneFive {

    public static void main(String[] args) {

        try {
            Properties properties = new Properties();

            InputStream inputStream = ConneFive.class.getClassLoader().getResourceAsStream("druid.properties");

            properties.load(inputStream);

            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

//            int infos = jdbcTemplate.update("update tbtest set score=100 where id=1;");
//            Map infos = jdbcTemplate.queryForMap("select * from tbtest where id=1;");
//            List infos = jdbcTemplate.queryForList("select * from tbtest;");
            List<TbInfoBean> infos = jdbcTemplate.query("select * from tbtest;",new BeanPropertyRowMapper<TbInfoBean>(TbInfoBean.class));

            System.out.println(infos);

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }
}

class TbInfoBean {

    int id;
    String name;
    double score;
    Date birthday;
    Timestamp addtime;
    String lastname;
    int worker;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Timestamp getAddtime() {
        return addtime;
    }

    public void setAddtime(Timestamp addtime) {
        this.addtime = addtime;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getWorker() {
        return worker;
    }

    public void setWorker(int worker) {
        this.worker = worker;
    }

    @Override
    public String toString() {
        return "TbInfoBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", birthday=" + birthday +
                ", addtime=" + addtime +
                ", lastname='" + lastname + '\'' +
                ", worker=" + worker +
                '}';
    }
}

class Worker {

    int id;
    String location;
    int worktime;
}
