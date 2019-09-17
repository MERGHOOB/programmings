package array;
/*
Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

Example 1:
Input: [1,4,3,2]

Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
Note:
1.n is a positive integer, which is in the range of [1, 10000].
2.All the integers in the array will be in the range of [-10000, 10000].
 */
public class LC_561_ArrayPartition_1 {

    public int arrayPairSum(int[] nums) {


        int counts[]  = new int[20001];


        for(int num: nums) {
            counts[num+10000]++;
        }

        int result = 0;
        boolean odd = true;

        for(int i=0; i<counts.length; i++) {
            while(counts[i] != 0){
                if(odd){
                    result += i - 10000;
                }
                odd = !odd;
                counts[i]--;
            }
        }
        return result;


//         Arrays.sort(nums);

//         int sum  = 0;
//         for(int i = 0; i<nums.length; i+=2)
//         {
//             sum +=nums[i];
//         }

//         return sum;

    }
}
