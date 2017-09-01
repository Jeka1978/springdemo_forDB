package com.db.validation_example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.annotation.PostConstruct;

/**
 * Created by Evegeny on 01/09/2017.
 */
@Configuration
@ComponentScan
public class Config28 {
    @PostConstruct
    public void init(){
        System.out.println("INIT CINFIG");
    }

    @Bean
    public LocalValidatorFactoryBean validatorFactoryBean(){
        return new LocalValidatorFactoryBean();
    }
}
