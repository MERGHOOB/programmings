package string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Share
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
public class LC22_GenerateParantheses {

    public static void helper(int countOpen, int closeCount, int n, StringBuilder stringBuilder, List<String> result) {
        if(countOpen == n && closeCount == n) {
            result.add(stringBuilder.toString());
        }
        else {
            if(countOpen != n) {
                stringBuilder.append("(");
                helper(countOpen+1, closeCount, n, stringBuilder, result);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            if(closeCount < countOpen) {
                stringBuilder.append(")");
                helper(countOpen, closeCount+1, n, stringBuilder, result);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
    }

    public static List<String> generateParenthesis(int n) {

        List<String> list = new LinkedList<>();
        helper(0, 0, n, new StringBuilder(),list);
        return list;
    }
    public static void main(String[] args) {
        int n = 3;

        System.out.println(generateParenthesis(n));



    }
}
