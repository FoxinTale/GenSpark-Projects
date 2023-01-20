package genspark.assignments.section4;

import genspark.assignments.Assignment;
import java.util.ArrayList;

public class UpdateSpecificElement implements Assignment {
    public ArrayList<Integer> solution(ArrayList<Integer> list, int val, int index) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        if(list.size() == 0){
            return list;
        } else {
            try{
                list.set(index, val);
            } catch (IndexOutOfBoundsException IOOBE){
                return list;
            }
        }
        return list;
    }
}
