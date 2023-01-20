package genspark.assignments.section8;

import genspark.assignments.Assignment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class RecordOfTextsAndCalls implements Assignment {
    public String[] solution() throws IOException {
        String[] values= new String[2];

        File calls = new File("C:\\Users\\Aubrey\\Documents\\GensparkCore\\src\\main\\resources\\calls.csv");
        File texts = new File("C:\\Users\\Aubrey\\Documents\\GensparkCore\\src\\main\\resources\\texts.csv");
        ArrayList<String> textsList = new ArrayList<>();
        ArrayList<String> callsList = new ArrayList<>();


        try {
            Scanner callsReader = new Scanner(calls);
            Scanner textsReader = new Scanner(texts);

            while (callsReader.hasNext()) {
                callsList.add(callsReader.nextLine());
            }

            while (textsReader.hasNext()) {
                textsList.add(textsReader.nextLine());
            }

            callsReader.close();
            textsReader.close();

            String[] textsReturn = textsList.get(0).split(",");
            String[] callsReturn = callsList.get(callsList.size() - 1).split(",");

            values[0] = String.format("First record of texts, %s texts %s at time %s", textsReturn[0], textsReturn[1], textsReturn[2]);
            values[1] = String.format("Last record of calls, %s calls %s at time %s, lasting %s seconds", callsReturn[0], callsReturn[1], callsReturn[2], callsReturn[3]);

        } catch (IOException IOE){

        }
        return values;
    }
}
