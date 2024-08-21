package io.codeforall.vimtages;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

/**
 * The player in the game, the brush that paints the cells
 */
public class Cursor {
     private Rectangle cursor;
    public Cursor(Rectangle cursor) {
        this.cursor=cursor;

   }

    /**
     *
     *@return int x position of the cursor
     */
    public int getX(){return cursor.getX();}

    /**
     *@return   int y position of the cursor
     */
    public int getY(){return cursor.getY();}
    public void fill(){cursor.fill();}
    public void draw(){cursor.draw();}

    /**
     * @param color Color to paint the square
     */
    public void setColor(Color color){cursor.setColor(color);}

    /**
     *
     * @param cellSize  Translates the cursor in the x-axis to the right
     */
    public void moveRight(int cellSize){
            cursor.translate(cellSize,0);
        }

    /**
     * @param cellSize  Translates the cursor in the x-axis to the left
     */
    public void moveLeft(int cellSize){
            cursor.translate(-cellSize,0);
    }
    /**
     * @param cellSize  Translates the cursor in the y-axis up
     */
public void moveUp(int cellSize){
    cursor.translate(0,-cellSize);
}
    /**
     * @param cellSize  Translates the cursor in the y-axis down
     */
public  void moveDown(int cellSize){
        cursor.translate(0,cellSize);
}

}





