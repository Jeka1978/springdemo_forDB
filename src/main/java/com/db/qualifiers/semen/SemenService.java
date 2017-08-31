package com.db.qualifiers.semen;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by Evegeny on 31/08/2017.
 */
@Service
public class SemenService {
    @PostConstruct
    public void init(){
        System.out.println("Семен всегда ест один, даже когда рядом есть другие люди...");
    }
}
