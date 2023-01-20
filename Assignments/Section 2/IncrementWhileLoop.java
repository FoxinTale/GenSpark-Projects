package genspark.assignments.section2;

import genspark.assignments.Assignment;

public class IncrementWhileLoop implements Assignment {
    public String solution(int from, int to) {
        if (from > to) {
            return "";
        } else if (from == to) {
            return Integer.toString(from);
        } else {
            String str = "";
            int i = from;
            while(i < to){
                str += Integer.toString(i);
                i += 1;
            }
            return str + to;
        }
    }
}

