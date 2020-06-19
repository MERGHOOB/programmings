package array;

/**
 * 1004. Max Consecutive Ones III
 * Medium
 * Given an array A of 0s and 1s, we may change up to K values from 0 to 1.
 * <p>
 * Return the length of the longest (contiguous) subarray that contains only 1s.
 */
public class LC1004MaximumConsecutiveOneIII {
    public int longestOnes(int[] A, int K) {

        int maxLen = 0;
        int len = 0;
        int numOfZero = 0;
        int nextWindowStart = 0;
        for (int i = 0, j = 0; i <= j && j < A.length; ) {

            if (A[j] == 1) {
                if (j != i && A[j - 1] == 0 && len != 0) {
                    nextWindowStart = j;
                }
                len++;
                j++;
            } else {
                if (numOfZero != K) {
                    numOfZero++;
                    len++;
                    j++;
                } else {
                    numOfZero = 0;
                    if(nextWindowStart != 0 ) {
                        j = nextWindowStart;
                    }
                    else {
                        j++; i= j;
                    }
                    nextWindowStart = 0;
                    maxLen = Integer.max(maxLen, len);
                    len = 0;
                }
            }
        }
        return Integer.max(maxLen, len);

    }

    public int myAtoi(String str) {

        str = str.trim();

        boolean numseen = false;
        boolean signseen = false;
        int sign = 1;

        long number = 0;

        for(int i = 0; i<str.length(); i++) {

            char c = str.charAt(i);
            if(c >='0' && c <='9') {

                numseen = true;
                number  = (number * 10) + Character.getNumericValue(c);
            }
            else if(c == ' ') {
                if(numseen || signseen) {
                    return 0;
                }
            }
            else if(c=='+' || c=='-') {
                if(numseen || signseen) {
                    return 0;
                }
                if(c=='-'){
                    sign = -1;
                }
                signseen = true;
            }
            else {
                break;
            }

        }
        number *= sign;
        if(number < Integer.MAX_VALUE && number > Integer.MIN_VALUE) {
            return (int)number;
        }
        else if( sign > 0) {
            return Integer.MAX_VALUE;
        }
        return Integer.MIN_VALUE;

    }
    public static void main(String[] args) {
//        int[] arr = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
//        int[] arr = {1,1,1,0,0,0,1,1,1,1,0};
//        int[] arr = {0,1,0,0,0,0,0,0,1,1,1};
        int[] arr = {0,0,1,1,1,0,0};
        int k =0;

//        System.out.println(new LC1004MaximumConsecutiveOneIII().longestOnes(arr, k));
        System.out.println(new LC1004MaximumConsecutiveOneIII().myAtoi("42"));
    }
}
