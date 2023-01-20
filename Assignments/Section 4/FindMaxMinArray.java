package genspark.assignments.section4;

import genspark.assignments.Assignment;
import java.util.ArrayList;
import java.util.Arrays;

public class FindMaxMinArray implements Assignment {
    public ArrayList<Long> solution(int[] nums) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        ArrayList<Long> selectNums = new ArrayList<>();
        if(nums.length != 0){

            selectNums.add((long) Arrays.stream(nums).max().getAsInt());
            selectNums.add((long) Arrays.stream(nums).min().getAsInt());
            return selectNums;
        } else {
            selectNums.add(0l);
            selectNums.add(0l);
        }

        return selectNums;
    }
}
