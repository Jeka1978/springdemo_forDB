package com.db.quoters;

import lombok.Setter;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Evegeny on 30/08/2017.
 */
public class TalkingRobotImpl implements TalkingRobot {

    @Setter
    private List<Quoter> quoters;
    @Override
    @PostConstruct
    public void talk() {
        for (Quoter quoter : quoters) {
            quoter.sayQuote();
        }
    }


}
