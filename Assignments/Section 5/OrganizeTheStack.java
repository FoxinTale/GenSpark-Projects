package genspark.assignments.section5;

import genspark.assignments.Assignment;
import java.util.Stack;

public class OrganizeTheStack implements Assignment {
    public Stack<Integer> solution(Stack<Integer> stack) {
        if(stack.isEmpty()){
            return stack;
        } else {
            Stack<Integer> sortedStack = new Stack<>();
            int stackItem;

            while(!stack.isEmpty()){
                stackItem = stack.pop();
                while(!sortedStack.isEmpty() && sortedStack.peek() < stackItem){
                    stack.push(sortedStack.pop());
                }
                sortedStack.push(stackItem);
            }
            return sortedStack;
        }
    }
}
