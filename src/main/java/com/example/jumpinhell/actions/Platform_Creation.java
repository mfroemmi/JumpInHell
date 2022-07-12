package com.example.jumpinhell.actions;

import com.example.jumpinhell.chars.Pentagram;
import com.example.jumpinhell.chars.Platforms;
import com.example.jumpinhell.chars.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Marcel
 */
public class Platform_Creation {

    public static ArrayList<Platforms> platforms = new ArrayList<>();

    public static List<Integer> x_level1 = Arrays.asList(
            0, 810, 1472, 2100, 2790, 3340, 3850, 4122, 4280, 4998, 5904, 
            6704, 6080, 6480, 6816, 7380, 8284, 8748, 9202, 10218, 10822,
            11498, 11732, 11938, 12190, 12416, 12900, 12728, 13448, 13954, 14208,
            14438, 14648, 14900, 15128, 15612, 15438, 16162, 16724, 17674, 18132,
            18644, 19286);
    public static List<Integer> x_level2 = Arrays.asList(0, 750, 1100, 1500);
    public static ArrayList<Integer> x = new ArrayList<>();

    public static List<Integer> y_level1 = Arrays.asList(
            570, 372, 372, 166, 166, 570, 570, 472, 290, 570, 570,
            570, 346, 268, 165, 165, 165, 165, 165, 570, 570,
            444, 570, 444, 570, 330, 175, 570, 570, 570, 444,
            570, 444, 570, 330, 175, 570, 570, 570, 570, 570,
            570, 570);
    public static List<Integer> y_level2 = Arrays.asList(570, 570, 500, 500);
    public static ArrayList<Integer> y = new ArrayList<>();

    public static ArrayList<Integer> width = new ArrayList<>();
    public static List<Integer> width_level1 = Arrays.asList(637, 250, 500, 250, 250, 150, 100, 150, 150, 500, 500,
            250, 150, 150, 150, 500, 50, 50, 500, 500, 500,
            50, 50, 50, 50, 150, 150, 500, 100, 150, 50,
            50, 50, 50, 150, 150, 500, 150, 500, 50, 50,
            500, 500);
    public static List<Integer> width_level2 = Arrays.asList(637, 100, 300, 500);

    public static void init() {

        if (Menu.level1 == true) {
            x.clear();
            x.addAll(x_level1);

            y.clear();
            y.addAll(y_level1);

            width.clear();
            width.addAll(width_level1);

            create();
        }

        if (Menu.level2 == true) {
            x.clear();
            x.addAll(x_level2);

            y.clear();
            y.addAll(y_level2);

            width.clear();
            width.addAll(width_level2);

            create();
        }

    }

    public static void create() {

        platforms.add(new Platforms(x.get(0), y.get(0), width.get(0), 157));
        if (Player.savePoint) {
            platforms.get(0).setX(platforms.get(0).getX() - Pentagram.xSavepoint);
        }

        if (Menu.level1 == true) {
            for (int i = 0; i < x_level1.size() - 1; i++) {
                platforms.add(new Platforms(x.get(i + 1), y.get(i + 1), width.get(i + 1), 70));
                if (Player.savePoint) {
                    platforms.get(i + 1).setX(platforms.get(i + 1).getX() - Pentagram.xSavepoint);
                }
            }
        }
        if (Menu.level2 == true) {
            for (int i = 0; i < x_level2.size() - 1; i++) {
                platforms.add(new Platforms(x.get(i + 1), y.get(i + 1), width.get(i + 1), 70));
                if (Player.savePoint) {
                    platforms.get(i + 1).setX(platforms.get(i + 1).getX() - Pentagram.xSavepoint);
                }
            }
        }

    }

    public static void remove() {

        for (int i = 0; i < Platform_Creation.platforms.size(); i++) {
            Platform_Creation.platforms.clear();
        }

    }

}
