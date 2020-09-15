package user;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Aspect
public class MyAspect {

//    声明一个公共的切入点表达式
    @Pointcut("execution(* user.service.UserServiceImpl.*(..))")
    public void myPointCut (){}

    @Before("execution(* user.service.UserServiceImpl.*(..))")
    public void myBefore (JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName());
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println(args.toString());
        System.out.println("aspect 前置通知");
    }

    @After(value = "myPointCut()")
    public void myAfter () {

        System.out.println("aspect 后置通知");
    }

    @Around(value = "myPointCut()")
    public Object myAround (ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("aspect 环绕通知 - 前");
        Object object = proceedingJoinPoint.proceed();
        System.out.println("aspect 环绕通知 - 后");

        return object;
    }

    @AfterThrowing(value = "myPointCut()",throwing = "throwable")
    public void myThrowing (JoinPoint joinPoint, Throwable throwable) {

        System.out.println("异常通知" + throwable.getMessage());
    }

    @AfterReturning(value = "myPointCut()", returning = "result")
    public void myReturn (JoinPoint joinPoint, Object result) {

        System.out.println("aspect 返回通知");
    }
}
