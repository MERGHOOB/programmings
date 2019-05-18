package array;

/*
Share
Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?
 */
public class LC75_SortColors {

    public static void sortColors(int[] nums) {

       int cand0 = 0, cand2= nums.length -1;


       for(int i = 0; i<=cand2;) {

           if(nums[i] ==0 ){
               //swap it with cand0
               swap(nums, i, cand0);
               i++;
               cand0++;

           }
           else if(nums[i] == 2) {
               //swap it with cand2;
               swap(nums, i, cand2);
               cand2--; // i should not be decremented
           }
           else // in case of 1 just move i, no need to exchange
           {
               i++;
           }



       }
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }


    public static void main(String[] args) {


        int arr[] = new int[] {
                2,2,2,2,0,2,1,1,0,1,0,0,0
//                2,0,2,1,1,0
//               1,0
//                1,2,0
        };

        LC75_SortColors.sortColors(arr);

        for(int ele: arr) {
            System.out.println(ele);
        }


    }
}
