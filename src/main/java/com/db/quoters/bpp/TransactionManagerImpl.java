package com.db.quoters.bpp;

import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 31/08/2017.
 */
@Component
public class TransactionManagerImpl implements TransactionManager {
    @Override
    public void open() {
        System.out.println("****TRANSACTION OPENED ************");
    }

    @Override
    public void close() {
        System.out.println("****TRANSACTION CLOSED ************");
    }

    @Override
    public void rollback() {

        System.out.println("ROLLED BACK");
    }
}
