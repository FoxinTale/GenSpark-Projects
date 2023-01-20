package genspark.assignments.section5;

import genspark.assignments.Assignment;

import java.util.ArrayList;

public class NthRowPascal implements Assignment {
    public ArrayList<Integer> solution(int nth) {
        ArrayList<Integer> pascal = new ArrayList<>();

        if (nth == 1) {
            pascal.add(1);
            pascal.add(1);
        } else {
            int previous = 1;
            int value;
            pascal.add(1);

            for (int i = 1; i <= nth; i++) {
                value = (previous * (nth - i + 1)) / i;
                pascal.add(value);
                previous = value;
            }
        }
        return pascal;
    }
}
