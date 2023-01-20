package genspark.assignments.section4;

import genspark.assignments.Assignment;
import java.util.ArrayList;

public class RetrieveRandomElmFromArrList implements Assignment {
    public Integer solution(ArrayList<Integer> arrList, int elm) {
        if(arrList.size() == 0){
            return 0;
        } else {
            try{
                return arrList.get(elm);
            } catch (IndexOutOfBoundsException IOOBE){
                return 0;
            }
        }
    }
}
