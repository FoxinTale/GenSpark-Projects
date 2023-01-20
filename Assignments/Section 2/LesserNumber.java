package genspark.assignments.section2;

import genspark.assignments.Assignment;

public class LesserNumber implements Assignment {
    public int solution(int x, int y) {
        if(x < y){
            return x;
        } else {
            return y;
        }
    }
}
