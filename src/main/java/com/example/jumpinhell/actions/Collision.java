package com.example.jumpinhell.actions;

/**
 *
 * @author Marcel
 */
public class Collision {
 
    public static boolean rectangleCollision(float position1x, float position1y, float width1, float height1,
                           float position2x, float position2y, float width2, float height2) {
    return position1x < position2x + width2  &&
           position2x < position1x + width1  &&
           position1y < position2y + height2 &&
           position2y < position1y + height1;
}
    
}
