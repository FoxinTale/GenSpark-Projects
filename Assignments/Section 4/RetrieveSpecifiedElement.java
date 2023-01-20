package genspark.assignments.section4;

import genspark.assignments.Assignment;
import java.util.ArrayList;

public class RetrieveSpecifiedElement implements Assignment {
    public int solution(ArrayList<Integer> list) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        if(list.size() == 0){
            return 0;
        } else {
            return list.get(0);
        }
    }
}
