package genspark.assignments.section5;

import genspark.assignments.Assignment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class CountDuplicatesWithMap implements Assignment {
    public HashMap<Integer,Integer> solution(ArrayList<Integer> nums) {
        if(nums.isEmpty()){
            return null;
        } else {
            HashMap<Integer, Integer> intMap = new HashMap<>();

            for(int i = 0; i < nums.size(); i++){
                intMap.put(nums.get(i),  Collections.frequency(nums, nums.get(i)));
            }
            return intMap;
        }
    }
}
