package graph.shortestPath;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class FloydWarshall {

    private static final int INF = 10000000;
    public static void main1(String[] args) {

        int[][] graph = { {0,   5,  INF, 10},
                {INF, 0,   3, INF},
                {INF, INF, 0,   1},
                {INF, INF, INF, 0}
        };


        floydWarshall(graph);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testcases = Integer.parseInt(bufferedReader.readLine());
        while(testcases-- != 0) {
                int v = Integer.parseInt(bufferedReader.readLine());
                int [][] graph = new int[v][v];
                for(int i =0; i<v; i++) {
                    String[] spl = bufferedReader.readLine().split(" ");
                    for(int j=0; j<v; j++) {
                        graph[i][j] = Integer.parseInt(spl[j]);
                    }
                }
                floydWarshall(graph);
        }
/*
        int[][] graph = { {0,   5,  INF, 10},
                {INF, 0,   3, INF},
                {INF, INF, 0,   1},
                {INF, INF, INF, 0}
        };


        floydWarshall(graph);

 */
    }

    private static void floydWarshall(int[][] graph) {


        int [][] dist = new int[graph.length][graph[0].length];
        for(int i =0; i<graph.length; i++) {
            for(int j =0; j<graph.length; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        for(int k = 0; k<graph.length; k++) {
            for(int i = 0; i<graph.length; i++) {
                for(int j = 0; j<graph.length; j++) {

                    if(dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        for(int i =0; i<graph.length; i++) {
            for(int j =0; j<graph.length; j++) {
                if(dist[i][j] == INF) {
                    System.out.print("INF ");continue;
                }
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }

    }


}