package com.db.aop_problems;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 01/09/2017.
 */
@Component
@Aspect
public class MyAspect {

    @Pointcut("@annotation(com.db.quoters.Transaction)")
    public void transactionMethod(){}


    @Around("transactionMethod()")
    public Object handleTransactionMethods(ProceedingJoinPoint jp) throws Throwable {
        Object[] args = jp.getArgs();
        System.out.println("***********Transaction Opened************");
        Object retVal = jp.proceed(args);
        System.out.println("***********Transaction closed************");
        return retVal;
    }












}
