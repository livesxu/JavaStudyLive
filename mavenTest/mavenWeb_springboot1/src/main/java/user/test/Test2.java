package user.test;

import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Test2 {

    @Test
    void test() {

        TestC testC = new TestC();

        TestP testP = TestProxy.createProxy(testC);

        String c = testP.methodOne("boy");

        testP.methodTwo();

        System.out.println(c);
    }

    @Test
    void test1() {

        TestC testC = new TestC();

        TestC testC1 = TestEnhancer.createEnhancer(testC);

        String c = testC1.methodOne("boy");

        testC1.methodTwo();

        System.out.println(c);

    }

}
