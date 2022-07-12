package com.example.jumpinhell.gui;

import com.example.jumpinhell.chars.Player;

import java.util.ArrayList;

/**
 *
 * @author Marcel
 */
public class Life_Creation {
    
    public static ArrayList<Life> lifes = new ArrayList<>();
    
    public static void create() {
        
        for(int i = 0; i < Player.lifes; i++) {
            lifes.add(new Life(50 + 75*i, 50, 50, 50));
        }
        
    }
    
}
