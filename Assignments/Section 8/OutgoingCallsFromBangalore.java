package genspark.assignments.section8;

import genspark.assignments.Assignment;
import org.checkerframework.checker.units.qual.A;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class OutgoingCallsFromBangalore implements Assignment {
    public String solution() throws IOException {

        File calls = new File("C:\\Users\\Aubrey\\Documents\\GensparkCore\\src\\main\\resources\\calls.csv");
        ArrayList<String> numbersList = new ArrayList<>();
        ArrayList<String> bangaloreNums = new ArrayList<>();
        HashMap<String, Integer> numbers = new HashMap<>();
        String[] splitLine;
        String num;

        try {
            Scanner callsReader = new Scanner(calls);

            while (callsReader.hasNext()) {
                splitLine = callsReader.nextLine().split(",");
                numbersList.add(splitLine[0]);
            }

            for(int i =0; i < numbersList.size(); i++){
                num = numbersList.get(i);
                if(num.startsWith("(0") ){
                    numbers.put(num.substring(1, num.indexOf(")")), 1);
                } else if(num.contains(" ")){
                    numbers.put(num.substring(0, 4), 1);
                } else {
                    numbers.put("140", 1);
                }
            }
            callsReader.close();
            bangaloreNums.addAll(numbers.keySet());

            Collections.sort(bangaloreNums);

            StringBuilder sb = new StringBuilder();

            for(int i =0; i < bangaloreNums.size(); i++){
                sb.append(bangaloreNums.get(i) + " ");
            }

            return sb.toString().trim();
        } catch (IOException IOE){

        }
        return "";
    }
}
