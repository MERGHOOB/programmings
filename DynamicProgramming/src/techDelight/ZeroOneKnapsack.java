package techDelight;

import java.util.HashMap;
import java.util.Map;

public class ZeroOneKnapsack {

    private int knappSack(int[] values, int[] weights, int remainWeight, int currentItemIndex) {

        if (remainWeight < 0) {
            return Integer.MIN_VALUE;
        }


        if (currentItemIndex < 0 || remainWeight == 0) {
            return 0;
        }

        int include = values[currentItemIndex] + knappSack(values, weights, remainWeight - weights[currentItemIndex], currentItemIndex - 1);

        int exclude = knappSack(values, weights, remainWeight, currentItemIndex - 1);

        return Integer.max(include, exclude);
    }


    public static void main(String[] args) {

        int[] v = {20, 5, 10, 40, 15, 25};
        int[] w = {1, 2, 3, 8, 7, 4};

        // Knapsack capacity
        int W = 10;
        System.out.println(new ZeroOneKnapsack().knappSack(v, w, W, w.length - 1));
        System.out.println(new ZeroOneKnapsack().knappSackWithLookUp(v, w, W, w.length - 1));
        System.out.println(new ZeroOneKnapsack().knappSackWithBottomUp(v, w, W));
    }

    private static Map<String, Integer> lookUp = new HashMap<>();

    private int knappSackWithLookUp(int[] values, int[] weights, int remainWeight, int currentItemIndex) {

        if (remainWeight < 0) {
            return Integer.MIN_VALUE;
        }
        String key = remainWeight + "|" + currentItemIndex;

        if (lookUp.containsKey(key)) {
            return lookUp.get(key);
        }
        if (currentItemIndex < 0 || remainWeight == 0) {
            lookUp.put(key, 0);

        } else {

            int include = values[currentItemIndex] + knappSack(values, weights, remainWeight - weights[currentItemIndex], currentItemIndex - 1);
            int exclude = knappSack(values, weights, remainWeight, currentItemIndex - 1);
            lookUp.put(key, Integer.max(include, exclude));
        }

        return lookUp.get(key);

    }

    private int knappSackWithBottomUp(int[] values, int[] weights, int weightCapacity) {

        int[][] dp = new int[values.length + 1][weightCapacity + 1];

        for (int j = 0; j <= weightCapacity; j++) {
            dp[0][j] = 0; // as no item as not value collected
        }

        for (int i = 1; i <= values.length; i++) { // do for ith item.

            for (int j = 0; j <= weightCapacity; j++) { // consider all weight from 0 to weightCapacity

                if (weights[i - 1] > j) { // can't collect as weight of item is greater than weight
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Integer.max(dp[i - 1][j], // no collection
                            dp[i - 1][j - weights[i - 1]] + values[i - 1]); // collected
                }
            }
        }

        return dp[values.length][weightCapacity]; // O(nw) time  O(nw) space

    }

}
