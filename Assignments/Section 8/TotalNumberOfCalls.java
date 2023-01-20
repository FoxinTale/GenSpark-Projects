package genspark.assignments.section8;

import genspark.assignments.Assignment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class TotalNumberOfCalls implements Assignment {
    public int solution() throws IOException {
        File calls = new File("C:\\Users\\Aubrey\\Documents\\GensparkCore\\src\\main\\resources\\calls.csv");
        File texts = new File("C:\\Users\\Aubrey\\Documents\\GensparkCore\\src\\main\\resources\\texts.csv");
        String[] splitLine;
        String tmp;

        HashMap<String, Integer> numbersMap = new HashMap<>();

        try{
            Scanner callsReader = new Scanner(calls);
            Scanner textsReader = new Scanner(texts);

            while (callsReader.hasNext()) {
                splitLine = callsReader.nextLine().split(",");
                numbersMap.put(splitLine[0], 1);
                numbersMap.put(splitLine[1], 1);
            }

            while (textsReader.hasNext()){
                tmp = textsReader.nextLine().split(",")[0];
                numbersMap.put(tmp, 1);
                tmp = textsReader.nextLine().split(",")[1];
                numbersMap.put(tmp, 1);
            }
            callsReader.close();
            return numbersMap.size();

        } catch (IOException IOE){

        }
        return 0;
    }
}

