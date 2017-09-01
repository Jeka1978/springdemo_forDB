package com.db.aop_problems;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Evegeny on 01/09/2017.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Conf27.class);
        MyService myService = context.getBean(MyService.class);
        myService.a();
    }
}
