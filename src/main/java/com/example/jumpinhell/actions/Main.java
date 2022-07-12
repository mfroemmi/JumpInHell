package com.example.jumpinhell.actions;

import com.example.jumpinhell.chars.Background;
import com.example.jumpinhell.chars.Key;
import com.example.jumpinhell.clocks.Mainclock;
import com.example.jumpinhell.clocks.Mainclock_Gui;
import com.example.jumpinhell.gui.Gui;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    Gui g = new Gui();

    @Override
    public void start(Stage stage) {

        g.init();
        g.create(stage);

        new Key();
        Background.init();
        Mainclock.Timer();
        Mainclock_Gui.Timer();
        Sound.playBackgroundMusic();

    }

    public static void main(String[] args) {
        launch(args);
    }

}