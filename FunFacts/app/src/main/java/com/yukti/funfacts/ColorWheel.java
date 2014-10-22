package com.yukti.funfacts;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by Yukti on 10/22/2014.
 */
public class ColorWheel {
    //vars aka properties
    public String[] colors = {
            "#39add1", // light blue
            "#3079ab", // dark blue
            "#c25975", // mauve
            "#e15258", // red
            "#f9845b", // orange
            "#838cc7", // lavender
            "#7d669e", // purple
            "#53bbb4", // aqua
            "#51b46d", // green
            "#e0ab18", // mustard
            "#637a91", // dark gray
            "#f092b0", // pink
            "#b7c0c7"  // light gray
            };

    //methods
    public int getColor(){
        //random select colors
        Random random = new Random();
        int num = random.nextInt(colors.length);
        //update with new fact
        return Color.parseColor(colors[num]);
    }
}
