package genspark.assignments.section2;

import genspark.assignments.Assignment;

public class LongestString implements Assignment {
    public String solution(String firstWord, String secondWord) {
        if(firstWord.length() > secondWord.length()){
            return firstWord;
        } else {
            return secondWord;
        }
    }
}
