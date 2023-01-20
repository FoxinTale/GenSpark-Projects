package genspark.assignments.section2;

import genspark.assignments.Assignment;

public class CheckingAGrade implements Assignment {
    public String solution(int grade) {
        if(grade > 100){
            return " Someone did well.";
        } else if(grade >= 90){
            return "A";
        } else if (grade >= 80) {
            return "B";
        } else if (grade >= 70) {
            return "C";
        } else {
            return "FAILURE";
        }
    }
}
