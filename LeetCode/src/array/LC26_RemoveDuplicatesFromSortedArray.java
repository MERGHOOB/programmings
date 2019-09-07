package array;
/*
Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.
 */
public class LC26_RemoveDuplicatesFromSortedArray {


    public int removeDuplicates(int[] nums) {

        int result = 0;
        if(nums.length == 0) {
            return result;
        }
        int count = 1;
        result = 1;
        for(int i = 1; i< nums.length; i++) {

            while(i < nums.length && nums[i] == nums[i-1]) {
                i++;
            }
            if(i == nums.length) {
                break;
            }
            else {
                nums[count++]    = nums[i]     ;
                result++;
            }


        }
        return  result;

    }

    private void swap(int[] nums, int j, int i) {
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]= temp;
    }

}
