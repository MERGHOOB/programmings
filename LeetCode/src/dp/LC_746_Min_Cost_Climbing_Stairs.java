package dp;
/*
https://leetcode.com/problems/min-cost-climbing-stairs/
 */
public class LC_746_Min_Cost_Climbing_Stairs {



    private int minCostClimbingStairs(int[] cost) {
        if(cost.length <=1) {
            return 0;
        }
        for(int i = cost.length-3; i>=0; i--) {
            cost[i] += Integer.min(cost[i+1], cost[i+2]);
        }

        return Integer.min(cost[0], cost[1]);
    }

    public static void main(String[] args) {
//        int [] ints = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
//        int [] ints = {10, 15, 20};
        int [] ints = {100, 15};
        int result = new LC_746_Min_Cost_Climbing_Stairs().minCostClimbingStairs(ints);
        System.out.println(result);
    }



}
