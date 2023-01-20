package genspark.assignments.section2;

import genspark.assignments.Assignment;

public class ReverseAStringWhileLoop implements Assignment {
    public String solution(String str) {
        if(str.length() > 1){
            StringBuilder sb = new StringBuilder();
            int i = str.length();
            while (i > 0){
                sb.append(str.charAt(i - 1));
                i -= 1;
            }

            return sb.toString();
        } else {
            return str;
        }
    }
}
