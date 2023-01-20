package genspark.assignments.section2;

import genspark.assignments.Assignment;

public class MaxNumber implements Assignment {
    public int solution(int a, int b) {
        if(a > b){
            return a;
        } else {
            return b;
        }
    }
}
