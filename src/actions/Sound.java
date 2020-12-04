package actions;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Marcel
 */
public class Sound {
    
    public static MediaPlayer mediaPlayer;
    
    public static void playBackgroundMusic() {

        String path = "rsc/bgmusic.wav";  
           
        Media media = new Media(new File(path).toURI().toString()); 
        mediaPlayer = new MediaPlayer(media); 
        mediaPlayer.setVolume(0.2);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

}
