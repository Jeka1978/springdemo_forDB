package com.db.quoters;

import lombok.Setter;

import java.util.List;

/**
 * Created by Evegeny on 30/08/2017.
 */
public class TerminatorQuoter implements Quoter {
    @Setter
    private List<String> messages;

    @Override
    public void sayQuote() {
        messages.forEach(System.out::println);
    }
}
