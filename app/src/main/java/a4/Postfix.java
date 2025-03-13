package a4;

import java.util.ArrayDeque;

public class Postfix {

    public static Double postfix(ArrayDeque<Object> tokens) {
        ArrayDeque<Double> stack = new ArrayDeque<Double>();
        for (Object t : tokens) {
            if (t instanceof Double){
                stack.push((Double)t);
            }
            else if (t instanceof Character){
                if (stack.size() < 2){
                    throw new IllegalArgumentException();
                }
                if (t.equals('+')){
                    stack.push(stack.pop()+stack.pop());
                }
                else if (t.equals('-')){
                    Double second = stack.pop();
                    stack.push(stack.pop()-second);
                }
                else if (t.equals('*')){
                    stack.push(stack.pop()*stack.pop());
                }
                else if (t.equals('/')){
                    Double second = stack.pop();
                    stack.push(stack.pop()/second);
                }
            }            
        }
        if (stack.size() != 1){
            throw new IllegalArgumentException();
        }
        return stack.pop();
    }
    
}