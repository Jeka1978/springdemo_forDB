package com.db.qualifiers;

import org.springframework.stereotype.Repository;

/**
 * Created by Evegeny on 31/08/2017.
 */
@Repository
public class MongoDao implements Dao {
    @Override
    public void crud() {
        System.out.println("Saving to MONGO");
    }
}
