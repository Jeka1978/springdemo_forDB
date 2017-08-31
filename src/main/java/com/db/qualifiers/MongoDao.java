package com.db.qualifiers;

import org.springframework.stereotype.Repository;

import static com.db.qualifiers.DBType.MONGO;

/**
 * Created by Evegeny on 31/08/2017.
 */
@DBRepo(MONGO)
public class MongoDao implements Dao {
    @Override
    public void crud() {
        System.out.println("Saving to MONGO");
    }
}
