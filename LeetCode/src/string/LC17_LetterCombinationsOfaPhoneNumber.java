package string;

import java.util.*;

public class LC17_LetterCombinationsOfaPhoneNumber {

    private static List<String> table = Arrays.asList("-1", "-1", "abc", "def",
            "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");

    private static List<String> letterCombinations(String digits) {

        List<String> strings = new ArrayList<>();
        if (digits.isEmpty()) {
            return strings;
        }

        LinkedList<String> queue = new LinkedList<>();
        queue.add("");

        while (!queue.isEmpty()) {

            String s = queue.remove(); // which is ""
            if (s.length() == digits.length()) {
                strings.add(s);
            } else {
                String valueToAppend = table.get(Character.getNumericValue(digits.charAt(s.length())));

                for (int i = 0; i < valueToAppend.length(); i++) {
                    queue.add(s + valueToAppend.charAt(i));
                }

            }

        }
        return strings;

    }

    public static void main(String[] args) {

        String input = "23";

        System.out.println(letterCombinations(input));

    }


}
