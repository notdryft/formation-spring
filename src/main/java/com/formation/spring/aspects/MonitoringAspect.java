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

    @Around("execution(* com.formation.spring.dao.*.*(..))")
    public Object aroundAnyDaoMethod(ProceedingJoinPoint jp) {
        double debut = System.currentTimeMillis();

        Object object;
        try {
            object = jp.proceed();
        } catch (Throwable throwable) {
            return null;
        }

        double fin = System.currentTimeMillis();
        double delta = fin - debut;
        System.out.println("! Monitor: execution(" + jp.getSignature() + ") in " + delta + "ns");

        return object;
    }
}
