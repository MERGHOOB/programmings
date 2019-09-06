package string;

import java.util.Stack;

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.
 */
public class LC20_ValidParantheses {

    private static char openBraacket = '(';
    private static char closeBraacket = ')';

    private static char curlyOpen = '{';
    private static char curlyClose = '}';

    private static char rectangleOpen = '[';
    private static char rectangleClose = ']';



    public static boolean isValid(String input) {

        if(input.isEmpty()) {
            return true;
        }
        if(input.length()%2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();

        char[] chars = input.toCharArray();
        for (Character value: chars) {
            if(value == openBraacket || value == curlyOpen || value == rectangleOpen) {
                stack.push(value);
            }
            else
            {
                if(stack.isEmpty() || stack.peek() != isOpposite(value)) {
                    return false;
                }
                    stack.pop();

            }
        }
        return stack.isEmpty();
    }

    private static Character isOpposite(Character value) {
        if(value == closeBraacket) {
            return openBraacket;
        }
        if(value == curlyClose) {
            return curlyOpen;
        }
        if(value == rectangleClose){
            return rectangleOpen;
        }

        throw new IllegalStateException("Char not allowed");
    }

    public static void main(String[] args) {

        String input = "{{";
        System.out.println(isValid(input));

    }
}
