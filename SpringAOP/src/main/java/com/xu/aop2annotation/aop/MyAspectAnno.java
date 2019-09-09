package com.xu.aop2annotation.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 切面类
 */
@Aspect
public class MyAspectAnno {

    @Before(value = "execution(* com.xu.aop2annotation.aop.OrderDao.save(..))")
    public void before(){
        System.out.println("前置通知");
    }

    @AfterReturning(value = "execution(* com.xu.aop2annotation.aop.OrderDao.delete(..))", returning = "result")
    public void after(Object result){
        System.out.println("后置通知"+result);
    }

    /**
     * 环绕通知
     */
    @Around("execution(* com.xu.aop2annotation.aop.OrderDao.update(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("还绕前");
        Object obj = proceedingJoinPoint.proceed();
        System.out.println(obj);
        System.out.println("还绕后");
        return obj;
    }

    /**
     * 异常抛出通知
     */
    @AfterThrowing(value = "execution(* com.xu.aop2annotation.aop.OrderDao.find(..))", throwing = "ex")
    public void afterThrowing(Throwable ex){
        System.out.println("异常通知"+ex.getMessage());
    }

    /**
     * 最终通知
     */
    @After(value = "MyAspectAnno.pointcutFind()")
    public void finalli(){
        System.out.println("最终通知");
    }

    /**
     * 切入点的注解
     */
    @Pointcut(value = "execution(* com.xu.aop2annotation.aop.OrderDao.find(..))")
    private void pointcutFind(){}

}
