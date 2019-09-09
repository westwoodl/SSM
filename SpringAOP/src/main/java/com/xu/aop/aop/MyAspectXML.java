package com.xu.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 切面类
 */
public class MyAspectXML {

    /**
     * 前置通知
     * @param joinPoint
     */
    public void check(JoinPoint joinPoint){
        System.out.println("权限校验:"+joinPoint);
    }

    /**
     * 后置通知
     */
    public void writeAft(JoinPoint joinPoint, Object result){
        System.out.println(result+"删除日志:" + joinPoint);
    }

    /**
     * 环绕通知
     */
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
    public void afterThrowing(Throwable ex){
        System.out.println("异常通知"+ex.getMessage());
    }

    /**
     * 最终通知
     */
    public void finalli(){
        System.out.println("最终通知");
    }
}
