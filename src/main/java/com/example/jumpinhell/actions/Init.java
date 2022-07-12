package com.example.jumpinhell.actions;

import com.example.jumpinhell.chars.*;
import com.example.jumpinhell.game.Gamestate;
import com.example.jumpinhell.game.Gamestate_e;
import com.example.jumpinhell.gui.Life_Creation;

/**
 *
 * @author Marcel
 */
public class Init {

    public static void InitMenu() {
        Player.lifes = 3;
        Player.health = 350;
        Player.haveKey = false;
        Player.savePoint = false;
        Key.init();
        Pentagram.init();
        Door.init();
        Player.init();
        Pentagram.playerSavepointInit();
        Background.init();
        Lava.init();
        Platform_Creation.remove();
        Platform_Creation.init();
        Trap_Creation.traps.clear();
        Trap_Creation.init();
        Life_Creation.lifes.clear();
        Life_Creation.create();
        LifeUp_Creation.lifeup.clear();
        LifeUp_Creation.create();
        Player.pause();
        Gamestate.state = Gamestate_e.pause;
    }

}
