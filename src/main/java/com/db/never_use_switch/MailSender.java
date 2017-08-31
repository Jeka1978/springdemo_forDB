package com.db.never_use_switch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Evegeny on 31/08/2017.
 */
@Service
public class MailSender {

    private Map<Integer, MailGenerator> map = new HashMap<>();

    @Autowired
    public void initMap(Collection<MailGenerator> mailGenerators){
        for (MailGenerator mailGenerator : mailGenerators) {
            int mailCode = mailGenerator.mailCode();
            if (map.containsKey(mailCode)) {
                throw new IllegalStateException(mailCode + " already in use");
            }
            map.put(mailCode, mailGenerator);
        }
    }

    @Autowired
    private MailDao dao;


    @Scheduled(cron = "1/1 * * * * ?")
    public void sendMail() {
        int mailCode = dao.getMailCode();
        MailGenerator mailGenerator = map.get(mailCode);
        if (mailGenerator == null) {
            throw new UnsupportedOperationException(mailCode + " not supported yet");
        }
        String html = mailGenerator.generateHtml();
        send(html);
    }

    private void send(String html) {
        System.out.println("html = " + html);
    }
}



