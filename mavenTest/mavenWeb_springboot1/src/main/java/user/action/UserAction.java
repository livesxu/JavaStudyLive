package user.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import user.service.UserService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Controller
//@Scope("prototype") //多例，默认单例
public class UserAction {

//    @Autowired
//    @Qualifier("userService")
    @Resource(name = "userService")
    private UserService userService;

    public void addUser(){

        System.out.println("用户操作添加用户->");
        userService.addUser();
    }

    @PostConstruct
    private void myInit() {

        System.out.println("自定义初始化方法");
    }

    @PreDestroy
    private void myDestroy() {

        System.out.println("自定义销毁");
    }
}
