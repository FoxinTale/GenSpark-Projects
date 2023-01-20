package genspark.assignments.section8;

import genspark.assignments.Assignment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class LongestCall implements Assignment {
    public String solution() {
        File calls = new File("C:\\Users\\Aubrey\\Documents\\GensparkCore\\src\\main\\resources\\calls.csv");
        HashMap<String, Integer> numberCallMap = new HashMap<>();

        String[] splitLine;
        int tmp = 0;
        String currentKey = "";
        int currentValue = 0;
        try { // 55570
            Scanner reader = new Scanner(calls);

            while (reader.hasNext()) {
                splitLine = reader.nextLine().split(",");
                if(!numberCallMap.containsKey(splitLine[0])){
                    numberCallMap.put(splitLine[0], Integer.parseInt(splitLine[splitLine.length - 1]));
                } else {
                    tmp =  numberCallMap.get(splitLine[0]);
                    numberCallMap.replace(splitLine[0], tmp + Integer.parseInt(splitLine[splitLine.length - 1]));
                }


                if(!numberCallMap.containsKey(splitLine[1])){
                    numberCallMap.put(splitLine[1], Integer.parseInt(splitLine[splitLine.length - 1]));
                } else {
                    tmp =  numberCallMap.get(splitLine[1]);
                    numberCallMap.replace(splitLine[1], tmp + Integer.parseInt(splitLine[splitLine.length - 1]));
                }
            }
            reader.close();

            for(String key : numberCallMap.keySet()){
                if(currentValue < numberCallMap.get(key)){
                    currentValue = numberCallMap.get(key);
                    currentKey = key;
                }
            }
        } catch (IOException IOE) {

        }
        return currentKey;
    }
}
