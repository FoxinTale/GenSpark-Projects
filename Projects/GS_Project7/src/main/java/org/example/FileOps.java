package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
public class FileOps {

    private static File gameFile;

    public static String[] readArtFile() {
        File artFile = new File("res\\art.txt");
        try {
            String artData = new String(Files.readAllBytes(artFile.toPath()));
            String[] art = artData.split("=====");
            return art;

        } catch (IOException IOE) {
            System.out.println("ERROR: Art data file not found.");
            System.exit(5); // We force quit due to the file not being able to be found. It's the art file so it is kind of important.
        }
        return null;
    }

    public static void writeDataFile(){
        try{
            FileWriter dataWriter = new FileWriter(gameFile.getName());

            dataWriter.write("# Game Data for Hangman;\n");
            dataWriter.write("sPlayerName=" + Game.getPlayerName() + ";\n"); // s for String.
            dataWriter.write("iHighScore=" + Game.getGuessCount() + ";\n"); // i for Integer
            dataWriter.close();
        } catch (IOException IOE){

        }

    }

    public static void readDataFile(){
        if(gameFile.exists()){
            try{
                String gameData = new String(Files.readAllBytes(gameFile.toPath()));
                String[] data = gameData.split(";");
                System.out.println(data[1]);
                System.out.println(data[2]);
            } catch (IOException IOE){
                System.out.println("AIEEEEE");
            }
        } else {
            System.out.println("Data file does not exist.");
        }
    }

    public String lineSplit(String line){
        String[] splits = line.split("=");
        return splits[1];
    }

    public static void setGameFile(File gameFile) {
        FileOps.gameFile = gameFile;
    }

    public static File getGameFile() {
        return gameFile;
    }
}
