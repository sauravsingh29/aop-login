package com.saurav.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LogAop {

    // replace sout with logger.
    @Around("within(com.saurav.api..*) || within(com.saurav.dao..*) || within(com.saurav.service..*)")
    public Object aopLogging(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String method = joinPoint.getSignature().getName();
        String params = Arrays.toString(joinPoint.getArgs());
        System.out.println("Executing method [ "+ method + " ] declared at [ " + className + " ] with params [ "+ params + " ].");
        Object proceed = joinPoint.proceed();
        System.out.println("Finished method [ "+ method + " ] declared at [ " + className + " ] with params [ "+ params + " ].");
        return proceed;
    }

    @AfterThrowing(pointcut = "within(com.saurav.api..*)", throwing = "e")
    public void logException(JoinPoint joinPoint, Throwable e){
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String method = joinPoint.getSignature().getName();
        String params = Arrays.toString(joinPoint.getArgs());
        System.err.println("Exception at method [ "+ method + " ] declared at [ "+ className + " ] with params [ "+ params + " ]. Exception "+ e.getLocalizedMessage());
    }
}
