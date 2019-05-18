package dp;

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 */
public class LC10_RegularExpressionMatching {

    //51ms
    public boolean isMatchUsingSubstring(String text, String pattern) {

        // if pattern is empty and
        if(pattern.isEmpty()) return text.isEmpty();

        // if text is empty when pattern is not return false
        // either character present should match or '.' is present.

        boolean firstMatch = !text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.');


        if(pattern.length() >=2 && pattern.charAt(1) == '*') {

            return (firstMatch && isMatchUsingSubstring(text.substring(1), pattern) ||
                    isMatchUsingSubstring(text, pattern.substring(2)));


        }
        else {
            return firstMatch && isMatchUsingSubstring(text.substring(1),pattern.substring(1));
        }



    }

    //10ms
    private boolean isMatchRecursive(char[] text, char[] pattern, int i, int j) {


        if(j  == pattern.length) {
            return i== text.length;
        }

        boolean firstMatch = i <text.length && (pattern[j] == '.' || pattern[j] == text[i]);

        if(j+2 <=pattern.length && pattern[j+1] == '*') {
            return (
                    firstMatch &&
                    isMatchRecursive(text, pattern, i + 1, j)
                    )   ||
                        isMatchRecursive(text, pattern, i, j + 2);
        }
        return firstMatch &&
                        isMatchRecursive(text,pattern, i+1,j+1);

    }

    public boolean isMatch(String text, String pattern) {

        char[] textArray = text.toCharArray();
        char[] patternArray = pattern.toCharArray();

//        return isMatchRecursive(textArray, patternArray, 0, 0);
        return isMatchWithDP(textArray, patternArray);
    }

    /**
     * Dynamic Programming: 2ms
     */

    private boolean isMatchWithDP(char[] text, char[] pattern) {


        boolean[][] table = new boolean[text.length + 1][pattern.length + 1];

        table[0][0] = true;

        //  a* can be mappend to empty string to handle that case: a*b*
        for (int j = 1; j <= pattern.length; j++) {
            if (pattern[j - 1] == '*') {
                table[0][j] = table[0][j - 2];
            }
        }

        for (int i = 1; i <= text.length; i++) {

            for (int j = 1; j <= pattern.length; j++) {

                // if char and pattern matches check that last characters already matched or not
                if (text[i - 1] == pattern[j - 1] || pattern[j - 1] == '.') {
                    table[i][j] = table[i - 1][j - 1];

                }
                // if * comes, it means we need to check that already matched last part of pattern matched
                else if (pattern[j - 1] == '*') {

                    table[i][j] = table[i][j - 2];

                    // handle xaa, xa*
                    if ((pattern[j - 2] == '.' || text[i - 1] == pattern[j - 2])) {
                        table[i][j] = table[i][j] || table[i - 1][j];
                    }

                }
            }
        }
        return table[text.length][pattern.length];

    }


    public static void main(String[] args) {
        new LC10_RegularExpressionMatching().isMatch("aa", "a*");
    }




}
