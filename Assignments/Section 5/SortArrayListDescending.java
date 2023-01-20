package genspark.assignments.section5;

import genspark.assignments.Assignment;
import java.util.ArrayList;
import java.util.Collections;

public class SortArrayListDescending implements Assignment {
    public ArrayList<Integer> solution(ArrayList<Integer> list) {
        if (!list.isEmpty()) {
            Collections.sort(list, Collections.reverseOrder());
        }
        return list;
    }
}
