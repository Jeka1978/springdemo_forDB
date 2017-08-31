package com.db.never_use_switch;

import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 31/08/2017.
 */
@Component("3")
public class FootballMailGenerator implements MailGenerator {
    @Override
    public String generateHtml() {
        return "Зенит Чемпион!!!";
    }
}
