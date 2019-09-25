package dp;

/*
https://leetcode.com/problems/wiggle-subsequence/

A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative.
The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.

Objective:
Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence.

Input: [1,7,4,9,2,5]
Output: 6
Explanation: The entire sequence is a wiggle sequence.
Example 2:

Input: [1,17,5,10,13,15,10,5,16,8]
Output: 7
Explanation: There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].

 */
public class LC376_LongestWiggleSequence {


    /*
    similar to LIS,

    to add element in sequence, is if it is bigger or lesser and difference is opposite to last difference.
     */

    public static int wiggleMaxLength(int [] nums) {

        if(nums.length < 2) {
            return nums.length;
        }

        int size = nums.length;
        int [] up = new int[size];
        up[0] =1;

        int [] down = new int[size];
        down[0] = 1;

        for (int i = 0; i < size - 1; i++) {

            if (nums[i] < nums[i + 1]) { //wiggling up
                up[i + 1] = down[i] + 1;
                down[i + 1] = down[i];
            } else if (nums[i] > nums[i + 1]) { //wiggling down
                down[i + 1] = up[i] + 1;
                up[i + 1] = up[i];
            } else { // no position
                up[i + 1] = up[i]; // i+1 pos will same as ith pos as no wiggling
                down[i + 1] = down[i];
            }


        }

        return Integer.max(up[size-1], down[size-1]);

    }


    public static int wiggleMaxLength2(int[] nums) { // ON^2


        if (nums == null || nums.length == 0) {
            return 0;
        }

        int size = nums.length;

        int[] up = new int[size];
        int[] down = new int[size];
        up[0] = down[0] = 1;

        for (int i = 1; i < size; i++) { //for each length:
            for (int j = 0; j < i; j++) {
                if (nums[j] == nums[i]) {
                    continue;
                }
                if (nums[i] > nums[j]) { // i is greater than j
                    up[i] = Math.max(up[i], down[j] + 1);
                } else {   // i is lesser than j
                    down[i] = Math.max(up[j] + 1, down[i]);
                }
            }
        }



        return Integer.max(down[size-1], up[size-1]);
    }

    public static boolean isSignSame(int x, int y) {
        return y != 0 && (x ^ y) < 0;
    }

    public static void main(String[] args) {
        int []arr = {1,7,4,9,2,5};
        int []arr1 = {1,2,3,4,5,6,7,8,9};
        int[] arr2 = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};

        System.out.println(wiggleMaxLength(arr));

        System.out.println(wiggleMaxLength(arr2));
        System.out.println(wiggleMaxLength(arr1));
    }
}
