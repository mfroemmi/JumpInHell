package com.example.jumpinhell.draw;

import com.example.jumpinhell.actions.LifeUp_Creation;
import com.example.jumpinhell.actions.Platform_Creation;
import com.example.jumpinhell.actions.Trap_Creation;
import com.example.jumpinhell.chars.*;
import com.example.jumpinhell.game.Gamestate;
import com.example.jumpinhell.game.Gamestate_e;
import com.example.jumpinhell.gui.Gui;
import com.example.jumpinhell.gui.Image_Loader;
import com.example.jumpinhell.gui.Life;
import com.example.jumpinhell.gui.Life_Creation;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Marcel
 */
public class Draw_Main {

    //Button Resume
    public static int xR = Gui.width / 2, yR = 300, widthR = 400, heightR = 100;
    //Button Level 1
    public static int x1 = Gui.width / 2, y1 = 450, width1 = 400, height1 = 100;
    //Button Level 2
    public static int x2 = Gui.width / 2, y2 = 575, width2 = 400, height2 = 100;

    public void draw(GraphicsContext g) {

        g.setFill(Color.RED);
        g.fillRect(0, 0, Gui.width, Gui.height);
        
        g.drawImage(Image_Loader.ibg2, Background.x2, Background.y, Gui.width, Gui.height * 2);
        g.drawImage(Image_Loader.ibg2, Background.x2 + Gui.width, Background.y, Gui.width, Gui.height * 2);
        g.drawImage(Image_Loader.ibg, Background.x, Background.y, Gui.width, Gui.height * 2);
        g.drawImage(Image_Loader.ibg, Background.x + Gui.width, Background.y, Gui.width, Gui.height * 2);

        if (Gamestate.state == Gamestate_e.ingame || Gamestate.state == Gamestate_e.pause) {

            // Zeichnen des Pentagrams
            g.drawImage(Image_Loader.ipent1, Pentagram.x, Pentagram.y, Pentagram.width, Pentagram.height);
            if (Player.savePoint) {
                g.drawImage(Image_Loader.ipent2, Pentagram.x, Pentagram.y, Pentagram.width, Pentagram.height);
            }

            // Zeichnen des Tors
            g.drawImage(Image_Loader.idoor, Door.x, Door.y, Door.width, Door.height);

            // Zeichnen des Spielers
            if (Player.isJump || !Player.notFall) {
                g.drawImage(Image_Loader.ijump, Player.x, Player.y, Player.width, Player.height);
            } else {
                g.drawImage(Image_Loader.iplayer, Player.x, Player.y, Player.width, Player.height);
            }

            // Zeichnen der Plattformen
            for (Platforms p : Platform_Creation.platforms) {
                WritableImage croppedImage = new WritableImage(Image_Loader.iplatform.getPixelReader(), 0, 0, p.getWidth(), p.getHeight());
                g.drawImage(croppedImage, p.getX(), p.getY(), p.getWidth(), p.getHeight());
                g.setFill(new Color(0, 0, 0, 0.4));
                g.fillRect(p.getX(), p.getY(), p.getWidth(), p.getHeight());
            }
            g.drawImage(Image_Loader.istartplatform, Platform_Creation.platforms.get(0).getX(), Platform_Creation.platforms.get(0).getY(), Platform_Creation.platforms.get(0).getWidth(), Platform_Creation.platforms.get(0).getHeight());
            g.setFill(new Color(0, 0, 0, 0.4));
            g.fillRect(Platform_Creation.platforms.get(0).getX(), Platform_Creation.platforms.get(0).getY(), Platform_Creation.platforms.get(0).getWidth(), Platform_Creation.platforms.get(0).getHeight());

            // Zeichnen der Fallen
            for (Trap t : Trap_Creation.traps) {
                g.drawImage(Image_Loader.itrap, t.getX(), t.getY(), t.getWidth(), t.getHeight());

            }

            // Zeichnen der Lava
            g.drawImage(Image_Loader.ilava1, Lava.x, Lava.y1, Lava.width, Lava.height);
            g.drawImage(Image_Loader.ilava2, Lava.x, Lava.y2, Lava.width, Lava.height);

            for (Platforms p : Platform_Creation.platforms) {
                g.setFill(Color.DARKRED);
                g.fillRect(p.getX(), Gui.height - 10, p.getWidth(), 5);
            }

            // Zeichnen der Lebenspunkte-Upgrades
            for (Life_Upgrade lifeup : LifeUp_Creation.lifeup) {
                g.drawImage(Image_Loader.ilife, lifeup.getX(), lifeup.getY(), lifeup.getWidth(), lifeup.getHeight());
            }

            // Rot, wenn Falle auslöst
            if (Player.hitTrap) {
                g.setFill(new Color(0.5, 0, 0, 0.5));
                g.fillRect(0, 0, Gui.width, Gui.height);
            }

            // Zeichnen der Lebenspunkte
            for (int i = 0; i < 5; i++) {
                g.setStroke(Color.GRAY);
                g.strokeRect(50 + 75 * i, 50, 50, 50);
            }

            for (Life l : Life_Creation.lifes) {
                g.drawImage(Image_Loader.ilife, l.getX(), l.getY(), l.getWidth(), l.getHeight());
            }

            // Zeichnen der Lebensleiste
            g.setStroke(Color.GRAY);
            g.strokeRect(50, 125, 350, 25);
            g.setFill(Color.DARKRED);
            g.fillRect(51, 126, Player.health - 2, 23);

            // Zeichnen des Schlüssel
            if (!Player.haveKey) {
                g.drawImage(Image_Loader.ikey, Key.x, Key.y, Key.width, Key.height);
            }

            g.drawImage(Image_Loader.ikey_border, Gui.width - 150, 50, 100, 50);
            if (Player.haveKey) {
                g.drawImage(Image_Loader.ikey, Gui.width - 150, 50, 100, 50);
            }

        }

        if (Gamestate.state == Gamestate_e.menu) {
            // Grauer Hintergrund
            g.setFill(new Color(0, 0, 0, 0.5));
            g.fillRect(0, 0, Gui.width, Gui.height);

            g.drawImage(Image_Loader.ibanner, 0, 0, 1280, 300);

            // Button Resume
            if (Player.isLevel == 0) {
                g.setStroke(Color.GRAY);
                g.strokeRect(xR - widthR / 2, yR, widthR, heightR);

                g.setFill(Color.GRAY);
            } else {
                g.setStroke(Color.WHITE);
                g.strokeRect(xR - widthR / 2, yR, widthR, heightR);

                g.setFill(Color.WHITE);
            }
            g.setFont(new Font("file:rsc/calibri.ttf", 60));
            g.setTextAlign(TextAlignment.CENTER);
            g.fillText("Resume", Gui.width / 2, yR + heightR / 2 + 20);

            // Button Level 1
            g.setStroke(Color.WHITE);
            g.strokeRect(x1 - width1 / 2, y1, width1, height1);

            g.setFill(Color.WHITE);
            g.setFont(new Font("file:rsc/calibri.ttf", 60));
            g.setTextAlign(TextAlignment.CENTER);
            g.fillText("Level 1", Gui.width / 2, y1 + height1 / 2 + 20);

            // Button Level 2
            if (Player.level1Complete) {
                g.setStroke(Color.WHITE);
                g.strokeRect(x2 - width2 / 2, y2, width2, height2);

                g.setFill(Color.WHITE);
            } else {
                g.setStroke(Color.GRAY);
                g.strokeRect(x2 - width2 / 2, y2, width2, height2);

                g.setFill(Color.GRAY);
            }
            g.setFont(new Font("file:rsc/calibri.ttf", 60));
            g.setTextAlign(TextAlignment.CENTER);
            g.fillText("Level 2", Gui.width / 2, y2 + height2 / 2 + 20);
        }

        if (Gamestate.state == Gamestate_e.gameover) {
            // Grauer Hintergrund
            g.setFill(new Color(0, 0, 0, 0.5));
            g.fillRect(0, 0, Gui.width, Gui.height);

            g.setFill(Color.WHITE);
            g.setFont(new Font("file:rsc/calibri.ttf", 200));
            g.setTextAlign(TextAlignment.CENTER);
            g.fillText("GAME OVER", Gui.width / 2, Gui.height / 2);
        }

        if (Gamestate.state == Gamestate_e.level1Complete) {
            // Grauer Hintergrund
            g.setFill(new Color(0, 0, 0, 0.5));
            g.fillRect(0, 0, Gui.width, Gui.height);

            g.setFill(Color.WHITE);
            g.setFont(new Font("file:rsc/calibri.ttf", 150));
            g.setTextAlign(TextAlignment.CENTER);
            g.fillText("Level 1 Complete", Gui.width / 2, Gui.height / 2);
        }

        if (Gamestate.state == Gamestate_e.level2Complete) {
            // Grauer Hintergrund
            g.setFill(new Color(0, 0, 0, 0.5));
            g.fillRect(0, 0, Gui.width, Gui.height);

            g.setFill(Color.WHITE);
            g.setFont(new Font("file:rsc/calibri.ttf", 150));
            g.setTextAlign(TextAlignment.CENTER);
            g.fillText("Level 2 Complete", Gui.width / 2, Gui.height / 2);
        }
    }

}
