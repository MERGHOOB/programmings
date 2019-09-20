package techDelight;

//Maximum of length of repeated Array is variant of this problem
/*
Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

Example 1:

Input:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
Output: 3
Explanation:
The repeated subarray with maximum length is [3, 2, 1].


Note:

1 <= len(A), len(B) <= 1000
0 <= A[i], B[i] < 100
 */
public class T3_LongestCommonSubString {


    public static void main(String[] args) {
        String first = "12321";
        String second = "32147";


        System.out.println(new T3_LongestCommonSubString().findLengthOfLCS(first, second));
    }

    private int findLengthOfLCSFast(String first, String second) {
        int [] dp = new int[second.length()+1];
        int maxLen = 0;

        for(int i = 0; i<first.length(); i++) {
            for(int j = second.length()-1; j>=0; j++) {

                if(first.charAt(i) == second.charAt(j)) {
                    dp[j+1] = 1+ dp[j];
                    maxLen = Integer.max(maxLen, dp[j+1]);
                }
                else
                {
                    dp[j+1] = 0;
                }

            }
        }
        return maxLen;
    }

    private int findLengthOfLCS(String first, String second) {
        int matrix[][] = new int[first.length()+1][second.length()+1];

        return findLength(first.toCharArray(), first.length(), second.toCharArray(), second.length(),matrix);

    }

    /*
    O(n^2) it is still further reduced using SuffixTree
     */
    private int findLength(char[] first, int m, char[] second, int n, int [][] matrix) {

        if(m == 0 || n == 0) {
            return 0;
        }



        int maxlen = 0;
//        int endingIndex = m; if you want substring use: substr from (endingIndex - maxLen to endingIndex)
        for(int i = 1; i<=m ; i++) {

            for(int j = 1; j<=n; j++) {

                if(first[i-1] == second[j-1]) {
                    matrix[i][j] = 1+ matrix[i-1][j-1];
                    if (maxlen < matrix[i][j]) {
                       maxlen = matrix[i][j];
//                       endingIndex = i;
                    }
                }
            }
        }
        return maxlen;
    }
}
