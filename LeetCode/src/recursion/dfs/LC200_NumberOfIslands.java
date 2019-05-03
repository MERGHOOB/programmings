
package recursion.dfs;
import java.util.Scanner;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 */
public class LC200_NumberOfIslands {


    public static final char CONNECTED = '1';
    public static final char visited = 'x';

    public int numIslands(char[][] grid) {

        if(grid == null) {
            return  0;
        }
        int count = 0;

        int m=grid.length;
        int n=grid[0].length;
        for(int i = 0; i<m; i++) {

            for(int j= 0; j< n; i++) {

                if(grid[i][j] == CONNECTED) {
                    count++;

                    mergeConnectedLand(grid, i, j);


                }

            }
        }

        return count;
    }

    private void mergeConnectedLand(char[][] grid, int i, int j) {

        int m=grid.length;
        int n=grid[0].length;

        if(i<0||i>=m||j<0||j>=n||grid[i][j]!='1')
            return;

        mergeConnectedLand(grid, i+1, j);
        mergeConnectedLand(grid, i, j+1);
        mergeConnectedLand(grid, i-1, j);
        mergeConnectedLand(grid, i,j-1);

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);




    }
}
