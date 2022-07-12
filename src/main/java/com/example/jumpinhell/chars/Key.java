package com.example.jumpinhell.chars;

import com.example.jumpinhell.actions.Menu;

/**
 *
 * @author Marcel
 */
public class Key {

    public static int x, y, width = 100, height = 50;

    public static void init() {
        if (Menu.level1 == true) {
            x = 16192;
            y = 100;
            if (Player.savePoint) {
                x -= Pentagram.xSavepoint;
            }
        }
        if (Menu.level2 == true) {
            x = 1200;
            y = 300;
            if (Player.savePoint) {
                x -= Pentagram.xSavepoint;
            }
        }
    }

    public static void move() {
        x -= Background.bgspeedfactor;
    }

}
