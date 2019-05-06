/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 * <p>
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 */


public class LC11_ContainerWithMostWater {

    public int maxArea(int[] height) {

        if (height.length < 2) {
            return 0;
        }

        int start = 0, end = height.length - 1;

        int maxArea = 0;


        // Widest container is  a good candiadate
        // All other container with less width, need more water level
        // smaller(start,end) can be removed as it does not support higher water level

        while (start < end) {

            maxArea = Math.max(maxArea, Math.min(height[start], height[end]) * (end - start));

            if (height[start] > height[end]) {
                end--;
            } else {
                start++;
            }
        }


        return maxArea;
    }


    public static void main(String[] args) {


        int[] height = new int[]{
                1, 3, 2, 5, 25, 24, 5
        };

        System.out.println(new LC11_ContainerWithMostWater().maxArea(height));


    }


}
