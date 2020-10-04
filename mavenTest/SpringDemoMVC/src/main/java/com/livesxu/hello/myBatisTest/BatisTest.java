package com.livesxu.hello.myBatisTest;

import com.livesxu.pojo.MyPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("mybt")
public class BatisTest {

    @Autowired
    MyMapper myMapper;

    @RequestMapping("findAll")
    public List<MyPojo> findAllTest() {

        return myMapper.findAll();
    }

    @RequestMapping("findOne")
    public MyPojo findOne() {

        return myMapper.findOne();
    }

//    https://mybatis.org/mybatis-3/zh/sqlmap-xml.html
    @RequestMapping("{id}")
    public MyPojo findWithId(@PathVariable("id") int id) {

        return myMapper.findWithId(id);
    }
}
