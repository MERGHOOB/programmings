package graph.shortestPath;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FloydWarshall {
    public static final Long INFINTIY = 10000000000L;
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("graphs/input.txt")))) {
            String split[] = bufferedReader.readLine().split(" ");

            int vs = Integer.parseInt(split[0]);
            int es = Integer.parseInt(split[1]);

            long[][] dist = new long[vs][vs];
            for (int i = 0; i < vs; i++) {
                Arrays.fill(dist[i], INFINTIY);
            }
            for(int i = 0; i<vs; i++) {
                dist[i][i] = 0;
            }
            for (int i = 0; i < es; i++) {
                split = bufferedReader.readLine().split(" ");
                int src = Integer.parseInt(split[0]) - 1;
                int dest = Integer.parseInt(split[1]) - 1;
                int weight = Integer.parseInt(split[2]);

                dist[src][dest] = weight;
            }
//            printDist(vs, dist);
            System.out.println("-------------------------------------");

            for (int k = 0; k <vs; k++) { // intermediate k vertices
                for (int i = 0; i < vs; i++) {
                    for (int j = 0; j < vs; j++) {
                        if(dist[i][j] > dist[i][k] + dist[k][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }

            }

            printDist(vs, dist);

        }

    }

    private static void printDist(int vs, long[][] dist) {
//        for (int i = 0; i < vs; i++) {
            for (int j = 1; j < vs; j++) {
                System.out.print(dist[0][j] + " ");
            }

//        }
    }
}

