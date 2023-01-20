package genspark.assignments.section2;

import genspark.assignments.Assignment;

public class CheckForPalindrome implements Assignment {
    public boolean solution(String pally) {
        // ↓↓↓↓ your code goes here ↓↓↓↓

        if(pally.length() > 1){
            StringBuilder sb = new StringBuilder();
            for(int i = pally.length(); i > 0; i--){
                sb.append(pally.charAt(i - 1));
            }
            if(sb.toString().equals(pally)){
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }
}
