package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//一般用于写后台，有页面
@RequestMapping("users")
public class UserTestController {

    @RequestMapping("userPage")
    public String page(Model model) {

        return "users/userPage";
    }
}
