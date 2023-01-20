package genspark.assignments.section4;

import genspark.assignments.Assignment;

import java.util.ArrayList;

public class FindMissingInteger implements Assignment {
    public int solution(ArrayList<Integer> numbers) {
        if (!numbers.isEmpty()) {
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i) != (i + 1)) {
                    return (i + 1);
                }
            }
        }
        return 0;
    }
}
