package genspark.assignments.section4;

import genspark.assignments.Assignment;

import java.util.ArrayList;

public class ReverseArrayList implements Assignment {
    public ArrayList<Integer> solution(ArrayList<Integer> list) {

        try {
            ArrayList<Integer> revList = new ArrayList<>();
            for (int i = list.size(); i > 0; i--) {
                revList.add(list.get(i - 1));
            }

            return revList;
        } catch (IndexOutOfBoundsException IOOBE) {
            return list;
        }
    }
}
