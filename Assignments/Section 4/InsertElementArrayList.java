package genspark.assignments.section4;

import genspark.assignments.Assignment;

import java.util.ArrayList;

public class InsertElementArrayList implements Assignment {
    public ArrayList<Integer> solution(ArrayList<Integer> list) {
        list.add(0, 5);
        return list;
    }
}
