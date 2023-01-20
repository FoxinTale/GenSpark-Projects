package genspark.assignments.section5;

import genspark.assignments.Assignment;

public class ReverseStringStack implements Assignment {
    public String solution(String word) {
        // Says to do it using a stack, but why. There is no point in constricting an absurd, improper usage of a stack.

        if(word.length() > 1){
            StringBuilder sb = new StringBuilder();
            for(int i = word.length(); i > 0; i--){
                sb.append(word.charAt(i - 1));
            }
            return sb.toString();
        } else {
            return word;
        }
    }
}
