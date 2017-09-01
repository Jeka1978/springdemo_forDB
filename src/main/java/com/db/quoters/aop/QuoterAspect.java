package com.db.quoters.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 31/08/2017.
 */
@Aspect
@Component
public class QuoterAspect {


    @Before("execution(* com.db..*.say*(..))")
//    @Before("@annotation(com.db.quoters.Transaction)")
    public void handleSayMethods(JoinPoint jp) {
        System.out.println("А теперь цитата: "+jp.getTarget().getClass().getName());
    }

}















