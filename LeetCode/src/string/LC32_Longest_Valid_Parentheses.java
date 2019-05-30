package string;

/*
 Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"

 */


public class LC32_Longest_Valid_Parentheses {



    public int longestValidParentheses(String s) {

        int openCount = 0;
        int closeCount = 0;
        int maxLength = 0;
        int currentLength = 0;
        char[] chars = s.toCharArray();
        int i = 0;
        while( i< chars.length) {

            switch (chars[i]) {
                case '(' :

                    openCount++;
                    break;

                case ')' :
                    /*
                    openCount--;
                    if(openCount < 0) {
                        currentLength = 0;
                        openCount = 0;
                        i++;
                        continue;
                    }
                     */

                    closeCount++;
                    if(closeCount > openCount) {
                        closeCount = 0;
                        openCount = 0;
                        i++;
                        continue;

                    }


                    if(closeCount == openCount) { //proper paranthesis
                        maxLength = Math.max(maxLength, 2*closeCount);
                    }
                    break;

                default:
                    throw new IllegalStateException();
            }

            i++;
        }


        return maxLength;

    }

    public static void main(String[] args) {
        System.out.println(new LC32_Longest_Valid_Parentheses().longestValidParentheses("()(()"));
        System.out.println(new LC32_Longest_Valid_Parentheses().longestValidParentheses("("));
        System.out.println(new LC32_Longest_Valid_Parentheses().longestValidParentheses("(()"));
        System.out.println(new LC32_Longest_Valid_Parentheses().longestValidParentheses("(()))"));
        System.out.println(new LC32_Longest_Valid_Parentheses().longestValidParentheses(")()())"));
        System.out.println(new LC32_Longest_Valid_Parentheses().longestValidParentheses("(()"));
    }

}
