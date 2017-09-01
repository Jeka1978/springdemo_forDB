package com.db.quoters;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Evegeny on 30/08/2017.
 */

@Component
public class TerminatorQuoter implements Quoter {


    private List<String> messages;

    @Value("${terminator}")
    private void setMessages(String[] messages, @Value("${JAVA_HOME}") String javaHome) {
        System.out.println("javaHome = " + javaHome);
        this.messages = Arrays.asList(messages);
    }

    @Override
    public void sayQuote() {
        messages.forEach(System.out::println);
        throw new DBRuntimeException("я встретил сам себя");
    }


    public void killAll() {
        System.out.println("your are terminated....");
    }
}
