package techDelight;

public class LongestRepeatedSubSequence {


    public static void main(String[] args) {
        System.out.println(new LongestRepeatedSubSequence().longestRepeatedSubSequence("ATACTCGGA"));
    }

    private String longestRepeatedSubSequence(String text) {
        int[][] dp = longestCommonSubSequenceWithIndexNotEqualToEachOther(text, text);

        return longestRepeatedSubSequenceString(text, text.length(), text.length(), dp);


    }

    private String longestRepeatedSubSequenceString(String text, int m, int n, int[][] dp) {
        if (m == 0 || n == 0) {
            return "";
        }

        if (text.charAt(m - 1) == text.charAt(n - 1) && m != n) {
            return longestRepeatedSubSequenceString(text, m - 1, n - 1, dp) + text.charAt(m - 1);
        } else {
            if (dp[m - 1][n] > dp[m][n - 1]) {
                return longestRepeatedSubSequenceString(text, m - 1, n, dp);
            } else
                return longestRepeatedSubSequenceString(text, m, n - 1, dp);
        }

    }

    private int[][] longestCommonSubSequenceWithIndexNotEqualToEachOther(String first, String second) {

        int[][] dp = new int[first.length() + 1][second.length() + 1];


        for (int i = 1; i <= first.length(); i++) {

            for (int j = 1; j <= second.length(); j++) {

                if (first.charAt(i - 1) == second.charAt(j - 1) && i != j) {


                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else
                    dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);
            }

        }
        System.out.println(dp[first.length()][second.length()]);
        return dp;
    }


}
