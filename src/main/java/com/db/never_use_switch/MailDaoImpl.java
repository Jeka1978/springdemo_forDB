package com.db.never_use_switch;

import org.springframework.stereotype.Repository;

import java.util.Random;

/**
 * Created by Evegeny on 31/08/2017.
 */
@Repository
public class MailDaoImpl implements MailDao {
    private Random random = new Random();
    @Override
    public int getMailCode() {
        return random.nextInt(3)+1;
    }
}
