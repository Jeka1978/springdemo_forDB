package com.db.screen_saver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.*;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Evegeny on 31/08/2017.
 */

@Service
public class ColorFrame extends JFrame {
    @Autowired
    private Color color;


    private Random random = new Random();


    @PostConstruct
    private void init(){
        System.out.println(color.getClass());
        System.out.println(color.toString());
        System.out.println(color.toString());
        System.out.println(color.toString());
        System.out.println(color.toString());
        System.out.println(color.toString());
        setSize(150,150);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void moveToRandomLocation() {
        setLocation(random.nextInt(1500),random.nextInt(900));
        getContentPane().setBackground(color);
        repaint();
    }

}













