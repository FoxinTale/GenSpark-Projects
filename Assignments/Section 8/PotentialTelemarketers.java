package genspark.assignments.section8;

import genspark.assignments.Assignment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class PotentialTelemarketers implements Assignment {
    public String solution() throws IOException {
        File calls = new File("C:\\Users\\Aubrey\\Documents\\GensparkCore\\src\\main\\resources\\calls.csv");
        File texts = new File("C:\\Users\\Aubrey\\Documents\\GensparkCore\\src\\main\\resources\\texts.csv");

        ArrayList<String> teleNumbers = new ArrayList<>();

        ArrayList<String> outgoingCalls = new ArrayList<>();
        ArrayList<String> incomingCalls = new ArrayList<>();
        ArrayList<String> outgoingTexts = new ArrayList<>();
        ArrayList<String> incomingTexts = new ArrayList<>();

        HashMap<String, Integer> telemarketers = new HashMap<>();
        String[] splitLine;

        try {
            Scanner callsReader = new Scanner(calls);
            Scanner textsReader = new Scanner(texts);

            while (callsReader.hasNext()) {
                splitLine = callsReader.nextLine().split(",");
                outgoingCalls.add(splitLine[0]);
                incomingCalls.add(splitLine[1]);
            }

            while (textsReader.hasNext()) {
                splitLine = textsReader.nextLine().split(",");
                outgoingTexts.add(splitLine[0]);
                incomingTexts.add(splitLine[1]);
            }
            String item;
            for (int i = 0; i < outgoingCalls.size(); i++) {
                item = outgoingCalls.get(i);
                if (!incomingCalls.contains(item) && !outgoingTexts.contains(item) && !incomingTexts.contains(item) && item.startsWith("140")) {
                    telemarketers.put(item, 1);
                }
            }

            teleNumbers.addAll(telemarketers.keySet());
            Collections.sort(teleNumbers);

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < teleNumbers.size(); i++) {
                sb.append(teleNumbers.get(i) + " ");
            }

            return sb.toString().trim();

        } catch (IOException IOE) {

        }
        return "";
    }
}
