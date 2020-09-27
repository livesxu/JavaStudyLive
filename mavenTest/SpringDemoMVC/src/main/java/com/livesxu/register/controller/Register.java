package com.livesxu.register.controller;

import com.livesxu.pojo.User;
import com.livesxu.register.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("register")
public class Register {

    @Autowired
    private RegisterService registerService;

    @RequestMapping("user")
    @ResponseBody
    public void registerUser(@RequestBody User user) {

        registerService.registerUser(user);

        return;
    }
}
