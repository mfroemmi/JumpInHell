package actions;

import chars.Background;
import chars.Key;
import clocks.Mainclock;
import clocks.Mainclock_Gui;
import gui.Gui;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Marcel
 */
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
