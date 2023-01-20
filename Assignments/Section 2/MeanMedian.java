package genspark.assignments.section2;

import genspark.assignments.Assignment;


import java.util.ArrayList;
import java.util.Collections;

public class MeanMedian implements Assignment {
    public String solution(int a, int b, int c) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(a);
        nums.add(b);
        nums.add(c);
        float mean = (float) ((a + b + c) / 3.0);
        Collections.sort(nums);
        int median = nums.get(1);
        return mean + " " + median;
    }
}
