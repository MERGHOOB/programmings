package dp;

import java.util.Stack;

/**
 * 42. Trapping Rain Water
 * Hard
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 */
public class TrappingWater {
    public int trap(int[] height) {

        // return bruteforce(height);
        // return dynamicProgramming(height); // o(2n)
        //return usingStack(height);// for less space is it possible o(n) in worst case
        return usingTwoPointers(height);// On space O(n) time


    }



    private int usingTwoPointers(int[] height) {

        int leftMax = 0 , rightMax = 0;

        int left = 0, right = height.length-1;

        int water  = 0;
        while(left < right) {

            if(height[left] < height[right]) { // count near left as water height is                                                          determined by left height in the case
                if(height[left] >= leftMax) { // it means no trap
                    leftMax = height[left];
                }
                else
                    water += (leftMax-height[left]);
                left++;
            }
            else {
                if(height[right] >=rightMax) {
                    rightMax= height[right];
                }
                else
                    water += (rightMax- height[right]);

                right--;

            }


        }
        return water;


    }

    private int usingStack(int[] height) {

        //keep a stack and iterate over the array
        // if small from the top or empty // it means there is a chance of trapped water

        Stack<Integer> s = new Stack<>();
        int water = 0, current = 0;
        while(current < height.length) {

            while(!s.isEmpty() && height[current] > height[s.peek()]) {
                int trapped = s.pop();
                if(s.isEmpty()) {
                    break; // it means nothing to trap
                }

                int distance = current-s.peek()-1;
                int boundedHeight= Integer.min(height[current], height[s.peek()]) - height[trapped];
                water += distance * boundedHeight;

            }
            s.push(current++);
        }
        return water;

    }


    private int dynamicProgramming(int[] height) {

        if(height.length <3)
        {
            return 0;
        }

        //pre compute leftmax and right max for each element
        int [] lmax = new int[height.length];
        int [] rmax = new int[height.length];

        lmax[0] = height[0];
        for(int i = 1; i<height.length; i++) {
            lmax[i] = Integer.max(lmax[i-1], height[i]);
        }

        rmax[height.length-1] = height[height.length-1];
        for(int j=height.length-2; j>=0; j--) {
            rmax[j] = Integer.max(rmax[j+1], height[j]);
        }

        int tappedWater = 0;
        for(int i = 1; i<height.length-1; i++) {
            tappedWater += Integer.min(lmax[i], rmax[i]) - height[i];
        }
        return tappedWater;

    }

    private int bruteforce(int [] height) {
        if(height.length <3) {
            return 0;
        }

        int tappedWater = 0;
        for(int i = 1; i<height.length-1; i++) {

            int leftMax = -1;

            for(int j = 0; j<=i;j++) {
                leftMax = Integer.max(leftMax, height[j]);
            }

            int rightMax = -1;

            for(int j= height.length-1; j>=i;j--) {
                rightMax = Integer.max(rightMax, height[j]);
            }

            tappedWater += Integer.min(leftMax, rightMax) - height[i];

        }

        return tappedWater;
    }
}