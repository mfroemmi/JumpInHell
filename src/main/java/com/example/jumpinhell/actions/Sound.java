package com.example.jumpinhell.actions;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

/**
 *
 * @author Marcel
 */
public class Sound {
    
    public static MediaPlayer mediaPlayer;
    
    public static void playBackgroundMusic() {

        String path = "C:\\Users\\marce\\IdeaProjects\\JumpInHell\\src\\main\\resources\\com\\example\\jumpinhell\\bgmusic.wav";
           
        Media media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media); 
        mediaPlayer.setVolume(0.2);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

}
