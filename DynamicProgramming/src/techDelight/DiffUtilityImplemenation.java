package techDelight;

import java.util.Arrays;

public class DiffUtilityImplemenation {


    public static void main(String[] args) {

        String X = "XMJYAUZ";
        String Y = "XMJAATZ";

        new DiffUtilityImplemenation().diff(X, Y);

    }

    private void diff(String first, String second) {

        int[][] dp = fillDPTable(first, second);
        diff(first, first.length(), second, second.length(), dp);

    }

    private void diff(String first, int m, String second, int n, int[][] dp) {
        if (m > 0 && n > 0 && first.charAt(m - 1) == second.charAt(n - 1)) {

            diff(first, m - 1, second, n - 1, dp);
            System.out.print(" " + first.charAt(m - 1));
        }
        //current character of second is not present in first
        else if (n > 0 && (m == 0 || dp[m][n - 1] >= dp[m - 1][n])) {
            diff(first, m, second, n - 1, dp);
            System.out.print(" +" + second.charAt(n - 1));
        }
        //current character of first is not present in second
        else if (m > 0 && (n == 0 || dp[m - 1][n] > dp[m][n - 1])) {
            diff(first, m - 1, second, n, dp);
            System.out.print(" -" + first.charAt(m - 1));
        }
    }

    private int[][] fillDPTable(String first, String second) {
        int[][] dp = new int[first.length() + 1][second.length() + 1];

        for (int i = 1; i <= first.length(); i++) {

            for (int j = 1; j <= second.length(); j++) {

                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }

        }
        return dp;
    }


}
