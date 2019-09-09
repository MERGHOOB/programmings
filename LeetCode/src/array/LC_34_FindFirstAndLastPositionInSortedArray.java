package array;

import java.util.Arrays;

public class LC_34_FindFirstAndLastPositionInSortedArray {


    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 6;
        int[] array = new LC_34_FindFirstAndLastPositionInSortedArray().searchRange(nums, target);
        for(int i  = 0; i<array.length; i++) {
            System.out.println(array[i]);
        }
    }
// Search target's first postion and target+1 first possible position
    private int[] searchRange(int [] nums, int target) {

        int first = findFirstIndexFor(target, nums);
        if(first >= nums.length || nums[first] != target) {
            return new int[]{-1,-1};
        }

        int second = findFirstIndexFor(target+1, nums) -1;
        return new int[] {first, second};
    }

    private int findFirstIndexFor(int target, int[] nums) {

        int left = 0, right = nums.length;
        while(left < right) {
            int mid =  left + ((right-left)>>1);
            if(nums[mid] < target) {
                left = mid+1;
            }
            else {
                right = mid;
            }
        }
        return left; // first postiion for target, whether it is present in array or not.
    }


    //BRUTE-FORCE still fast:
    // Find element first then find: first and last o(logn) using BS

//    private int[] searchRange(int[] nums, int target) {
//
//
//        int x = -1, y = -1;
//
//        int left = 0, right = nums.length -1;
//        while(left <=right) {
//
//            int mid = (left + right) /2;
//
//            if(nums[mid] == target) {
//                x=mid; y =mid;
//                int leftForLast = mid, rightForLast = right;
//                while(leftForLast <= rightForLast) {
//                    int midForLast = (leftForLast+rightForLast) /2;
//                    if(nums[midForLast] == target) {
//                        if(midForLast >= nums.length-1 || nums[midForLast] != nums[midForLast+1]) {
//                            y = midForLast;
//                            break;
//                        }
//                        else{
//                            leftForLast = midForLast+1;
//                        }
//                    }
//                    else if(nums[midForLast] > target) {
//                        rightForLast = midForLast-1;
//                    }
//                    else {
//                        leftForLast = midForLast+1;
//                    }
//                }
//
//
//                int leftForFirst = left, rightForFirst = mid;
//                while(leftForFirst <= rightForFirst) {
//                    int midForLast = (leftForFirst+rightForFirst) /2;
//                    if(nums[midForLast] == target) {
//                        if(midForLast <= 0 || nums[midForLast] != nums[midForLast-1]) {
//                            x = midForLast;
//                            break;
//                        }
//                        else{
//                            rightForFirst = midForLast-1;
//                        }
//                    }
//                    else if(nums[midForLast] < target){
//                        leftForFirst = midForLast+1;
//                    }
//                    else {
//                        rightForFirst = midForLast-1;
//                    }
//                }
//                break;
//            }
//            else if(nums[mid] > target) {
//                right = mid-1;
//            }
//            else {
//                left = mid+1;
//            }
//
//        }
//
//        return new int[]{x,y};
//    }
}


/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
 */
