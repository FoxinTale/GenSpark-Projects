package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
public class FileOps {


    private static final String commonPath = System.getProperty("user.dir") + File.separator + "res" + File.separator;
    private static final File gameFile = new File(commonPath + "game.ini");

    public static String[] readArtFile() {
        File artFile = new File(commonPath + "art.txt");
        try {
            String artData = new String(Files.readAllBytes(artFile.toPath()));
            return artData.split("=====");

        } catch (IOException IOE) {
            System.out.println("ERROR: Art data file not found.");
            System.exit(5); // We force quit due to the file not being able to be found. It's the art file so it is kind of important.
        }
        return null;
    }

    public static void writeDataFile(){
        try{
            FileWriter dataWriter = new FileWriter(gameFile);

            dataWriter.write("# Game Data for Hangman;\n");
            dataWriter.write("sPlayerName=" + Game.getPlayerName() + ";\n"); // s for String.
            dataWriter.write("iHighScore=" + Game.getCurrentScore() + ";\n"); // i for Integer
            dataWriter.close();
        } catch (IOException IOE){

        }
    }

    public static void readDataFile(){
        if(gameFile.exists()){
            try{
                String gameData = new String(Files.readAllBytes(gameFile.toPath()));
                String[] data = gameData.split(";");
                Game.setPlayerName(lineSplit(data[1]));
                Game.setHighScore(Integer.parseInt(lineSplit(data[2])));
            } catch (IOException IOE){
                System.out.println("Generic IO Exception.");
            }
        } else {
            System.out.println("Data file does not exist. Will create it at the end of game.");
        }
    }

    public static String lineSplit(String line){
        String[] splits = line.split("=");
        return splits[1];
    }

    public static File getGameFile() {
        return gameFile;
    }
}
