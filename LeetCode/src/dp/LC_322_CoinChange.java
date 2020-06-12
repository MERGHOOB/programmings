package dp;

public class LC_322_CoinChange {


    public int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int i = 0; i<=amount;i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }

        for (int am = 1; am <= amount; am++) {
            for (int i = 0; i < coins.length; i++) {
                if(coins[i] <= am) {
                    dp[i][am] = Integer.min(dp[i][am-1], dp[i][am-coins[i]] +1);
                }
                else {
                    dp[i][am] = dp[i-1][am];
                }
            }
        }


        return dp[coins.length][amount];
    }


    public static void main(String[] args) {
        LC_322_CoinChange lc_322_coinChange = new LC_322_CoinChange();
        int amount = 11;
        int[] coins = {
                1, 2, 5
        };
        System.out.println(lc_322_coinChange.coinChange(coins, amount));
    }


}
