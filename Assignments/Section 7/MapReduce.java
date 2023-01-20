package genspark.assignments.section7;

import genspark.assignments.Assignment;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class MapReduce implements Assignment {
    public int[] solution(ArrayList<ArrayList<Integer>> innerNums) {
        return innerNums.stream().map(n->n.stream().reduce(Integer::sum).get()).collect(Collectors.toCollection(ArrayList<Integer>::new)).stream().mapToInt(Integer::intValue).toArray();
    }
}
