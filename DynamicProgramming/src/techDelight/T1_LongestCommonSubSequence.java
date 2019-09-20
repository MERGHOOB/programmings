package techDelight;

import java.util.*;

public class T1_LongestCommonSubSequence {

    public int getLCSLength(String first, String second) {

        int [][]matrix = new int[first.length()+1][second.length()+1];

        return getLCSLength(first.toCharArray(), first.length(), second.toCharArray(), second.length(), matrix);
    }

    //Recursion: TLE, overlapping problem
    private int getLCSLength(char[] first, int m, char[] second, int n, int[][] matrix) {

        if(m == 0 || n== 0) {

            return 0;
        }

        //This approach is bottom up smaller value first, Fast as no further call to recursion
        for(int i = 1; i<=m ;i++) {


            for(int j = 1; j<=n; j++) {
                if(first[i-1] == second[j-1]) {
                    matrix[i][j] = matrix[i-1][j-1]+1;
                }
                else {
                    matrix[i][j] = Integer.max(matrix[i][j-1], matrix[i-1][j]);
                }
            }
        }

        //Top bottom, big value to be filled and recursive calls.

//        if(matrix[m][n] != 0) {
//            return matrix[m][n];
//        }
//        if(first[m-1] == second[n-1]) {
//
//            matrix[m][n] = getLCSLength(first, m-1, second, n-1, matrix)+1;
//        }
//        else {
//            matrix[m][n] = Math.max(getLCSLength(first, m-1, second, n, matrix), getLCSLength(first, m, second, n-1, matrix));
//        }
        return matrix[m][n];
    }

    public List<String> findAllLCS(String first, String second) {
        int matrix[][] = new int[first.length()+1][second.length()+1];
        getLCSLength(first.toCharArray(), first.length(), second.toCharArray(), second.length(),matrix);

     return  getAllLCS(first.toCharArray(), first.length(), second.toCharArray(), second.length(), matrix);

    }

    private List<String> getAllLCS(char[] first, int m, char[] second, int n, int[][] matrix) {

        if( m == 0 || n == 0) {
            return new ArrayList<>(Collections.nCopies(1, ""));
        }

        if(first[m-1] == second[n-1]) {
            List<String> lcs = getAllLCS(first, m-1, second, n-1,matrix);
            for(int i = 0; i<lcs.size(); i++) {
                lcs.set(i, lcs.get(i)+ first[m-1]);
            }
            return lcs;
        }

        if(matrix[m-1][n] > matrix[m][n-1]) {
            return getAllLCS(first, m-1, second, n, matrix);
        }
        if(matrix[m-1][n] < matrix[m][n-1]) {
            return getAllLCS(first, m, second, n-1, matrix);
        }

        List<String> top = getAllLCS(first, m-1, second, n, matrix);
        List<String> left = getAllLCS(first, m, second, n-1, matrix);

        top.addAll(left);
        return top;

    }


    public static void main(String[] args) {
        String first =  "ABCBDAB";
        String second = "BDCABA";
        System.out.println(new T1_LongestCommonSubSequence().getLCSLength(first,second));
        System.out.println(new HashSet<>(new T1_LongestCommonSubSequence().findAllLCS(first, second)));


    }
}
