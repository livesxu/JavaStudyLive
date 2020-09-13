package user.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import user.action.UserAction;

import java.lang.reflect.Method;

public class Test1 {

    @Test
    public void test () throws Exception {

        //注意加载路径!!! 这是target/classes下的路径！！！
        ApplicationContext context = new ClassPathXmlApplicationContext("beans1.xml");
//        ApplicationContext context1 = new FileSystemXmlApplicationContext("绝对路径");

        UserAction userAction = context.getBean(UserAction.class);//通过class加载
//        UserAction userAction1 = (UserAction) context.getBean("userAction");//通过id加载

        userAction.addUser();

        //强制关闭
        Method method = context.getClass().getMethod("close");
        method.invoke(context);
    }
}
