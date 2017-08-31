package com.db.quoters;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 30/08/2017.
 */
@Component
public class ShakespeareQuoter implements Quoter {
    @Value("${shake}")
    private String message;

    @InjectRandomInt(min = 3, max = 6)
    private int repeat;

    @Override
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }
}
