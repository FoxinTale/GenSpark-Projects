package genspark.assignments.section2;

import genspark.assignments.Assignment;

public class ReverseAnInteger implements Assignment {
    public String solution(int number) {
       StringBuilder sb = new StringBuilder();
       String num = Integer.toString(number);

        for(int i = num.length(); i > 0; i--){
            sb.append(num.charAt(i - 1));
        }
        return sb.toString();
    }
}
