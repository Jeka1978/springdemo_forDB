package com.db.qualifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by Evegeny on 31/08/2017.
 */
@Service
public class MainServiceImpl implements MainService {

    @Autowired
    private Dao mainDao;

    @Autowired
    private Dao backupDao;

    @Override
    @Scheduled(cron = "1/1 * * * * ?")
    public void doWork() {
        System.out.println("Working...");
        mainDao.crud();
    }

    @Override
    @Scheduled(cron = "1/3 * * * * ?")
    public void doBackup() {
        System.out.println("backuping...");
        backupDao.crud();
    }
}




