package com.example.jumpinhell.clocks;

import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.util.Duration;

/**
 *
 * @author Marcel
 */
public class Pause {

    public static void pauseTimerForDuration(AnimationTimer timer, Duration duration) {
        PauseTransition pt = new PauseTransition(duration);
        pt.setOnFinished(event -> timer.start());

        timer.stop();
        pt.play();
    }

}
