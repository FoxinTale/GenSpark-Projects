package genspark.assignments.section3;

import genspark.assignments.Assignment;

public class DivideByZero implements Assignment {
    public Object solution(int one, int two) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
       try{
           return one / two;
       } catch (ArithmeticException AE){
           return "Caught Exception: Divide by zero";
       }
    }
}
