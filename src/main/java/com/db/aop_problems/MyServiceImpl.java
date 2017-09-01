package com.db.aop_problems;

import com.db.quoters.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Evegeny on 01/09/2017.
 */
@Service
public class MyServiceImpl implements MyService {
    @Autowired
    private MyService proxy;

    @Override
    @Transaction
    public void a() {
        System.out.println("AAAAAAAAAAAAAA");
        proxy.b();
    }

    @Override
    @Transaction
    public void b() {
        System.out.println("BBBBBBBBBBBBbb");
    }
}
