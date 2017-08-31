package com.db.never_use_switch;

import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 31/08/2017.
 */
@Component("1")
public class WelcomeMailGenerator implements MailGenerator {
    @Override
    public String generateHtml() {
        return "WELCOME";
    }
}
