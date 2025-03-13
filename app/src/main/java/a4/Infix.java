package a4;

import java.util.ArrayDeque;

public class Infix {

    public static Double infixToPostfix(ArrayDeque<Object> tokens) {
        ArrayDeque<Double> stack = new ArrayDeque<Double>();
        ArrayDeque<Double> queue = new ArrayDeque<Double>();
        for (Object t : tokens) {
            if (t instanceof Double){
                queue.push((Double)t);
            }
            else if (t instanceof Character){
                if (t.equals('(')){
                    stack.push(t);
                }
                else if (t.equals(')')){
                    while(!stack.peekFirst().equals('(')){
                        if (stack.peekFirst().equals(null)){
                            throw new IllegalArgumentException();
                        }
                        queue.add(stack.pop());
                    }
                    stack.pop();
                }
                while (stack.size() > 0)
                {
                    
                }
            }
        }
    }

}

