package genspark.assignments.section2;

import genspark.assignments.Assignment;

public class ReverseAStringForLoop implements Assignment {
    public String solution(String str) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        if(str.length() > 1){
            StringBuilder sb = new StringBuilder();
            for(int i = str.length(); i > 0; i--){
                sb.append(str.charAt(i - 1));
            }
            return sb.toString();
        } else {
            return str;
        }
    }
}
