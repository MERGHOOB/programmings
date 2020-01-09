
package string;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 */

public class LC5_LongestPalindromicSubstring {


    /**
     * This method provides good performance O(n2) and use less space O(1) space
     */
    private String longestPalindromeExpandingAroundCenter(String text) {

        if (text == null || text.isEmpty()) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < text.length(); i++) {
            int len1 = expandAroundCenter(text, i, i); // if i is center
            int len2 = expandAroundCenter(text, i, i + 1); // if center lies between i,i+1

            int len = Math.max(len1, len2);

            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return text.substring(start, end + 1);
    }

    private int expandAroundCenter(String text, int left, int right) {

        int L = left, R = right;

        while (L >= 0 && R < text.length() && text.charAt(L) == text.charAt(R)) { // do expand until maximum length Pallindrome
            L--;
            R++;
        }
        return R - L + 1;
    }


    //DP O(n2) space and time

    private String longestPalindromeWithDP(String text) {


        // Consider empty
        if (text.isEmpty()) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder(text);

        boolean[][] isPall = new boolean[text.length()][text.length()];


        int start = 0, end = 0;

        for (int first = text.length() - 1; first >= 0; first--) {

            for (int second = first; second < text.length(); second++) {

                isPall[first][second] = stringBuilder.charAt(first) == stringBuilder.charAt(second) &&
                        ((second - first < 3) || isPall[first + 1][second - 1]);

                if (isPall[first][second] && second - first > (end - start)) {
                    start = first;
                    end = second;

                }
            }
        }
        return text.substring(start, end + 1);
    }

    //Main method to test
    public static void main(String[] args) {

        String s = "ababd";
        String palindrome = new LC5_LongestPalindromicSubstring().longestPalindromeWithDP(s);

        System.out.println(palindrome);
    }

    //BruteForce
    private String longestPalindrome(String text) {


        if (text == null || text.isEmpty()) {
            return "";
        }

        if (text.length() == 1) {
            return text;
        }

        int maxLength = 0;
        String pallindrome = "";

        for (int first = 0; first < text.length(); first++) {

            for (int second = first; second < text.length(); second++) {

                String candidatePalindrome = getSubString(text, first, second);

                if (isPallindrome(candidatePalindrome)) {
                    if (candidatePalindrome.length() > maxLength) {
                        pallindrome = candidatePalindrome;
                        maxLength = candidatePalindrome.length();
                    }
                }
            }
        }

        return pallindrome;
    }

    //Helper Function used in BruteForce
    private String getSubString(String text, int first, int second) {
        return text.substring(first, second + 1);
    }

    private boolean isPallindrome(String candidatePallindrome) {
        if (candidatePallindrome.length() == 1) {
            return true;
        }

        int first = 0, last = candidatePallindrome.length() - 1;

        while (first < last) {

            if (candidatePallindrome.charAt(first++) != candidatePallindrome.charAt(last--)) {
                return false;
            }
        }
        return true;
    }

}
