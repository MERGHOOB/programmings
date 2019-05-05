
package string.slidingWindow;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 */

public class LC5_LongestPallindromicSubstring {




    //DP

    private String longestPallindromWithDP(String text) {

        boolean[][] isPall = new boolean[text.length()][text.length()];

        String result = ""; // Consider empty

        for(int first = text.length()-1; first>=0; first--) {

            for(int second = first; second<text.length(); second++) {

                isPall[first][second] = text.charAt(first) == text.charAt(second) &&
                        ((second - first < 3) || isPall[first + 1][second - 1]);

                if(isPall[first][second] && second-first+1 > result.length()) {
                    result = getSubString(text, first,second);
                }
            }
        }
        return result;
    }


    //Main method to test
    public static void main(String[] args) {

        String s = "babad";
        String palindrome = new LC5_LongestPallindromicSubstring().longestPallindromWithDP(s);

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

                String candidatePallindrome = getSubString(text, first, second);

                if (isPallindrome(candidatePallindrome)) {
                    if (candidatePallindrome.length() > maxLength) {
                        pallindrome = candidatePallindrome;
                        maxLength = candidatePallindrome.length();
                    }
                }
            }
        }

        return pallindrome;
    }

//Helper Function used in BruteForce
    private String getSubString(String text, int first, int second) {
        return text.substring(first, second+1);
    }

    private boolean isPallindrome(String candidatePallindrome) {
        if(candidatePallindrome.length() == 1) {
            return  true;
        }

        int first = 0, last = candidatePallindrome.length()-1;

        while(first < last) {

            if(candidatePallindrome.charAt(first++) != candidatePallindrome.charAt(last--)) {
                return false;
            }
        }
        return true;
    }

}
