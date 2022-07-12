package com.example.jumpinhell.chars;

/**
 *
 * @author Marcel
 */
public class Pentagram {

    public static int x, y, width = 100, height = 100, xSavepoint;

    public static void playerSavepointInit() {
        xSavepoint = x - Player.x;
    }

    public static void init() {
        x = 11024;
        y = 396;
        if (Player.savePoint) {
            x -= Pentagram.xSavepoint;
        } 
    }

    public static void move() {
        x -= Background.bgspeedfactor;
    }

}
