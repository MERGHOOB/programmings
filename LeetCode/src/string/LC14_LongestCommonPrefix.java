package string;

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 */
public class LC14_LongestCommonPrefix {
    private static String longestCommonPrefix(String[] inputs) {

        if (inputs.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder("");
        int index = 0;
        while (isSameCharAtIndex(index, inputs)) {
            stringBuilder.append(inputs[0].charAt(index++));
        }

        return stringBuilder.toString();


    }

    private static boolean isSameCharAtIndex(int index, String[] inputs) {


        if (index >= inputs[0].length()) {
            return false;
        }
        char currentCharacter = inputs[0].charAt(index);
        for (int i = 1; i < inputs.length; i++) {
            if (index >= inputs[i].length() || currentCharacter != inputs[i].charAt(index)) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {

        String[] inputs = new String[]{
                "abca", "abc"};
        System.out.println(longestCommonPrefix(inputs));

    }

}
