package com.db.quoters;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by Evegeny on 31/08/2017.
 */
@Configuration
@PropertySource("classpath:quotes.properties")
@ComponentScan
@EnableAspectJAutoProxy
public class QuoterConfig {

//    @Bean
    public Quoter str(){
        return new Quoter() {
            @Override
            public void sayQuote() {
                System.out.println("И чё???");
            }
        };
    }


}
