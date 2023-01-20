package genspark.assignments.section2;

import genspark.assignments.Assignment;

public class FizzBuzzBaz implements Assignment {
    public String solution(int fuzzy) {
        if(fuzzy %3 == 0 && fuzzy %5 == 0){
            return "fizz buzz baz";
        } else if(fuzzy %3 == 0){
            return "fizz";
        } else if (fuzzy %5 == 0){
            return "buzz";
        }
        return "Fizzled";
    }
}
