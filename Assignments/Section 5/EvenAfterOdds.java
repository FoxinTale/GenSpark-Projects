package genspark.assignments.section5;

import genspark.assignments.Assignment;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;

public class EvenAfterOdds implements Assignment {
    public ArrayList<Integer> solution(ArrayList<Integer> nums) {
        if(nums.size() < 2){
            return nums;
        } else {
            ArrayList<Integer> returnList = new ArrayList<>();
            ArrayList<Integer> evens = new ArrayList<>();
            ArrayList<Integer> odds = new ArrayList<>();

            for(int i = 0; i < nums.size(); i++){
                if(nums.get(i) %2 == 0){
                    evens.add(nums.get(i));
                } else {
                    odds.add(nums.get(i));
                }
            }

            returnList.addAll(odds);
            returnList.addAll(evens);

            return returnList;
        }
    }
}
