package com.db.quoters;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Evegeny on 30/08/2017.
 */
@Component
public class TalkingRobotImpl implements TalkingRobot {


    @Autowired
    @Book
    public TalkingRobotImpl(List<Quoter> quoters) {
        this.quoters = quoters;
    }

    private List<Quoter> quoters = Arrays.asList((Quoter) () -> System.out.println("this is default quote"));

    @Override
    @PostConstruct
    public void talk() {
        for (Quoter quoter : quoters) {
            quoter.sayQuote();
        }
    }


}



