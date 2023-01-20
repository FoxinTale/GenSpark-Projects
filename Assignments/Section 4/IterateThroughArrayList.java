package genspark.assignments.section4;

import genspark.assignments.Assignment;
import java.util.ArrayList;

public class IterateThroughArrayList implements Assignment {
    public ArrayList<Integer> solution(ArrayList<String> myList) {
        ArrayList<Integer> charCount = new ArrayList<>();
        for(int i = 0; i < myList.size(); i++){
            charCount.add(myList.get(i).length());
        }
        return charCount;
    }
}
