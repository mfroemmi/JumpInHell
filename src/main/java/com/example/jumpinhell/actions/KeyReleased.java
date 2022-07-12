/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jumpinhell.actions;

import com.example.jumpinhell.chars.Player;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Marcel
 */
public class KeyReleased implements EventHandler<KeyEvent> {

    @Override
    public void handle(KeyEvent e) {
        
        switch(e.getCode()) {
            
            case RIGHT:
                Player.keyflagright = false;
                break;
                
            case LEFT:
                Player.keyflagleft = false;
                break;
                
            case SPACE:
                Player.keyflagjump = false;
                break;
            
        }
    }
    
}
