package genspark.assignments.section5;

import genspark.assignments.Assignment;

import java.util.ArrayList;
import java.util.List;

public class MaxSubArray implements Assignment {

    public int sumTheList(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    public ArrayList<Integer> solution(ArrayList<Integer> nums) {
        if (nums.isEmpty() || nums.size() == 1) {
            return nums;
        } else {
            int runningSum = 0;
            int currentMax = Integer.MIN_VALUE;
            int size = nums.size();

            List<Integer> sublist = List.of();
            List<Integer> current;

            for (int startPoint = 0; startPoint < size; startPoint++) {
                for (int endPoint = startPoint; endPoint < size; endPoint++) {
                    current = nums.subList(startPoint, endPoint + 1);

                    runningSum = sumTheList(current);

                    if (runningSum >= currentMax) {
                        if (current.size() >= sublist.size() && runningSum == currentMax) {
                            continue;
                        }
                        currentMax = runningSum;
                        sublist = current;
                    }
                }
            }
            return new ArrayList<>(sublist);
        }
    }
}
