package com.example.jumpinhell.actions;

import com.example.jumpinhell.chars.Life_Upgrade;
import com.example.jumpinhell.chars.Platforms;

import java.util.ArrayList;

/**
 *
 * @author Marcel
 */
public class LifeUp_Creation {
    
    public static ArrayList<Life_Upgrade> lifeup = new ArrayList<>();
    
    public static void create() {
        
        for(Platforms p: Platform_Creation.platforms) {
            if(p.getWidth() == 100) {
                lifeup.add(new Life_Upgrade(p.getX() + p.getWidth()/2 - 15, p.getY() - 470, 40, 40));
            }
        }
        
    }
    
}
