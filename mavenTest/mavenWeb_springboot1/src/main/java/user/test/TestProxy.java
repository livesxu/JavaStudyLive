package user.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestProxy {

    public static TestP createProxy(TestC testC) {

        TestP testP = (TestP)Proxy.newProxyInstance(testC.getClass().getClassLoader(), testC.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                System.out.println("proxy ..");

                return method.invoke(testC,args);
            }
        });

        return testP;
    }
}
