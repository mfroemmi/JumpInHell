/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clocks;

import chars.Background;
import chars.Lava;
import chars.Life_Upgrade;
import chars.Platforms;
import chars.Player;
import game.Gamestate;
import game.Gamestate_e;
import gui.Gui;
import javafx.animation.AnimationTimer;
import javafx.util.Duration;

/**
 *
 * @author Marcel
 */
public class Mainclock_Gui {

    public static AnimationTimer maintimer;

    public static void Timer() {

        maintimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                try {
                    Gui.gc_main.clearRect(0, 0, Gui.width, Gui.height);
                    Gui.dm.draw(Gui.gc_main);
                    if (!Lava.lavatimer) {
                        Lava.lavatimer = true;
                        Lava.move();
                    }
                    if (!Lava.lavatimer2) {
                        Lava.lavatimer2 = true;
                        Lava.move2();
                    }
                    if (!Life_Upgrade.pulsetimer) {
                        Life_Upgrade.pulsetimer = true;
                        Life_Upgrade.pulse();
                    }

                } catch (Exception e) {
                    System.out.println("Main timer error");
                }
            }
        };
        maintimer.start();

    }

}
