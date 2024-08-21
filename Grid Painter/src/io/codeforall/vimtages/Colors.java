package io.codeforall.vimtages;

import org.academiadecodigo.simplegraphics.graphics.Color;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Links a color with a number
 */
public enum Colors {
    BLACK(1,Color.BLACK),
    BLUE(2,Color.BLUE),
    CYAN(3,Color.CYAN),
    DARK_GRAY(4,Color.DARK_GRAY),
    GRAY(5,Color.GRAY),
    GREEN(6,Color.GREEN),
    LIGHT_GRAY(7,Color.LIGHT_GRAY),
    MAGENTA(8,Color.MAGENTA),
    ORANGE(9,Color.ORANGE),
    PINK(10,Color.PINK),
    RED(11,Color.RED),
    WHITE(12,Color.BLACK),
    YELLOW(13,Color.YELLOW);

    private Color color;
    private int colorNumber;

    /**
     *
     * @param colorNumber   The number of the color
     * @param color         The color
     */
    Colors(int colorNumber, Color color){
        this.color=color;
        this.colorNumber=colorNumber;
    }

    public Color getColor(){
        return this.color;
    }

    public int getColorNumber() {
        return colorNumber;
    }

    /**
     *
     * @param colorNumber number of the color
     * @return  the respective color associated with the number
     */
    public static Color getColorsById(int colorNumber) {

        for (Colors option : values()) {
            if(option.getColorNumber() == colorNumber){
                return option.getColor();
            }

        }

        return Color.BLACK;
    }

    /**
     *
     * @param color The color which you want the id from
     * @return      Int id associated with the color
     */
    public static int getIdByColor(Color color) {

        for (Colors option : values()) {
            if(color == option.getColor()){
                return option.getColorNumber();
            }

        }

        return 1;
    }

}
