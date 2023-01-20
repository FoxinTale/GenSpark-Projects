package genspark.assignments.section3;

import genspark.assignments.Assignment;

public class ParsingAnInteger implements Assignment {
    public Object solution(String word) {
        try{
            return Integer.parseInt(word);
        } catch (NumberFormatException NFE){
            return "Caught Exception: Number Format Exception";
        }
    }
}
