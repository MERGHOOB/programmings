package techDelight;

public class LevenshtheinEditDistance {


    public int minDistance(String first, String second) {

        int[][] dp = new int[first.length() + 1][second.length() + 1];


        for (int i = 0; i <= first.length(); i++) {
            for (int j = 0; j <= second.length(); j++) {

                if (i == 0) {
                    dp[i][j] = j;
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = i;
                    continue;
                }

                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {

                    int replaceDistance = dp[i - 1][j - 1] + 1;
                    int insertDistance = dp[i][j - 1] + 1;
                    int deleteDistance = dp[i - 1][j] + 1;

                    dp[i][j] = Math.min(Math.min(replaceDistance, insertDistance), deleteDistance);
                }

            }
        }
        return dp[first.length()][second.length()];


    }

    public static void main(String[] args) {

        System.out.println(new LevenshtheinEditDistance().minDistance("a", "b"));
        System.out.println(new LevenshtheinEditDistance().minDistance("horse", "ros"));
    }

}
