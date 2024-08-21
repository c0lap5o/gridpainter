package io.codeforall.vimtages;

import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;



public class Main {

    public static void main(String[] args) {
        final int row = 30;
        final int col = 30;
        final int cellSize = 20;
        final int padding = 10;
        Grid grid = new Grid(row,col, cellSize,padding);
        grid.init();




    }
}
