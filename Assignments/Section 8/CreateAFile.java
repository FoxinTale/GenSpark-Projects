package genspark.assignments.section8;

import genspark.assignments.Assignment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class CreateAFile implements Assignment {
    static File text;
    public void createAFile(){
        try{
            text = Files.createFile(Path.of("C:\\Users\\Aubrey\\Documents\\GensparkCore\\src\\main\\resources\\sample_data.txt")).toFile();
            writeToAFile();
        } catch (IOException IOE){

        }
    }

    public void writeToAFile(){
        try{
            if(!text.exists()){
                createAFile();
            }
            FileWriter fileWriter = new FileWriter(text);

            fileWriter.write("test");
            fileWriter.close();
            readAFile();
        } catch(IOException IOE){

        }
    }

    public ArrayList readAFile(){
        ArrayList<Character> charList = new ArrayList<>();
        try{
            Scanner reader = new Scanner(text);
            String line = reader.nextLine(); // This only has one line, so I can do this. If there were multiple, then we wouldn't.
            for(int i = 0; i < line.length(); i ++){
                charList.add(line.charAt(i));
            }
        } catch(IOException IOE){

        }
        return charList;
    }
}
