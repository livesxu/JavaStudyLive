package user.test;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestEnhancer {

    public static TestC createEnhancer(TestC testC) {

        //创建增强对象
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(TestC.class);
        //设置回调【拦截】
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

                System.out.println("enhancer ..");

                //执行方法
//                Object object = method.invoke(testC,objects);
                //执行代理类的方法（目标类和代理类式父子关系）
                Object object = methodProxy.invokeSuper(o,objects);
                return object;
            }
        });
        TestC testC1 = (TestC)enhancer.create();

        return testC1;
    }
}
