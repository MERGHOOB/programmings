package string.slidingWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class LC3_longest_substring_without_repeating_characters {


    private int lengthOfLongestSubstring(String string) {

        if (string == null || string.isEmpty()) {
            return 0;
        }

        int firstPointer = 0;
        int secondPointer = 0;
        int maxLength = 0;

        Set<Character> set = new HashSet<>();

        while (secondPointer < string.length()) {

            if (set.contains(string.charAt(secondPointer))) {
                set.remove(string.charAt(firstPointer++));
            } else {
                set.add(string.charAt(secondPointer));
                secondPointer++;
                maxLength = Math.max(maxLength, secondPointer - firstPointer);
            }

        }

        return maxLength;
    }

    public static void main(String[] args) {

        LC3_longest_substring_without_repeating_characters longestSubstring = new LC3_longest_substring_without_repeating_characters();
        int lengthOfLongestSubstring = longestSubstring.lengthOfLongestSubstring("aaabbbabaabababacdefghhhhhhfghhh");

        System.out.println(lengthOfLongestSubstring);
    }
}
