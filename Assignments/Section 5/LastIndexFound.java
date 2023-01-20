package genspark.assignments.section5;

import genspark.assignments.Assignment;
import java.util.ArrayList;

public class LastIndexFound implements Assignment {
    public int solution(ArrayList<Integer> nums, int numToFind) {
        if(nums.isEmpty()){
            return -1;
        } else {
            if(nums.lastIndexOf(numToFind) != -1){
                return nums.lastIndexOf(numToFind);
            } else {
                return -1;
            }
        }
    }
}
