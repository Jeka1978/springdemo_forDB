package com.db.quoters.bpp;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.FactoryBean;

import java.util.Random;

/**
 * Created by Evegeny on 31/08/2017.
 */
public class IntegerFactory implements FactoryBean<Integer> {
    private Random random = new Random();
    private final int max;

    public IntegerFactory(int max) {
        this.max = max;
    }

    @Override
    public Integer getObject() throws Exception {
        return random.nextInt(max);
    }

    @Override
    public Class<?> getObjectType() {
        return Integer.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
