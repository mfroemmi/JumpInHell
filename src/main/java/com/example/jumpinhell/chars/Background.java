package com.example.jumpinhell.chars;

import com.example.jumpinhell.gui.Gui;

/**
 *
 * @author Marcel
 */
public class Background {

    public static int x, x2, y;
    public static int bgspeedfactor = 2;
    
    public static void init() {
        
        x = 0;
        x2 = 0;
        y = -Gui.height;       
        
    }
    
    public static void move() {
        
        x -= bgspeedfactor;
        x2 -= bgspeedfactor - 1;
        
        /**if (Player.keyflagright) {
            if (Player.x >= Gui.width / 2) {
                x -= Player.speedfactor;
            }
        }*/
        
        if (x <= -Gui.width) {
            x = 0;
        }
        
        if (x2 <= -Gui.width) {
            x2 = 0;
        }

    }

}
