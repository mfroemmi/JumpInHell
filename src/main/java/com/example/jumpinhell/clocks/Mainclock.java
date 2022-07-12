package com.example.jumpinhell.clocks;

import com.example.jumpinhell.actions.Trap_Creation;
import com.example.jumpinhell.chars.*;
import com.example.jumpinhell.game.Gamestate;
import com.example.jumpinhell.game.Gamestate_e;
import javafx.animation.AnimationTimer;
import javafx.util.Duration;

/**
 *
 * @author Marcel
 */
public class Mainclock {

    public static AnimationTimer maintimer;

    public static void Timer() {

        maintimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                try {
                    if (Gamestate.state == Gamestate_e.pause) {
                        Pause.pauseTimerForDuration(Mainclock.maintimer, Duration.seconds(3));
                        Gamestate.state = Gamestate_e.ingame;
                    }
                    
                    if (Gamestate.state == Gamestate_e.ingame) {
                        Player.jump();
                        Player.move();
                        Player.check_fall();
                        Player.LifeUp();
                        Player.currentHealth();
                        Player.hitTrap();
                        Player.hitKey();
                        Player.savePoint();
                        Player.inLava();
                        Player.gameOver();
                        Platforms.move();
                        Life_Upgrade.move();
                        Key.move();
                        Pentagram.move();
                        Door.move();
                        
                        
                        Trap_Creation.move();
                        Background.move();  
                    }

                } catch (Exception e) {
                    System.out.println("Main timer error");
                }
            }
        };maintimer.start();

    }
}
