package graph;
/*
Flood fill algorithm helps in visiting each and every point in a given area.
It determines the area connected to a given cell in a multi-dimensional array.
 Following are some famous implementations of flood fill algorithm:

Bucket Fill in Paint:
Clicking in an area with this tool selected fills that area with the selected color.

Solving a Maze:
Given a matrix with some starting point, and some destination with some obstacles in between,
this algorithm helps to find out the path from source to destination

Minesweeper:
When a blank cell is discovered, this algorithm helps in revealing neighboring cells.
This step is done recursively till cells having numbers are discovered.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
F
 */
public class FloodFillAlgorithms {

    public static void main(String [] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String split[] =bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        int [][] graph = new int[n+2][m+2];

        for(int i = 1; i<=n; i++) {
            try {
                String s = bufferedReader.readLine();
                split = s.split(" ");
                for(int j = 1; j<=m;j++) {
                    graph[i][j] = Integer.parseInt(split[j-1].trim());
                }

            }catch (Exception e) {
//                System.out.println(e.getMessage());

            }
//            System.out.println();
        }

//        for(int i =1; i<=n; i++) {
//            for(int j =1; j<=m; j++) {
//
//                System.out.print(graph[i][j] + " ");
//            }
//            System.out.println();
//        }

        for(int i =1; i<=n; i++) {
            for(int j =1; j<=n; j++) {

                if(graph[i][j] == 0) {
                    continue;
                }
                graph[i][j] += Integer.max(graph[i-1][j] , graph[i][j-1]);
            }
        }



        if(graph[n][n] == (n+n-1)) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }




}
