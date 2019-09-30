package array;

import java.util.*;

public class LC128_LongestConsecutiveSequence {


    public int longestConsecutiveWithUnionFind(int []nums) {
        if(nums.length <=1) {
            return 1;
        }
        Map<Integer, Integer> ltoR = new HashMap<>();
        Map<Integer, Integer> rToL = new HashMap<>();

        int result = 0;
        for(int num: nums) {
            if(ltoR.containsKey(num) || rToL.containsKey(num)) { // this is for duplicate value in array
                continue;
            }

            if(ltoR.containsKey(num+1) && rToL.containsKey(num-1)) {

                    int right = ltoR.get(num+1);
                    int left = rToL.get(num-1);

                ltoR.remove(num+1);
                rToL.remove(num-1);

                ltoR.put(left, right);
                rToL.put(right, left);

                result = Math.max(result, right - left +1);
            }
            else if(ltoR.containsKey(num+1)) {
                result = Math.max(result, connect(ltoR, rToL, num, true));
            }
            else if(rToL.containsKey(num-1)) {

                result = Math.max(result, connect(ltoR, rToL, num, false));
            }
            else {
                ltoR.put(num, num); //self loop
                rToL.put(num, num); //self loop
                result =  Math.max(1, result);
            }
        }

    return  result;
    }

    private int connect(Map<Integer, Integer> ltoR, Map<Integer, Integer> rToL, int num, boolean toLeft) {
        if(toLeft) {
            ltoR.put(num, ltoR.get(num+1));
            rToL.put(ltoR.get(num+1), num);

            ltoR.remove(num+1);
            return ltoR.get(num)- num +1;
        }
        else {
            rToL.put(num, rToL.get(num-1)) ;
            ltoR.put(rToL.get(num-1), num);
            rToL.remove(num-1);
            return num - rToL.get(num) +1;

        }

    }

    public int longestConsecutiveWithIntelligentSequenceBuilding(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }

        int longestStreak = 0;

        for(int n: set) {
            if(!set.contains(n-1)) {

                int currentStreak = 1;
                int currentNumber = n;
                while(set.contains(currentNumber+1)) {
                    currentNumber++;
                    currentStreak++;
                }
                longestStreak = Integer.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
        public int longestConsecutive(int[] nums) {


            if(nums.length == 0) {
                return 0;
            }
            Arrays.sort(nums);

            int maxLen = 1;
            int len =  1;
            int current = nums[0];
            boolean increasing = true;
            for(int i =1; i<nums.length;i++) {

                if(nums[i] - current ==1) {
                    len++;
                }
                else{
                    maxLen = Integer.max(len, maxLen);
                    len = 1;
                }

                current = nums[i];
            }

            return Integer.max(len, maxLen);

        }

    public static void main(String[] args) {
        int[] nums = {0,-1};

        System.out.println(new LC128_LongestConsecutiveSequence().longestConsecutive(nums));
    }
}
