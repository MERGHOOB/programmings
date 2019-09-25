package techDelight;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

public class IncreasingSubSequenceWithMaximumSum {


    // main function
    public static void main(String[] args) {
        int[] A = {8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11};

        System.out.println(maxSumIncreasingSubSequence(A));
//        System.out.print("Maximum sum of increasing subsequence is " +
//                maximumSumIncreasingSubsequence(A, 0, A.length, Integer.MIN_VALUE, 0));
    }

    private static int maximumSumIncreasingSubsequence(int[] nums, int start, int length, int prev, int sum) {

        if (start == length) {
            return sum;
        }

        int sumAfterExcludeStartElement = maximumSumIncreasingSubsequence(nums, start + 1, length, prev, sum);
        int sumIfIncludeStartElement = sum;
        if (nums[start] > prev) {
            sumIfIncludeStartElement =
                    maximumSumIncreasingSubsequence(nums, start + 1, length, nums[start], sum + nums[start]);
        }

        return Integer.max(sumAfterExcludeStartElement, sumIfIncludeStartElement);
    }

    private static int maxSumIncreasingSubSequence(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        List<List<Integer>> increasingSubSequences = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            increasingSubSequences.add(new ArrayList<>());
        }

        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        increasingSubSequences.get(0).add(nums[0]);
        int maxSum = nums[0];
        int longestIndex = 0;
        for (int i = 1; i < nums.length; i++) {

            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] > dp[i]) {
                        dp[i] = dp[j];
                        List<Integer> temp = new ArrayList<>(increasingSubSequences.get(j));
                        increasingSubSequences.add(i, temp);
                    }
                }
            }

            dp[i] += nums[i];
            increasingSubSequences.get(i).add(nums[i]);
            if (dp[i] > maxSum) {
                maxSum = dp[i];
                longestIndex = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(increasingSubSequences.get(i));
        }

        System.out.println(increasingSubSequences.get(longestIndex));


//        PrintUtility.print(dp);
        return maxSum;


    }


}
