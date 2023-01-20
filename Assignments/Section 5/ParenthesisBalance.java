package genspark.assignments.section5;

import genspark.assignments.Assignment;
import java.util.Stack;

public class ParenthesisBalance implements Assignment {
    public String solution(String s) {
        if( s.equals("")){
            return "unbalanced";
        } else {
            String tmp = s.replace("()", "");
            if(tmp.isEmpty()){
                return "balanced";
            } else {
                return "unbalanced";
            }
        }
    }
}
