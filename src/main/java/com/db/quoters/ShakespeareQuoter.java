package com.db.quoters;

import lombok.Setter;

/**
 * Created by Evegeny on 30/08/2017.
 */
public class ShakespeareQuoter implements Quoter {
    @Setter
    private String message;

    @Override
    public void sayQuote() {
        System.out.println(message);
    }
}
