package array;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 */
public class LC4_Median_two_sortedArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length > nums2.length) {
            return findMedian(nums2, nums1);
        }
        return findMedian(nums1,nums2);
    }

    private double findMedian(int[] smaller, int[] bigger) {


        double median = 0;

        int smallerLength = smaller.length;
        int biggerLength = bigger.length;
        int minIndex = 0;
        int maxIndex = smallerLength;

        int i = 0, j = 0;
        while(minIndex <= maxIndex) {

            i = (minIndex + maxIndex) /2;
            j = (smallerLength + biggerLength +1)/2 -i;


            if(i < smallerLength && j > 0 && bigger[j-1] > smaller[i]) {
                minIndex = i+1;
            }
            else if( j< biggerLength && i>0 && bigger[j] < smaller[i-1]) {
                maxIndex = i-1;
            }
            else{
                if(i == 0) {
                    median = bigger[j-1];
                }
                else if(j==0) {
                    median = smaller[i-1];
                }
                else{
                    median = Math.max(smaller[i-1],bigger[j-1]);
                }
                break;
            }

        }
        if((smallerLength+ biggerLength )%2 ==1) {
            return median;
        }
        if(i==smallerLength) {
            return (median + bigger[j])/2;
        }
        else if ( j == biggerLength) {
            return (median + smaller[i])/2;
        }
        else
            return (median + Math.min(smaller[i],bigger[j]))/2;

    }



    public static void main(String[] args) {

        int smallerArray [] = new int[] {3,4};
        int bigArray [] = new int[] {1,2};


        System.out.println(new LC4_Median_two_sortedArray().findMedianSortedArrays(smallerArray, bigArray));

    }
}
