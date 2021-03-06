package com.db.quoters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 30/08/2017.
 */
@Component
@Book
public class ShakespeareQuoter implements Quoter {
    @Value("${shake}")
    private String message;

    @InjectRandomInt(min = 3, max = 6)
    private int repeat;

    @Override
    @PostProxyPostConstruct
    public void sayQuote() {
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$");
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }
}
