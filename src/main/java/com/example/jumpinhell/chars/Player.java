package com.example.jumpinhell.chars;

import com.example.jumpinhell.actions.*;
import com.example.jumpinhell.game.Gamestate;
import com.example.jumpinhell.game.Gamestate_e;
import com.example.jumpinhell.gui.Gui;
import com.example.jumpinhell.gui.Life_Creation;
import javafx.animation.AnimationTimer;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcel
 */
public class Player {

    public static int x, y, width = 100, height = 150;
    public static int speedfactor = 7;
    public static int currentplatform = 0;
    public static boolean keyflagright = false, keyflagleft = false, keyflagjump = false;
    public static boolean isJump = false, notFall = false, hitTrap = false, haveKey = false, isPause = false, savePoint = false;
    public static boolean level1Complete = false;
    public static int timerclock = 0;
    public static int isLevel = 0;
    public static int lifes, health;

    public static void init() {
        x = 300;
        y = 570 - height;
    }

    public static void move() {

        if (keyflagright) {
            if (x < Gui.width - (10 + width)) {
                x += speedfactor;
            }
        }
        if (keyflagleft) {
            if (x > 10) {
                x -= speedfactor;
            }
        }
        if (x > 10 && !keyflagright && !keyflagleft) {
            x -= Background.bgspeedfactor;
        }

        if (Menu.level1 == true) {
            x = 300;
            y = 570 - height;
        }

    }

    public static void jump() {

        if (keyflagjump && isJump == false && notFall == true) {
            isJump = true;
            speedfactor += 6;

            new AnimationTimer() {

                @Override
                public void handle(long now) {
                    if (timerclock < 20) {
                        Background.y += speedfactor;
                        Lava.y1 += speedfactor;
                        Lava.y2 += speedfactor;
                        Key.y += speedfactor;
                        Pentagram.y += speedfactor;
                        Door.y += speedfactor;
                        for (int i = 0; i < Platform_Creation.platforms.size(); i++) {
                            Platform_Creation.platforms.get(i).setY(Platform_Creation.platforms.get(i).getY() + Player.speedfactor);
                        }
                        for (int i = 0; i < LifeUp_Creation.lifeup.size(); i++) {
                            LifeUp_Creation.lifeup.get(i).setY(LifeUp_Creation.lifeup.get(i).getY() + Player.speedfactor);
                        }
                        for (int i = 0; i < Trap_Creation.traps.size(); i++) {
                            Trap_Creation.traps.get(i).setY(Trap_Creation.traps.get(i).getY() + Player.speedfactor);
                        }
                        timerclock += 1;
                    }

                    if (timerclock == 20) {
                        timerclock = 0;
                        isJump = false;
                        speedfactor -= 6;
                        keyflagjump = false;
                        stop();
                    }
                }

            }.start();

        }

    }

    public static void check_fall() {
        notFall = false;
        fall();
        if (isJump == false) {
            if (!notFall) {
                Background.y -= speedfactor + 5;
                Lava.y1 -= speedfactor + 5;
                Lava.y2 -= speedfactor + 5;
                Key.y -= speedfactor + 5;
                Pentagram.y -= speedfactor + 5;
                Door.y -= speedfactor + 5;
                for (int i = 0; i < Platform_Creation.platforms.size(); i++) {
                    Platform_Creation.platforms.get(i).setY(Platform_Creation.platforms.get(i).getY() - speedfactor - 5);
                }
                for (int i = 0; i < LifeUp_Creation.lifeup.size(); i++) {
                    LifeUp_Creation.lifeup.get(i).setY(LifeUp_Creation.lifeup.get(i).getY() - speedfactor - 5);
                }
                for (int i = 0; i < Trap_Creation.traps.size(); i++) {
                    Trap_Creation.traps.get(i).setY(Trap_Creation.traps.get(i).getY() - Player.speedfactor - 5);
                }
            }
        }
    }

    public static void fall() {
        for (int i = 0; i < Platform_Creation.platforms.size(); i++) {
            if (y + height <= Platform_Creation.platforms.get(i).getY() + Platform_Creation.platforms.get(i).getHeight() && y + height >= Platform_Creation.platforms.get(i).getY()
                    && x + width / 2 - 30 < Platform_Creation.platforms.get(i).getX() + Platform_Creation.platforms.get(i).getWidth() && x + width / 2 + 30 > Platform_Creation.platforms.get(i).getX()) {
                notFall = true;
            }
        }
    }

    public static void LifeUp() {
        for (int i = 0; i < LifeUp_Creation.lifeup.size(); i++) {
            if (Collision.rectangleCollision(x, y, width, height, LifeUp_Creation.lifeup.get(i).getX(), LifeUp_Creation.lifeup.get(i).getY(), LifeUp_Creation.lifeup.get(i).getWidth(), LifeUp_Creation.lifeup.get(i).getHeight())) {
                LifeUp_Creation.lifeup.remove(i);
                if (lifes < 6) {
                    lifes++;
                    Life_Creation.lifes.clear();
                    Life_Creation.create();
                }

            }
        }
    }

    public static void currentHealth() {
        if (health <= 0) {
            lifes--;
            Life_Creation.lifes.clear();
            Life_Creation.create();
            health = 350;
        }
    }

    public static void hitTrap() {

        if (!hitTrap) {
            for (int i = 0; i < Trap_Creation.traps.size(); i++) {
                if (Collision.rectangleCollision(x + 30, y, width - 80, height, Trap_Creation.traps.get(i).getX(), Trap_Creation.traps.get(i).getY(), Trap_Creation.traps.get(i).getWidth(), Trap_Creation.traps.get(i).getHeight())) {
                    hitTrap = true;
                    health -= 75;
                    pauseHitTrap();

                }
            }
        }
    }

    public static void hitKey() {
        if (Collision.rectangleCollision(x + 30, y, width - 80, height, Key.x, Key.y, Key.width, Key.height)) {
            haveKey = true;
        }
    }

    public static void savePoint() {
        if (Collision.rectangleCollision(x + 30, y, width - 80, height, Pentagram.x, Pentagram.y, Pentagram.width, Pentagram.height)) {
            savePoint = true;
        }
    }

    public static void inLava() {
        if (y + height >= Lava.y1 + 100) {
            if (isLevel == 1) {
                Menu.level1 = true;
            }

            if (isLevel == 2) {
                Menu.level2 = true;
            }
            Player.lifes--;
            Player.init();
            Key.init();
            Pentagram.init();
            Door.init();
            Background.init();
            Lava.init();
            Platform_Creation.remove();
            Platform_Creation.init();
            Trap_Creation.traps.clear();
            Trap_Creation.init();
            LifeUp_Creation.lifeup.clear();
            LifeUp_Creation.create();
            Life_Creation.lifes.clear();
            Life_Creation.create();
            Player.pause();
            Gamestate.state = Gamestate_e.pause;
        }
    }

    public static void pauseHitTrap() {
        Timer timer;

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                }
                hitTrap = false;

                timer.cancel();

            }
        }, 30, 30);
    }

    public static void pause() {
        isPause = true;
        Timer timer;

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                }
                x -= 10000;

                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                }
                x += 10000;

                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                }
                x -= 10000;

                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                }
                x += 10000;

                isPause = false;
                timer.cancel();

            }
        }, 30, 30);

    }

    public static void gameOver() {
        if (lifes == 0) {
            isLevel = 0;
            Gamestate.state = Gamestate_e.gameover;
            Timer timer;

            timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Gamestate.state = Gamestate_e.menu;
                    timer.cancel();
                }
            }, 30, 30);
        }
    }

    public static void level1Complete() {
        Gamestate.state = Gamestate_e.level1Complete;
        Timer timer;

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                }
                level1Complete = true;
                Gamestate.state = Gamestate_e.menu;
                timer.cancel();
            }
        }, 30, 30);
    }

    public static void level2Complete() {
        Gamestate.state = Gamestate_e.level2Complete;
        Timer timer;

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                }
                Gamestate.state = Gamestate_e.menu;
                timer.cancel();
            }
        }, 30, 30);
    }
}
