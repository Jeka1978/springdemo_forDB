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

public abstract class ColorFrame extends JFrame {
    private Color color;


    private Random random = new Random();


    @PostConstruct
    private void init(){
        setSize(150,150);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void moveToRandomLocation() {
        color = getColorBean();
        setLocation(random.nextInt(1500),random.nextInt(900));
        getContentPane().setBackground(color);
        repaint();
    }

    protected abstract Color getColorBean() ;
}













