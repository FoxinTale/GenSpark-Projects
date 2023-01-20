package genspark.assignments.section5;

import genspark.assignments.Assignment;
import java.util.ArrayList;
import java.util.HashMap;

public class MapReturnKeys implements Assignment {
    public ArrayList<String> solution(HashMap<String,Integer> map){
        if(map.isEmpty()){
            return null;
        } else {
            ArrayList<String> keys = new ArrayList<>();
            keys.addAll(map.keySet());

            return keys;
        }
    }
}
