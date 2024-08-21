package io.codeforall.vimtages;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Shape;


import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * The game grid, group of squares that make up the grid
 */
public class Grid {
    private int col;
    private int row;
    private static int cellSize;
    private static int padding;
    private int x = 0;
    private int y = 0;
    ArrayList cells;

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public static int getCellSize() {
        return cellSize;
    }

    public static int getPadding() {
        return padding;
    }

    public Grid(int row, int col, int cellSize, int padding){
        this.col = col;
        this.row=row;
        this.cellSize = cellSize;
        this.padding = padding;
        cells = new ArrayList();



    }

    public void init(){
        Grid grid = new Grid(row,col,cellSize,padding);
        grid.gridSquares(cells);
        Cursor cursor = new Cursor(new Rectangle(row/2*cellSize+padding,col/2*cellSize+padding,cellSize,cellSize));
        cursor.setColor(Color.GREEN);
        cursor.fill();
        SidePannel sidePannel = new SidePannel();
        sidePannel.createSidePannel(x,padding,row,col,cellSize,padding);
        new CursorHandler(cursor,sidePannel.createColorSelector(),cellSize,cells,sidePannel.getSidePannelSquares()).setGrid(grid);

    }

    public void gridSquares(ArrayList cells){


        for (int i = 0; i < col; i++) {
             Cell cell1 = new Cell(x+padding,y+padding,cellSize);
            cell1.draw();
            cells.add(cell1);
            System.out.println(i);
             x+=cellSize;



        }
        if(y<row*cellSize-cellSize){
            x=0;
            y+=cellSize;
            gridSquares(cells);

        }

    }
}
