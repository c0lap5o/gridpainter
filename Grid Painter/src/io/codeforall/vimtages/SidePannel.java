package io.codeforall.vimtages;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

/**
 * The side panel where you can select colors from
 */
public class SidePannel {
    private int x;
    private int y;
    private int rows;
    private int cols;
    private int cellSize;
    private int padding;

    public ArrayList<Cell> getSidePannelSquares() {
        return sidePannelSquares;
    }

    private ArrayList<Cell> sidePannelSquares;


    public void createSidePannel(int x, int y, int rows, int cols,int cellSize,int padding){
      this.x=x;
      this.y=y;
      this.rows=rows;
      this.cols=cols;
      this.cellSize=cellSize;
      this.padding=padding;
        sidePanelGrid();
        colorSquares();


    }
    private void sidePanelGrid(){
        Rectangle sidePannel = new Rectangle(x+(rows*cellSize)+padding,y,rows*cellSize/4,cols*cellSize);
        sidePannel.draw();

    }
    private void colorSquares(){
        int xStart =rows*cellSize+padding;
        int yStart = cellSize*2;
        sidePannelSquares = new ArrayList<>();

        for(int i = 1;i <= 13; i++){
            Cell colorSelector = new Cell((xStart+cellSize*i),yStart,cellSize);
            xStart += padding;
            if(i%4==0) {
                yStart += cellSize+padding;
               xStart -= cellSize*6;
            }
            sidePannelSquares.add(colorSelector);
        }
        fillSelectors();

    }
    private void fillSelectors(){
        for (int i = 0;i<Colors.values().length;i++){
            sidePannelSquares.get(i).setColor(Colors.getColorsById(i+1));
            if(i+1==Colors.values().length-1) {
                sidePannelSquares.get(i).draw();

                continue;
            }
            sidePannelSquares.get(i).fill();
        }
    }
    public Cursor createColorSelector(){
        int xStart =(rows*cellSize+padding);
        int yStart = (cellSize*2);
        Cursor colorSelector = new Cursor(new Rectangle(xStart+cellSize,yStart,cellSize+2,cellSize+2));
        colorSelector.setColor(Color.BLACK);
        colorSelector.fill();
        colorSelector.draw();
        return colorSelector;

    }
}
