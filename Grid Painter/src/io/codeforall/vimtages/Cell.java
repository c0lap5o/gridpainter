package io.codeforall.vimtages;



import org.academiadecodigo.simplegraphics.graphics.Rectangle;


/**
 * A Cell in the game grid
 */
public class Cell extends Rectangle {
    private boolean isFilled;

    /**
     *
     * @param x Position from upper left corner
     * @param y Position from upper left corner
     * @param cellSize   length size of the cell
     */
    public Cell(int x, int y, int cellSize){
       super(x, y,cellSize,cellSize);

    }


    /**
     *
     * @return if the cell is filled
     */
    public boolean isFilled() {
        return isFilled;
    }

    /**
     *
     * @param filled Set cell state
     */
    public void setFilled(boolean filled) {
        isFilled = filled;
    }
}
