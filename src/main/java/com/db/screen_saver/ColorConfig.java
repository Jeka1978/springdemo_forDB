package com.db.screen_saver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.annotation.PostConstruct;
import java.awt.*;
import java.util.Random;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

/**
 * Created by Evegeny on 31/08/2017.
 */
@Configuration
@ComponentScan
public class ColorConfig {
    private Random random = new Random();

    @Value("${M2_HOME}")
    private String m2home;


    @PostConstruct
    public void init() {
        System.out.println("m2home = " + m2home);
    }


    @Bean
    @Scope(value = "5seconds", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Color color() {
        Color color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));

        return color;
    }

}


















