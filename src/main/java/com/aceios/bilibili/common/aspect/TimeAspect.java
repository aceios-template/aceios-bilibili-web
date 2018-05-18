package com.aceios.bilibili.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 配置 AOP 切面
 */
@Aspect
@Component
public class TimeAspect {

    @Around("execution(* com.aceios.bilibili.test.web.FastJsonController..*(..))")
    public Object method(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("=====Aspect处理=======");
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            System.out.println("参数为:" + arg);
        }
        long start = System.currentTimeMillis();
        Object object = pjp.proceed();
        System.out.println("Aspect 耗时:" + (System.currentTimeMillis() - start));
        return object;
    }
}