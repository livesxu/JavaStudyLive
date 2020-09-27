package com.livesxu.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class Test1 {

    @RequestMapping("helloPage")
    public String helloPage() {

        return "helloPage";
    }
}
