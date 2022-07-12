/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jumpinhell.actions;

import com.example.jumpinhell.chars.Door;
import com.example.jumpinhell.chars.Player;
import com.example.jumpinhell.game.Gamestate;
import com.example.jumpinhell.game.Gamestate_e;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Marcel
 */
public class KeyPressed implements EventHandler<KeyEvent> {

    @Override
    public void handle(KeyEvent e) {

        switch (e.getCode()) {

            case ESCAPE:
                if (!Player.isPause) {
                    if (Gamestate.state == Gamestate_e.menu) {

                    } else {
                        Gamestate.state = Gamestate_e.menu;
                    }
                    break;
                }

            case RIGHT:
                Player.keyflagright = true;
                break;

            case LEFT:
                Player.keyflagleft = true;
                break;

            case SPACE:
                if (Gamestate.state == Gamestate_e.ingame) {
                    Player.keyflagjump = true;
                    break;
                }

            case ENTER:
                if (Gamestate.state == Gamestate_e.ingame) {
                    if (Player.haveKey) {
                        if (Collision.rectangleCollision(Player.x + 30, Player.y, Player.width - 80, Player.height, Door.x, Door.y, Door.width, Door.height)) {
                            if (Player.isLevel == 1) {
                                Player.level1Complete();
                            }
                            if (Player.isLevel == 2) {
                                Player.level2Complete();
                            }
                            break;
                        }

                    }
                }
        }

    }

}
