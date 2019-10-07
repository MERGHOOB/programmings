package graph.shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/*
You are given 2 integers (N,M) , N is the number of vertices, M is the number of edges.
You'll also be given  Ai,Bi ,Wi  where Ai and Bi  represents an edge from a vertex  to a vertex
 and  Wi represents the weight of that edge.

Task is to find the shortest path from source vertex (vertex number 1) to all other vertices Vi (2 <= i<=n) .

Input:
First line contains two space separated integers N and M,  Then M lines follow, each line has 3 space separated integers  Ai,Bi , Wi.

constraints:
1 <= N <=1e4;
1 <= M <= 1e6;
1 <= Vi <= N
1 <=Wi <= 1000


Output:
Print the shortest distances from the source vertex (vertex number 1) to all other vertices Vi. Print "1e9" in case the vertex "Vi" can't be reached form the source vertex.
Leave a space between any 2 printed numbers.
 */
public class ShortestPathProblemHackerEarth {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] split = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        ArrayList<Pair>[] edges = new ArrayList[n + 10];
        for (int i = 0; i < n + 10; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            try {
                split = bufferedReader.readLine().split(" ");
                int u = Integer.parseInt(split[0]) - 1;
                int v = Integer.parseInt(split[1]) - 1;
                int w = Integer.parseInt(split[2]);
                edges[u].add(new Pair(v, w));
            } catch (Exception e) {

            }
        }

        dijkstra(edges, n, m);


    }

    private static void dijkstra(ArrayList<Pair>[] edges, int n, int m) {

        int dist[] = new int[n];
        Arrays.fill(dist, INF);

        dist[0] = 0;
        PriorityQueue<Pair> heap = new PriorityQueue<>();
        heap.add(new Pair(0, 0));

        while (!heap.isEmpty()) {
            Pair poll = heap.poll();
            int polledVertex = poll.v;
            int weight = poll.w;

            if (weight == INF) {
                break;
            }

            if (dist[polledVertex] < weight) {
                continue;
            }

            for (Pair pair : edges[polledVertex]) {
                int childVertex = pair.v;
                weight = pair.w;

                if (dist[childVertex] > dist[polledVertex] + weight) {
                    dist[childVertex] = dist[polledVertex] + weight;
                    heap.add(new Pair(childVertex, dist[childVertex]));
                }
            }


        }

        for (int i = 1; i < n; i++) {
            if (dist[i] == INF) {
                System.out.print(oneE9 + " ");
            } else {
                System.out.print(dist[i] + " ");
            }
        }

    }

    private static final int INF = Integer.MAX_VALUE;
    private static final int oneE9 = (int) (1e9);

    private static class Pair implements Comparable<Pair> {
        int v, w;

        public Pair(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.w < other.w) {
                return -1;
            } else if (this.w == other.w) {
                return 0;
            }
            return 1;
        }
    }
}
