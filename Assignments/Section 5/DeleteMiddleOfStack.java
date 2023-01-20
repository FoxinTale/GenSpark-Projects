package genspark.assignments.section5;

import genspark.assignments.Assignment;
import java.util.Stack;

public class DeleteMiddleOfStack implements Assignment {
    public Stack<Integer> solution(Stack<Integer> stack) {
        if(stack.empty()){
            return stack;
        } else {
            if(stack.size() == 1 || stack.size() == 2){
                stack.remove(0);
            } else {
                int halfSize = stack.size() / 2;
                try{
                    if(stack.size() % 2 == 0){
                        stack.remove(halfSize -1);
                    } else  {
                        stack.remove(halfSize);
                    }
                } catch (IndexOutOfBoundsException IOOBE){

                }
            }
            return stack;
        }
    }
}
