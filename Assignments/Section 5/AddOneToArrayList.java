package genspark.assignments.section5;

import genspark.assignments.Assignment;
import java.util.ArrayList;

public class AddOneToArrayList implements Assignment {
    public ArrayList<Integer> solution(ArrayList<Integer> list) {

        if(list.isEmpty()){
            return new ArrayList<>();
        } else{
            int size = list.size();
            int lastElement = list.get(size -1);

            if(lastElement != 9){
                list.set(size - 1, lastElement + 1);
            } else {
                list.set(size - 2, list.get(size-2) + 1);
                list.set(size - 1, 0);
            }

        }
        return list;
    }
}
