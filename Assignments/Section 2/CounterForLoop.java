package genspark.assignments.section2;

import genspark.assignments.Assignment;

public class CounterForLoop implements Assignment {
    public String solution(int count) {
        String str = "";
        if (count < 0){
            return str;
        } else if (count == 0) {
            return "0";
        } else {
            for( int i = count; i > 0; i--){
                str += Integer.toString(i);
            }
        }
        return str + "0";
    }
}
