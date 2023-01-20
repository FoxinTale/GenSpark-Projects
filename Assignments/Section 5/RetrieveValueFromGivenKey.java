package genspark.assignments.section5;

import genspark.assignments.Assignment;
import java.util.HashMap;

public class RetrieveValueFromGivenKey implements Assignment {
    public int solution(HashMap<Integer,Integer> map, Integer value) {
        if(map.containsKey(value)){
            return map.get(value);
        } else {
            return 0;
        }
    }
}
