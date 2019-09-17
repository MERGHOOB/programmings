package array;
/*
Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:

Return true if there exists i, j, k
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.

Example 1:

Input: [1,2,3,4,5]
Output: true
Example 2:

Input: [5,4,3,2,1]
Output: false
 */
public class LC334_IncreasingTripletSequence {
    // one cane use LIS and find a len==3 than break and return true.


    public boolean increasingTriplet(int[] nums) {

        Integer a = null;
        Integer b = null;

        for(int i = 0; i<nums.length-1; i++) {

            if(nums[i] < nums[i+1]) {
                if(a == null) {
                    a = nums[i];
                    b = nums[i+1];
                }
                else{
                    if(a< nums[i] ) return true;
                    if(nums[i] > b || nums[i+1] >b) return true;

                    a = nums[i];
                    b = nums[i+1];
                }
            }

        }
        return false;


    }


}
