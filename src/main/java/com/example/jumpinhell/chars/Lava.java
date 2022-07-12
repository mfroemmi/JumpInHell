package com.example.jumpinhell.chars;

import com.example.jumpinhell.gui.Gui;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Marcel
 */
public class Lava {
    
    public static int x = 0, y1 = Gui.height - 110, y2 = y1, width = Gui.width, height = 200;
    public static int timerclock, timerclock2;
    public static boolean lavatimer = false, lavatimer2 = false;
    
    public static void init() {
        x = 0; 
        y1 = Gui.height - 110; 
        y2 = y1;
    }
    
    public static void move() {
         Timer timer;

            timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {

                    if (timerclock < 30) {
                        y1 -= 1;
                        timerclock += 1;
                    }
                    
                    if (timerclock >= 30) {
                        y1 += 1;
                        timerclock += 1;
                    }

                    if (timerclock == 60) {
                        timerclock = 0;
                        lavatimer = false;
                        timer.cancel();
                    }
                }
            }, 30, 20);
    }
    
    public static void move2() {
         Timer timer;

            timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {

                    if (timerclock2 < 30) {
                        y2 -= 1;
                        timerclock2 += 1;
                    }
                    
                    if (timerclock2 >= 30) {
                        y2 += 1;
                        timerclock2 += 1;
                    }

                    if (timerclock2 == 60) {
                        timerclock2 = 0;
                        lavatimer2 = false;
                        timer.cancel();
                    }
                }
            }, 30, 30);
    }
    
}
