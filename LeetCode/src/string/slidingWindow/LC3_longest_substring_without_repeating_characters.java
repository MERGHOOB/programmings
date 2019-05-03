package string.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class LC3_longest_substring_without_repeating_characters {

    //10ms
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


    // fastest 8ms
    private int lengthOfLongestSubstring2(String string) {

        if (string == null || string.isEmpty()) {
            return 0;
        }

        int firstPointer = 0;
        int secondPointer = 0;
        int maxLength = 0;

        Map<Character, Integer> map = new HashMap<>();

        while (secondPointer < string.length()) {

            if (map.containsKey(string.charAt(secondPointer))) {
                firstPointer = Math.max(firstPointer, map.get(string.charAt(secondPointer)));
            }
            map.put(string.charAt(secondPointer), secondPointer + 1);

            maxLength = Math.max(maxLength, secondPointer - firstPointer + 1);
            secondPointer++;

        }

        return maxLength;
    }
    public static void main(String[] args) {

        LC3_longest_substring_without_repeating_characters longestSubstring = new LC3_longest_substring_without_repeating_characters();
        int lengthOfLongestSubstring = longestSubstring.lengthOfLongestSubstring("aaabbbabaabababacdefghhhhhhfghhh");

        System.out.println(lengthOfLongestSubstring);
    }
}
