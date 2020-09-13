package web.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HelloController {

    @RequestMapping("hello")
    @ResponseBody
    public String hello(){

        return "Hello,spring boot test one!";
    }

    public static void main(String[] args) {

        SpringApplication.run(HelloController.class,args);
    }

}
