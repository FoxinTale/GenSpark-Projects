package genspark.assignments.section5;

import genspark.assignments.Assignment;

import java.util.ArrayList;

public class FindMissingNums implements Assignment {
    public ArrayList<Integer> solution(ArrayList<Integer> nums) {
        if (nums.isEmpty()) {
            return nums;
        } else {
            ArrayList<Integer> missingNums = new ArrayList<>();

            for (int i = 1; i < 101; i++) {
                if (!nums.contains(i)) {
                    missingNums.add(i);
                }
            }
            return missingNums;
        }
    }
}
