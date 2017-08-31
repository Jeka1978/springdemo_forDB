package com.db.qualifiers;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by Evegeny on 31/08/2017.
 */
@Configuration
@ComponentScan(basePackages = "com.db.qualifiers")
@EnableScheduling
public class Config {
}
