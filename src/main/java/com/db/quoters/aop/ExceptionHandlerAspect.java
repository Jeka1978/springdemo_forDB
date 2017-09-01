package com.db.quoters.aop;

import com.db.quoters.DBRuntimeException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/**
 * Created by Evegeny on 01/09/2017.
 */
@Component
@Aspect
@PropertySource("classpath:mail.properties")
public class ExceptionHandlerAspect {
    @Value("${dbaMails}")
    private String[] mails;

    private Map<DBRuntimeException, Void> map = new WeakHashMap<>();


    @AfterThrowing(pointcut = "execution(* com.db.quoters.*.*(..))",throwing = "ex")
    public void handleDBException(DBRuntimeException ex) throws Throwable {
        if (!map.containsKey(ex)) {
            for (String mail : mails) {
                System.out.println("mail = " + mail+":"+ex.getMessage());
            }
            map.put(ex,null);
        }
    }

}











