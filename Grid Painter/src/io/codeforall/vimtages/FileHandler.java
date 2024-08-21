package io.codeforall.vimtages;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Responsible for handling file operations
 */
public class FileHandler {
    private static PrintWriter out;
    private static boolean firstRun = true;


    public FileHandler() {

        try {
            out = new PrintWriter("resources/state");
        }catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("File Not Found");
        }
        }
    private static void createFileWriter(PrintWriter out) throws IOException {
        try {
            if(firstRun){ return;}
            else{
                firstRun = true;
                out = new PrintWriter("resources/gamestate/state");
            }

            }catch (IOException e){
                if(!firstRun) {
                    System.out.println("Delete Existing Files From Resources And Run The Game Again");
                    out = new PrintWriter("resources/gamestate/state" + Math.random() * 100);
                    return;
                }else{ return;}

        }

    }

    /**
     *
     * @param state state of the cell painted or not
     * @throws IOException  Throws exception if unable to write to file
     */
    public static void saveState(boolean state) throws IOException {
        System.out.println(state);

        if(state){
            out.println("1") ;
            out.flush();

        }else {
            out.println("0");
            out.flush();
        }

    }

    /**
     *
     * @return String of 0's and 1's that represent a painted or not painted cell
     * @throws IOException If unable to retrieve data from file
     */
    public String loadState() throws IOException {
        String output;
        try{
            output = new String(Files.readAllBytes(Paths.get("resources/state")));
            //System.out.println(output);
            return output;
        }catch (IOException e){
            System.out.println("File not found");

        }
        return "Error";
    }

    public void cleanFile() throws IOException {
        PrintWriter printWriter = new PrintWriter("resources/state");
        printWriter.close();
    }

    public void closeStream(){
        out.close();
    }
}
