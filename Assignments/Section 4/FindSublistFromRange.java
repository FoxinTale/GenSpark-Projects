package genspark.assignments.section4;

import genspark.assignments.Assignment;
import java.util.ArrayList;
import java.util.List;

public class FindSublistFromRange implements Assignment {
    public ArrayList<Integer> solution(ArrayList<Integer> elms, int from, int to) {

        if(elms.size() != 0){
            ArrayList<Integer> subList = new ArrayList<>();
            List<Integer> intList = elms.subList(from, to);
            if(intList.size() != 0){
                subList.addAll(intList);
            }
            return subList;
        } else {
            return new ArrayList<>();
        }
    }
}
