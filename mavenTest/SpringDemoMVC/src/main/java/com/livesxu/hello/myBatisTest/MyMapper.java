package com.livesxu.hello.myBatisTest;

import com.livesxu.pojo.MyPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface MyMapper {

    List<MyPojo> findAll();

    MyPojo findOne();
}
