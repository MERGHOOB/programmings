package dp;

public class LC221_MaximalSquare {

    public static final char ONE = '1';

    public static int maximalSquare(char[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int[][] dp = new int[matrix.length][matrix[0].length];

        int maxSize = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == ONE) {
                dp[i][0] = 1;
                maxSize = 1;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == ONE) {
                dp[0][i] = 1;
                maxSize = 1;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {

                if (matrix[i][j] == ONE) {

                    int value = Integer.min(Integer.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]);
                    dp[i][j] = 1 + value;
                    maxSize = Integer.max(dp[i][j], maxSize);
                }


            }
        }

        return maxSize*maxSize;
    }

    public static void main(String[] args) {
        char[][] chars = {
                {'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}
        };

        System.out.println(maximalSquare(chars));
    }
}
