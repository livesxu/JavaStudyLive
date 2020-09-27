package com.livesxu.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.sql.Date;
import java.sql.Timestamp;

//lombok库 帮助主动生成set、get等
@Data
@Table(name = "tb_user")
public class User {

    @Id
    @KeySql(useGeneratedKeys = true)//作为主键自增长
    private int id;

    private String email;

    private String password;

    private String name;

    private int sex;

    private Date birthday;

    @Transient
    private Timestamp loginTime;

    //瞬时，不作为sql字段持久化
    @Transient
    private String note;
}
