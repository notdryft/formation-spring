package com.formation.spring.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: notdryft
 * Date: 5/14/13
 * Time: 10:47 PM
 */
@Aspect
@Component
public class MonitoringAspect {

    @Around("execution(* com.formation.spring.business.dao.*.*(..))")
    public Object aroundAnyDaoMethod(ProceedingJoinPoint jp) throws Throwable {
        double debut = System.nanoTime();

        Object object = jp.proceed();

        double fin = System.nanoTime();
        double delta = (fin - debut) / 1e6;
        System.out.println("! Monitor: execution(" + jp.getSignature() + ") in " + delta + "ms");

        return object;
    }
}
