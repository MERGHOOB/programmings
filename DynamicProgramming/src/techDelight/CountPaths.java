package techDelight;

/*

count path of COST cost:

from src : 1,1, m, n

path(m,n, cost) = path(m, n-1, cost- mat[m][n]) + path(m-1, n, cost-mat[m][n])

                = path(m, n-1, cost- mat[m][n]) // if m ==0
                = path(m-1, n, cost-mat[m][n]) // if n ==0

                = 1 if (mat[m][n] == cost) it is base case:
                = 0  other wise



 */

import java.util.HashMap;
import java.util.Map;

public class CountPaths {


    public int countPath(int[][] matrix, int i, int j, int cost) {

        if (i == 0 && j == 0) {
            if (matrix[i][j] == cost) {
                return 1;
            }
            return 0;
        }

        if (i == 0) {
            return countPath(matrix, i, j - 1, cost - matrix[i][j]);
        }
        if (j == 0) {
            return countPath(matrix, i - 1, j, cost - matrix[i][j]);
        }
        return countPath(matrix, i, j - 1, cost - matrix[i][j]) + countPath(matrix, i - 1, j, cost - matrix[i][j]);


    }


    public static void main(String[] args) {
        int mat[][] =
                {
                        {4, 7, 1, 6},
                        {5, 7, 3, 9},
                        {3, 2, 1, 2},
                        {7, 1, 6, 3}
                };

        System.out.println(new CountPaths().countPath(mat, mat.length - 1, mat[0].length - 1, 25));
        System.out.println(new CountPaths().countPathWithLookUp(mat, mat.length - 1, mat[0].length - 1, 25));

    }

    Map<String, Integer> lookUp = new HashMap<>();

    private int countPathWithLookUp(int[][] matrix, int i, int j, int cost) {

        String key = i + "|" + j + "|" + cost;
        if (lookUp.containsKey(key)) {
            return lookUp.get(key);
        }
        if (i == 0 && j == 0) {
            if (matrix[i][j] == cost) {
                lookUp.put(key, 1);
            }
            lookUp.put(key, 0);
        }

        if (i == 0) {
            lookUp.put(key, countPath(matrix, i, j - 1, cost - matrix[i][j]));
        }
        if (j == 0) {
            lookUp.put(key, countPath(matrix, i - 1, j, cost - matrix[i][j]));
        }
        lookUp.put(key, countPath(matrix, i, j - 1, cost - matrix[i][j]) + countPath(matrix, i - 1, j, cost - matrix[i][j]));

        return lookUp.get(key);
    }
}
