package genspark.assignments.section5;

import genspark.assignments.Assignment;

import java.util.HashMap;
import java.util.Set;

public class RemoveDuplicatesFromArray implements Assignment {
    public int[] solution(int[] nums) {
        if (nums.length <= 2) {
            return nums;
        } else {
            HashMap<Integer, Integer> ints = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                ints.put(nums[i], 1);
            }
            Set<Integer> keys = ints.keySet();
            int[] noDupes = new int[ints.size()];
            Object[] keyArr = keys.toArray();


            for (int i = 0; i < ints.size(); i++) {
                noDupes[i] = Integer.parseInt(keyArr[i].toString());
            }
            return noDupes;
        }
    }
}

