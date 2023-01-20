package genspark.assignments.section5;

import genspark.assignments.Assignment;

import java.util.ArrayList;
import java.util.Collections;

public class SortArrayListAscending implements Assignment {
    public ArrayList<Integer> solution(ArrayList<Integer> list) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        if (!list.isEmpty()) {
            Collections.sort(list);
        }
        return list;
    }
}
