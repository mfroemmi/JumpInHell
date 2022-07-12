/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jumpinhell.chars;

import com.example.jumpinhell.actions.Platform_Creation;

/**
 *
 * @author Marcel
 */
public class Platforms {

    private int x, y, width, height, speed;

    public Platforms(int xread, int yread, int widthread, int heightread) {

        x = xread;
        y = yread;
        width = widthread;
        height = heightread;

    }

    public static void move() {

        for (int i = 0; i < Platform_Creation.platforms.size(); i++) {
            Platform_Creation.platforms.get(i).setX(Platform_Creation.platforms.get(i).getX() - Background.bgspeedfactor);
        }

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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}
