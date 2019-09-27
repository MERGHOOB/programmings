package techDelight;

import java.util.HashMap;
import java.util.Map;

public class FindLongestSequenceFormedAadjacentNumbersMatrix {

    public static final Map<String, String> lookUp = new HashMap<>();

    private static String findLongestPathWithHelpOfLookUp(int[][] matrix, int i, int j) {
        if (!isValid(matrix, i, j)) {
            return null;
        }

        String key = String.valueOf(i) + "|" + String.valueOf(j);
        if (lookUp.containsKey(key)) {
            return lookUp.get(key);
        }

        String path = null;
        if (i > 0 && matrix[i - 1][j] - matrix[i][j] == 1) {
            path = findLongestPathWithHelpOfLookUp(matrix, i - 1, j);
        }
        if (j > 0 && matrix[i][j - 1] - matrix[i][j] == 1) {
            path = findLongestPathWithHelpOfLookUp(matrix, i, j - 1);
        }
        if (i + 1 < matrix.length && matrix[i + 1][j] - matrix[i][j] == 1) {
            path = findLongestPathWithHelpOfLookUp(matrix, i + 1, j);
        }
        if (j + 1 < matrix[0].length && matrix[i][j+1] - matrix[i][j] == 1) {
            path = findLongestPathWithHelpOfLookUp(matrix, i, j + 1);
        }

        lookUp.put(key, path != null ? matrix[i][j] + " - " + path : String.valueOf(matrix[i][j]));
        return lookUp.get(key);
    }

    // main function
    public static void main(String[] args) {
        int M[][] =
                {
                        {10, 13, 14, 21, 23},
                        {11, 9, 22, 2, 3},
                        {12, 8, 1, 5, 4},
                        {15, 24, 7, 6, 20},
                        {16, 17, 18, 19, 25}
                };

        String res = "";        // stores longest path found so far
        String str;                // stores current path
        long resSize = Long.MIN_VALUE;    // stores no. of elements in res

        // from each cell (i, j), find the longest path starting from it
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                // str would be like 1 - 2 - 3 - 4 - 5 -
//                str = findLongestPath(M, i, j);
                str = findLongestPathWithHelpOfLookUp(M, i, j);

                // find number of elements involved in current path
                long size = str.chars().filter(ch -> ch == '-').count();

                // update result if longer path is found
                if (size > resSize) {
                    res = str;
                    resSize = size;
                }
            }
        }

        // print the path
        System.out.println(res);
    }

    private static String findLongestPath(int[][] m, int i, int j) {
        if (isValid(m, i, j)) {
            return "";
        }

        String path = null;
        if (i > 0 && m[i - 1][j] - m[i][j] == 1) {
            path = findLongestPath(m, i - 1, j);
        }
        if (j > 0 && m[i][j - 1] - m[i][j] == 1) {
            path = findLongestPath(m, i, j - 1);
        }
        if (i < m.length - 1 && m[i + 1][j] - m[i][j] == 1) {
            path = findLongestPath(m, i + 1, j);
        }
        if (j < m[0].length - 1 && m[i][j + 1] - m[i][j] == 1) {
            path = findLongestPath(m, i, j + 1);
        }

        return path != null ? m[i][j] + " - " + path : String.valueOf(m[i][j]);
    }

    private static boolean isValid(int[][] m, int i, int j) {
        return (i >= 0 && i < m.length && j >= 0 && j <= m[0].length);
    }

}



