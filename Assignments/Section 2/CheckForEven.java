package genspark.assignments.section2;

import genspark.assignments.Assignment;

public class CheckForEven implements Assignment {
    public String solution(int number) {
        if(number %2 == 0){
            return "even";
        } else{
            return "odd";
        }
    }
}
