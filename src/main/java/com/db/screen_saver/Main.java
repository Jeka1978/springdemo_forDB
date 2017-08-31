package com.db.screen_saver;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Evegeny on 31/08/2017.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.db.screen_saver");
        while (true) {
            context.getBean(ColorFrame.class).moveToRandomLocation();
            Thread.sleep(200);
        }
    }
}
