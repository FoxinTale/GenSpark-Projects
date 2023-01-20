package genspark.assignments.section4;

import genspark.assignments.Assignment;

public class FactorialComputation implements Assignment {
    public int solution(int n) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        if(n  == 0){
            return 1;
        } else {
            int factorial = 1;
            for(int i = 2; i <= n; i++){
                factorial *= i;
            }
            return factorial;
            }
        }
    }

