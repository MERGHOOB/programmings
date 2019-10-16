package array;

import java.util.*;

public class LC_448_Find_All_Numbers_Disappeared_in_an_Array {

    public static List<Integer> findDisappearedNumbers1(int[] nums) {

        List<Integer> list = new ArrayList<>();
        int[] arr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            arr[nums[i] - 1]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (arr[i] == 0) list.add(i + 1);
        }
        return list;

    }

    //With O(n) and without extra space
    public static List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {

            int abs = Math.abs(nums[i]);
            if (nums[abs - 1] < 0) {
                continue;
            }
            nums[abs - 1] = nums[abs - 1] * -1; // marking the value as negative. some value in array remains negative, it means index there is not present in array.

        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;

    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers(nums));
        int[] nums1 = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers1(nums1));

    }


}
