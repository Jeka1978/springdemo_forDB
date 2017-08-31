package com.db.qualifiers;

import org.springframework.stereotype.Repository;

import static com.db.qualifiers.DBType.ORACLE;

/**
 * Created by Evegeny on 31/08/2017.
 */
@DBRepo(ORACLE)
public class OracleDao implements Dao {
    @Override
    public void crud() {
        System.out.println("Saving to ORACLE");
    }
}
