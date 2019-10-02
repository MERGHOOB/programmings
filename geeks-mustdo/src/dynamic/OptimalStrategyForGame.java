package dynamic;

/*
N pots, each with some number of gold coins, are arranged  in a line. You are playing a game against another player.
You take turns picking a pot of gold. You may pick a pot from either end of the line, remove the pot, and keep the gold pieces.
The player with the most gold at the end wins. Develop a strategy for playing this game.

https://practice.geeksforgeeks.org/problems/optimal-strategy-for-a-game/0

You are given an array A of size N. The array contains integers and is of even length. The elements of the array represent N coin of values V1, V2, ....Vn. You play against an opponent in an alternating way.

In each turn, a player selects either the first or last coin from the row, removes it from the row permanently, and receives the value of the coin.

You need to determine the maximum possible amouint of money you can win if you go first.

Input:
The first line of input contains T denoting the number of testcases. T testcases follow. Each testcase contains two lines of input. The first line contains N denoting the size of the array. The second line contains N elements of the array.

Output:
For each testcase, in a new line, print the maximum amout.

Constraints:
1 <= T <= 100
2 <= N <= 100
1 <= Ai <= 106

Examples:
Input:
2
4
5 3 7 10
4
8 15 3 7
Output:
15
22
 */
public class OptimalStrategyForGame {

    public static void main(String[] args) {
        int[] coins = {8,15,3,7};
        System.out.println(maximumCoins(coins));
        coins = new int[]{2, 2, 2, 2};
        System.out.println(maximumCoins(coins));
        coins = new int[]{20,30,2,2,2,10};
        System.out.println(maximumCoins(coins));
        coins = new int[]{5, 3, 7,15};
        System.out.println(maximumCoins(coins));
    }

    private static int maximumCoins(int[] coins) {

        int sum = 0;
        for (int coin : coins) {
            sum += coin;
        }
        return maximumCoins(coins, 0, coins.length - 1, sum); // recursive call for i (0) and j (coins.length-1)


    }
    // consider the fact:
    // 5,3,7,10
    // if user choose: 5 , then it will maximum collect the value: 5+ (25-5) - selected by other user( F[3..10])
    // if user choose: 10, then it will collect: 10 +25-10 - selected by other user F[5..7]

    // F[5..10] = Max [ 25 - F[3,10]==12, 25 - F[5,7] ==13+ ]
    // F[3..10] = Max [ 20 - F[7,10], 20- F[3,7]
    //F[7,10] = 10, F[3,7] = 7

    // F[5,7] = Max [17-F[5,3] = 12, 17-F[3,7] == 10] = 12
    //F[5,3] = 5, F[3,7] = 7

    private static int maximumCoins(int[] coins, int i, int j, int sum) {

        if (i + 1 == j) {
            return Integer.max(coins[i], coins[j]);
        }

        return Integer.max(sum - maximumCoins(coins, i + 1, j, sum-coins[i]),
                sum - maximumCoins(coins, i, j - 1, sum-coins[j]));


    }


}
