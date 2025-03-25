package a4;

import java.util.ArrayDeque;

public class Infix {

    public static Double infixToPostfix(ArrayDeque<Object> tokens) {
        ArrayDeque<Object> stack = new ArrayDeque<Object>();
        ArrayDeque<Object> queue = new ArrayDeque<Object>();
        for (Object t : tokens) {
            if (t instanceof Double){
                queue.add(t);
            }
            else if (t instanceof Character){
                if (t.equals('(')){
                    stack.push(t);
                }
                else if (t.equals(')')){
                    while(stack.peekFirst() == null || !stack.peekFirst().equals('(')){
                        if (stack.peekFirst() == null){
                            throw new IllegalArgumentException();
                        }
                        queue.add(stack.pop());
                    }
                    stack.pop();
                }
                else{
                    while (stack.size() > 0)
                    {
                        if ( ( isLeft((Character)t) && (charValue((Character)t) == charValue((Character)stack.peekFirst())) ) || charValue((Character)t) < charValue((Character)stack.peekFirst()) ){
                            queue.add(stack.pop());
                        }
                        else { break; }
                    }
                    stack.push(t);
                }
            }
            //debugging help delete later
            System.out.println(queue);
            System.out.println(stack);
            System.out.println();
        }
        while (stack.size() > 0) {
            if (stack.peekFirst().equals('(')){
                throw new IllegalArgumentException();
            }
            queue.add(stack.pop());
            //debugging help delete later
            System.out.println(queue);
            System.out.println(stack);
            System.out.println();
        }
        return Postfix.postfix(queue);
    }

    public static int charValue(Character c){
        if (c.equals('^')){
            return 4;
        }
        if (c.equals('*') || c.equals('/')){
            return 3;
        }
        if (c.equals('*') || c.equals('/')){
            return 2;
        }
        return 0;
    }



    public static boolean isRight(Character c){
        if (c.equals('^')){
            return true;
        }
        return false;
    }

    public static boolean isLeft(Character c){
        return !isRight(c);
    }

}

