package com.db.screen_saver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

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
    @Autowired
    private ApplicationContext context;


    @Bean
    public ColorFrame colorFrame() {
        return new ColorFrame() {
            @Override
            protected Color getColorBean() {
                return color();
            }
        };
    }


    @Scope("prototype")
    @Bean
    public Color color() {
        Color color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));

        return color;
    }

}


















