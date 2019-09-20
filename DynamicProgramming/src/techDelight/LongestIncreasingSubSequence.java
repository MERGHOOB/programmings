package techDelight;

import java.util.Arrays;

public class LongestIncreasingSubSequence {

    public int lengthOfLIS(int[] numbs) {
        if (numbs == null || numbs.length == 0) {
            return 0;
        }
        if (numbs.length == 1) {
            return 1;
        }

        int LIS[] = new int[numbs.length];

        LIS[0] = 1; // lenght of LIS will be 1 with first element
        int maxLen = 1;
        //start the second element
        for (int i = 1; i < numbs.length; i++) {

            // do for each element in nums[0..i-1]
            for (int j = 0; j < i; j++) {
                if (numbs[j] < numbs[i] && LIS[i] < LIS[j]) {
                    LIS[i] = LIS[j];
                }
            }

            //included in numbs[i] into LIS[i]
            LIS[i]++;
            maxLen = Integer.max(maxLen, LIS[i]);
        }
        return maxLen;
    }


    public int lengthOfLISPatience(int[] numbs, int length) {
        if (numbs == null || numbs.length == 0) {
            return 0;
        }
        if (numbs.length == 1) {
            return 1;
        }
        int tailTable[] = new int[length];
        int len; //always point on empty slot

        tailTable[0] = numbs[0];
        len = 1;
        for (int i = 1; i < length; i++) {

            if (numbs[i] < tailTable[0]) {
                tailTable[0] = numbs[i]; // new list
            } else if (numbs[i] > tailTable[len - 1]) {
                tailTable[len++] = numbs[i];
            } else {
                // numbs[i] wants to be current end candidate of an existing
                //subsequence. It will replace ceil value in tailTable

                tailTable[ceilIndex(tailTable, -1, len - 1, numbs[i])] = numbs[i];
            }


        }

        for(int i = 0; i<len; i++) {
            System.out.println(tailTable[i]);
        }
        return len;
    }

    private int ceilIndex(int[] tailTable, int left, int right, int val) {

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (tailTable[mid] >= val) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {

        int[] numbs = new int[]{2, 5, 3, 7, 11, 8, 10, 13, 6};
        System.out.println(new LongestIncreasingSubSequence().lengthOfLIS(numbs));
        System.out.println(new LongestIncreasingSubSequence().lengthOfLISPatience(numbs, numbs.length));


    }

}
