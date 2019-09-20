/**
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 *
 * The distance between two adjacent cells is 1.
 *
 * [[0,0,0],
 *  [0,1,0],
 *  [0,0,0]]
 *
 * Output:
 * [[0,0,0],
 *  [0,1,0],
 *  [0,0,0]]
 *
 *  Example 2:
 *
 * Input:
 * [[0,0,0],
 *  [0,1,0],
 *  [1,1,1]]
 *
 * Output:
 * [[0,0,0],
 *  [0,1,0],
 *  [1,2,1]]
 *
 *  Note:
 *
 * The number of elements of the given matrix will not exceed 10,000.
 * There are at least one 0 in the given matrix.
 * The cells are adjacent in only four directions: up, down, left and right.
 *
 */




public class LC542_01Matrix {

    public int[][] updateMatrix(int[][] matrix) {


        if(matrix == null || matrix.length == 1 || matrix[0].length == 1) {
            return matrix;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;



        return null;
    }

    public static void main(String[] args) {

        int [][] matrix = new int[][] {{0,0,0},
                {0,1,0},
                {1,1,1}};


        int[][] output = new LC542_01Matrix().updateMatrix(matrix);


    }


}
