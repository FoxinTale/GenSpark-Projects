package genspark.assignments.section4;

import genspark.assignments.Assignment;

import java.util.ArrayList;
import java.util.Arrays;

public class ReversePositiveInteger implements Assignment {
    public int solution(int number) {

        Integer num = number;
        String numAsString = num.toString(); // This is to be able to get the length of the integer.
        ArrayList<Character> intChars = new ArrayList<>();

        for(int i = numAsString.length(); i > 0; i-- ){
            intChars.add(numAsString.charAt(i - 1));
        }
        String numString = "";
        for(int i = 0; i < intChars.size(); i++){
            numString += intChars.get(i);
        }
        return Integer.parseInt(numString);
    }
}
