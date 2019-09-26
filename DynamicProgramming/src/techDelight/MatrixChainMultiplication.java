package techDelight;

public class MatrixChainMultiplication {

    public int minOperation(int[] nums) {

        int [][] lookUp = new int[nums.length][nums.length];
        for(int i = 0; i<nums.length; i++) {
            for(int j = 0; j<nums.length; j++) {
                lookUp[i][j] = -1;
            }
        }
        return minOperation(nums, 0, nums.length - 1, lookUp);

    }

    private int minOperation(int[] nums, int start, int end, int[][] lookUp) {
        if (start + 1 >= end) { // nothing to multiplication, as two dims means only one matrix
            return 0;
        }
        if(lookUp[start][end] != -1) {
            return lookUp[start][end];
        }

        int minCost = Integer.MAX_VALUE;
        for (int k = start + 1; k < end; k++) {

            if(lookUp[start][k] == -1) {
                lookUp[start][k] = minOperation(nums, start, k, lookUp);
            }
            if(lookUp[k][end] == -1) {
                lookUp[k][end] = minOperation(nums, k, end, lookUp);
            }

            int cost = lookUp[start][k]; // Matrix[i+1..k] to get i*K matrix
            cost += lookUp[k][end]; //Matrix [k+1, end] to get k+1.end matrix

            cost += nums[start] * nums[k] * nums[end]; // cost of i*k and k*j

            lookUp[start][end] = Integer.min(minCost, cost);
        }
        return lookUp[start][end];
    }




    public static void main(String[] args) {
        int[] nums = {10, 30, 5, 60};

        System.out.println(new MatrixChainMultiplication().minOperation(nums));
    }


}
