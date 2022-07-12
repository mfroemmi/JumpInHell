package com.example.jumpinhell.actions;

import com.example.jumpinhell.chars.Player;
import com.example.jumpinhell.draw.Draw_Main;
import com.example.jumpinhell.game.Gamestate;
import com.example.jumpinhell.game.Gamestate_e;

/**
 *
 * @author Marcel
 */
public class Menu {

    public static boolean level1 = false, level2 = false;

    public static void klick(int x, int y) {

        if (Gamestate.state == Gamestate_e.menu) {

            // Klick Button Resume
            if (Player.isLevel > 0) {
                if (x > Draw_Main.xR - Draw_Main.widthR / 2 && x < Draw_Main.xR - Draw_Main.widthR / 2 + Draw_Main.widthR
                        && y > Draw_Main.yR && y < Draw_Main.yR + Draw_Main.heightR) {
                    Gamestate.state = Gamestate_e.ingame;
                }

            }

            // Klick Button Level 1
            if (x > Draw_Main.x1 - Draw_Main.width1 / 2 && x < Draw_Main.x1 - Draw_Main.width1 / 2 + Draw_Main.width1
                    && y > Draw_Main.y1 && y < Draw_Main.y1 + Draw_Main.height1) {
                Player.isLevel = 1;
                level1 = true;
                Init.InitMenu();
            }

            // Klick Button Level 2
            if (Player.level1Complete == true) {
                if (x > Draw_Main.x2 - Draw_Main.width2 / 2 && x < Draw_Main.x2 - Draw_Main.width2 / 2 + Draw_Main.width2
                        && y > Draw_Main.y2 && y < Draw_Main.y2 + Draw_Main.height2) {
                    Player.isLevel = 2;
                    level2 = true;
                    Init.InitMenu();
                }
            }

        }

    }

}
