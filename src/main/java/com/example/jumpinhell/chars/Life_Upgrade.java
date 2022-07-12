package com.example.jumpinhell.chars;

import com.example.jumpinhell.actions.LifeUp_Creation;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcel
 */
public class Life_Upgrade {

    private int x, y, width, height;
    public static boolean pulsetimer = false;

    public Life_Upgrade(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public static void move() {

        for (int i = 0; i < LifeUp_Creation.lifeup.size(); i++) {
            LifeUp_Creation.lifeup.get(i).setX(LifeUp_Creation.lifeup.get(i).getX() - Background.bgspeedfactor);
        }

    }

    public static void pulse() {
        Timer timer;

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                for (int j = 0; j < 5; j++) {
                    for (int i = 0; i < LifeUp_Creation.lifeup.size(); i++) {
                        LifeUp_Creation.lifeup.get(i).setWidth(LifeUp_Creation.lifeup.get(i).getWidth() + 2);
                        LifeUp_Creation.lifeup.get(i).setHeight(LifeUp_Creation.lifeup.get(i).getHeight() + 2);
                        LifeUp_Creation.lifeup.get(i).setX(LifeUp_Creation.lifeup.get(i).getX() - 1);
                        LifeUp_Creation.lifeup.get(i).setY(LifeUp_Creation.lifeup.get(i).getY() - 1);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                for (int j = 0; j < 5; j++) {
                    for (int i = 0; i < LifeUp_Creation.lifeup.size(); i++) {
                        LifeUp_Creation.lifeup.get(i).setWidth(LifeUp_Creation.lifeup.get(i).getWidth() - 2);
                        LifeUp_Creation.lifeup.get(i).setHeight(LifeUp_Creation.lifeup.get(i).getHeight() - 2);
                        LifeUp_Creation.lifeup.get(i).setX(LifeUp_Creation.lifeup.get(i).getX() + 1);
                        LifeUp_Creation.lifeup.get(i).setY(LifeUp_Creation.lifeup.get(i).getY() + 1);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                pulsetimer = false;
                timer.cancel();
            }
        }, 30, 30);

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
