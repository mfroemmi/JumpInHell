package com.example.jumpinhell.chars;

import com.example.jumpinhell.actions.Menu;

/**
 *
 * @author Marcel
 */
public class Door {

    public static int x, y, width = 200, height = 300;

    public static void init() {
        if (Menu.level1 == true) {
            x = 19544;
            y = 570 - height;
            if (Player.savePoint) {
                x -= Pentagram.xSavepoint;
            }
        }
        if (Menu.level2 == true) {
            x = 1650;
            y = 500 - height;
            if (Player.savePoint) {
                x -= Pentagram.xSavepoint;
            }
        }
    }

    public static void move() {
        x -= Background.bgspeedfactor;
    }
}
