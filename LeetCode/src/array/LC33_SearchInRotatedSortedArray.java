package array;

public class LC33_SearchInRotatedSortedArray {


    public static void main(String[] args) {
        int[] ints = new int[]{5, 6, 0, 1, 2};

        System.out.println(new LC33_SearchInRotatedSortedArray().search(ints, 5));
    }

    private int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int left, int right, int target) {

        while (left <= right) {

            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else {

                if (nums[mid] > target) {

                    if (nums[mid] > nums[right] && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }

                } else {
                    if (nums[mid] < nums[left] && target >= nums[left]) {
                        right = mid - 1;
                    } else
                        left = mid + 1;

                }


            }

        }

        return -1;

    }
}

/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).
 */