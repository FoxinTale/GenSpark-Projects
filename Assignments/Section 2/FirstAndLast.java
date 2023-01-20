package genspark.assignments.section2;

import genspark.assignments.Assignment;

public class FirstAndLast implements Assignment {
    public boolean solution(String word) {
        if(word.length() > 0){
            Character first = word.charAt(0);
            Character last = word.charAt(word.length() - 1);
            return first.equals(last);
        } else {
            return true;
        }
    }
}
