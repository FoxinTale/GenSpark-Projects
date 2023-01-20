package genspark.assignments.section2;

import genspark.assignments.Assignment;

public class TripleShotAgain implements Assignment {
    public boolean solution(boolean x, boolean y, boolean z) {
        if(x || y || z){
            return true;
        } else {
            return false;
        }
    }
}
