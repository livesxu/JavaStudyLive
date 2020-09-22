package web.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController//用于写API，给外部提供数据，一般返回json数据
//@EnableAutoConfiguration
public class HelloController {

    @RequestMapping("hello")
    @ResponseBody
    public String hello(){

        int t = 10/0;
        return "Hello,spring boot test one!";
    }

    @RequestMapping("helloLogin")
    @ResponseBody//响应体，自动返回json格式字符串
    public Map<String,Object> login(String username,String password) {

        Map<String,Object> map = new HashMap<>();

        map.put("name","bobo");
        map.put("password","123");

        return map;
    }

//    public static void main(String[] args) {
//
//        SpringApplication.run(HelloController.class,args);
//    }

}
