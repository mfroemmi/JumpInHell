package com.example.jumpinhell.actions;

import com.example.jumpinhell.chars.Background;
import com.example.jumpinhell.chars.Pentagram;
import com.example.jumpinhell.chars.Player;
import com.example.jumpinhell.chars.Trap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Marcel
 */
public class Trap_Creation {
    
    public static ArrayList<Trap> traps = new ArrayList<>();

    public static List<Integer> x_level1 = Arrays.asList(2202, 2888, 5216, 5356, 6708, 11498, 11938, 14208, 14648, 15440, 15840);
    public static List<Integer> x_level2 = Arrays.asList(1150);
    public static ArrayList<Integer> x = new ArrayList<>();

    public static List<Integer> y_level1 = Arrays.asList(116, 116, 520, 520, 520, 404, 404, 404, 404, 520, 520);
    public static List<Integer> y_level2 = Arrays.asList(450);
    public static ArrayList<Integer> y = new ArrayList<>();
    
    public static void init() {

        if (Menu.level1 == true) {
            x.clear();
            x.addAll(x_level1);

            y.clear();
            y.addAll(y_level1);

            create();
            Menu.level1 = false;
        }

        if (Menu.level2 == true) {
            x.clear();
            x.addAll(x_level2);

            y.clear();
            y.addAll(y_level2);

            create();
            Menu.level2 = false;
        }

    }
    
    public static void create() {

        if (Menu.level1 == true) {
            for (int i = 0; i < x_level1.size(); i++) {
                traps.add(new Trap(x.get(i), y.get(i), 50, 50));
                if (Player.savePoint) {
                    traps.get(i).setX(traps.get(i).getX() - Pentagram.xSavepoint);
                }
            }
        }
        if (Menu.level2 == true) {
            for (int i = 0; i < x_level2.size(); i++) {
                traps.add(new Trap(x.get(i), y.get(i), 50, 50));
                if (Player.savePoint) {
                    traps.get(i).setX(traps.get(i).getX() - Pentagram.xSavepoint);
                }
            }
        }

    }
    
    public static void move() {
        for (int i = 0; i < traps.size(); i++) {
            traps.get(i).setX(traps.get(i).getX() - Background.bgspeedfactor);
        }
    }
}
