package io.codeforall.vimtages;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Handles cursor commands
 */
public class CursorHandler implements KeyboardHandler {

    private Keyboard keyboard;
    private Cursor cursor;
    private int cellSize;
    private ArrayList<Cell> cells;
    private static FileHandler fileHandler = new FileHandler();
    private Cursor colorSelector;
    private ArrayList<Cell> sidePannelSquares;
    private Color color = Color.BLACK;
    private Grid grid;

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    /**
     *
     * @param cursor        Cursor to be controlled
     * @param colorSelector Color selector cursor
     * @param cellSize      The size of the cursor
     * @param cells         List with all grid cells
     * @param sidePannelSquares Colors you can select
     */
    public CursorHandler(Cursor cursor, Cursor colorSelector, int cellSize, ArrayList<Cell> cells, ArrayList<Cell> sidePannelSquares){
        this.cursor = cursor;
        this.colorSelector = colorSelector;
        this.keyboard= new Keyboard(this);
        this.cellSize=cellSize;
        this.cells=cells;
        this.sidePannelSquares=sidePannelSquares;
        createKeyboardEvents();
    }

    /**
     * All keyboard keys
     */
    public void createKeyboardEvents() {
        KeyboardEvent keyboardEventUp = new KeyboardEvent();
        keyboardEventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventUp.setKey(KeyboardEvent.KEY_UP);
        keyboard.addEventListener(keyboardEventUp);

        KeyboardEvent keyboardEventDown = new KeyboardEvent();
        keyboardEventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventDown.setKey(KeyboardEvent.KEY_DOWN);
        keyboard.addEventListener(keyboardEventDown);

        KeyboardEvent keyboardEventLeft = new KeyboardEvent();
        keyboardEventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(keyboardEventLeft);

        KeyboardEvent keyboardEventRight = new KeyboardEvent();
        keyboardEventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyboard.addEventListener(keyboardEventRight);

        KeyboardEvent keyboardEventSpace = new KeyboardEvent();
        keyboardEventSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventSpace.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(keyboardEventSpace);

        KeyboardEvent keyboardEventS = new KeyboardEvent();
        keyboardEventS.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventS.setKey(KeyboardEvent.KEY_S);
        keyboard.addEventListener(keyboardEventS);

        KeyboardEvent keyboardEventL = new KeyboardEvent();
        keyboardEventL.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventL.setKey(KeyboardEvent.KEY_L);
        keyboard.addEventListener(keyboardEventL);

        KeyboardEvent keyboardEventEsc = new KeyboardEvent();
        keyboardEventEsc.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventEsc.setKey(KeyboardEvent.KEY_ESC);
        keyboard.addEventListener(keyboardEventEsc);

        KeyboardEvent keyboardEventC = new KeyboardEvent();
        keyboardEventC.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventC.setKey(KeyboardEvent.KEY_C);
        keyboard.addEventListener(keyboardEventC);


        KeyboardEvent keyboardEventU = new KeyboardEvent();
        keyboardEventU.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventU.setKey(KeyboardEvent.KEY_U);
        keyboard.addEventListener(keyboardEventU);

        KeyboardEvent keyboardEventJ = new KeyboardEvent();
        keyboardEventJ.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventJ.setKey(KeyboardEvent.KEY_J);
        keyboard.addEventListener(keyboardEventJ);

        KeyboardEvent keyboardEventH = new KeyboardEvent();
        keyboardEventH.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventH.setKey(KeyboardEvent.KEY_H);
        keyboard.addEventListener(keyboardEventH);

        KeyboardEvent keyboardEventN = new KeyboardEvent();
        keyboardEventN.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventN.setKey(KeyboardEvent.KEY_N);
        keyboard.addEventListener(keyboardEventN);

        KeyboardEvent keyboardEventShift = new KeyboardEvent();
        keyboardEventShift.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventShift.setKey(KeyboardEvent.KEY_SHIFT);
        keyboard.addEventListener(keyboardEventShift);
    }

    /**
     * All the commands possible with the cursor
     * @param keyboardEvent The key that is being pressed
     */
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        int xLimit = grid.getRow() * cellSize - 10;
        int yLimit = grid.getCol() * cellSize - 10;

        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_UP:
                if(cursor.getY() <= 10 ){
                    break;
                }
                cursor.moveUp(this.cellSize);
                break;
            case KeyboardEvent.KEY_DOWN:
                if(cursor.getY() >= yLimit){
                    break;
                }
                cursor.moveDown(this.cellSize);
                break;
            case KeyboardEvent.KEY_LEFT:
                if(cursor.getX() <= 10){
                    break;
                }
                cursor.moveLeft(this.cellSize);
                break;
            case KeyboardEvent.KEY_RIGHT:
                if(cursor.getX() >= xLimit){
                    break;
                }
                cursor.moveRight(this.cellSize);
                break;
            case KeyboardEvent.KEY_SPACE:

                    Cell currentCell = currentCell(cells, cursor);
                    if (currentCell.isFilled()) {
                        currentCell.setColor(Color.BLACK);
                        currentCell.draw();
                        currentCell.setFilled(false);


                    } else {
                        currentCell.setColor(color);
                        currentCell.fill();
                        currentCell.setFilled(true);
                    }
                break;
            case(KeyboardEvent.KEY_S):
                try {
                    fileHandler.cleanFile();
                } catch (IOException e) {
                    System.out.println("File Not Found");
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
                for (Cell cell :cells){
                    try {

                        fileHandler.saveState(cell.isFilled());
                    } catch (IOException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }
                }
                break;
            case(KeyboardEvent.KEY_L):
                try {
                   String s = fileHandler.loadState();
                   loadFromString(s);

                } catch (IOException e) {
                    System.out.println("error calling loadState");
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
                break;

            case(KeyboardEvent.KEY_ESC):
                fileHandler.closeStream();
                System.exit(-1);
                break;
            case(KeyboardEvent.KEY_C):
                clearCanvas();
                break;
            case(KeyboardEvent.KEY_U):
                if(colorSelector.getY() <= 60){break;}
                colorSelector.moveUp(cellSize+10);
                break;
            case(KeyboardEvent.KEY_J)://j
                System.out.println(colorSelector.getX());
                if(colorSelector.getX() >= 700){break;}
                    colorSelector.moveRight(cellSize + 10);
                break;
            case(KeyboardEvent.KEY_H):
                if(colorSelector.getX() <= 640){break;}
                colorSelector.moveLeft(cellSize+10);
                break;
            case (KeyboardEvent.KEY_N):
                if(colorSelector.getY() >= 120){break;}
                colorSelector.moveDown(cellSize+10);
                break;
            case (KeyboardEvent.KEY_SHIFT):
                for(Cell cell : sidePannelSquares){
                    if(colorSelector.getX()==cell.getX() && colorSelector.getY() == cell.getY()){
                        color = Colors.getColorsById(sidePannelSquares.indexOf(cell)+1);
                        cursor.setColor(color);
                        cursor.fill();
                    }
                }
                break;
        }
    }

    /**
     *
     * @param s String with painted cells translated in 1s and 0s
     */
    private void loadFromString(String s){
        String values[] = s.split("\\n");

        for(int i = 0; i < values.length;i++){
            if(values[i].equals("1")) {
                cells.get(i).setFilled(true);
                cells.get(i).fill();
            }else{
                cells.get(i).setFilled(false);
                cells.get(i).draw();
            }

        }

    }

    private void clearCanvas(){
        for(Cell cell:cells){
            cell.setFilled(false);
            cell.setColor(Color.BLACK);
            cell.draw();
        }

    }

    /**
     *
     * @param cells Grid cell list
     * @param cursor The cursor
     * @return        The cell where the cursor is at
     */
    private Cell currentCell(ArrayList<Cell> cells,Cursor cursor){

            for (Cell cell : cells) {
                if (cell.getX()/cellSize == cursor.getX()/cellSize && cell.getY()/cellSize == cursor.getY()/cellSize) {
                    return cell;

                }

            }
     return null;

    }
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
