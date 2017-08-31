package com.db.quoters.bpp;

/**
 * Created by Evegeny on 31/08/2017.
 */
public interface TransactionManager {
    void open();
    void close();
    void rollback();
}
