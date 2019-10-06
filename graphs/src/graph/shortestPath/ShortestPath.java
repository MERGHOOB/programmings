package graph.shortestPath;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class ShortestPath {

    static class Graph {
        int V, E;
        Edge[] edges;

        List<Edge> [] edgesListArray;

        Graph(int V, int E) {
            this.V = V;
            this.E = E;
            edges = new Edge[E];
            for (int i = 0; i < E; i++) {
                edges[i] = new Edge();
            }
            edgesListArray = new ArrayList[V];
            for(int i =0; i<V; i++) {
                edgesListArray[i] = new ArrayList<>();
            }
        }


    }

    static class Edge {
        int src, dest, weight;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.weight = w;
        }

        Edge() {
            src = dest = weight = 0;
        }
    }

    public static void main(String[] args) throws Exception {
//        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("graphs/input.txt")))) {
            String split[] = bufferedReader.readLine().split(" ");

            int vs = Integer.parseInt(split[0]);
            int es = Integer.parseInt(split[1]);
            Graph graph = new Graph(vs, es);
            for (int i = 0; i < es; i++) {
                split = bufferedReader.readLine().split(" ");
                int src = Integer.parseInt(split[0]) - 1;
                graph.edges[i].src = src;
                int dest = Integer.parseInt(split[1]) - 1;
                graph.edges[i].dest = dest;
                int weight = Integer.parseInt(split[2]);
                graph.edges[i].weight = weight;
                graph.edgesListArray[src].add(graph.edges[i]);
            }

            shortestPathWithBellManFord(graph, vs, es, 0);
            System.out.println();
            shortestPathWithDijkstra(graph, vs, es, 0);
        }
    }

    private static void shortestPathWithDijkstra(Graph graph, int vs, int es, int src) {

        boolean [] visited = new boolean[vs];
        int [] dist = new int[vs];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<VertexCost> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new VertexCost(src, 0));
        dist[src] = 0;
        while(!priorityQueue.isEmpty()) {
            VertexCost vertexCost = priorityQueue.poll(); // O(V+ ElogV)
            if(visited[vertexCost.vertex]) {
                continue;
            }
            visited[vertexCost.vertex] = true;

            graph.edgesListArray[vertexCost.vertex].forEach( e -> {
                        if( dist[e.dest] > dist[e.src] + e.weight) {
                            dist[e.dest] = dist[e.src] + e.weight;
                            priorityQueue.add(new VertexCost(e.dest, dist[e.dest]));
                        }
                    }
            );

        }

        for(int i = 1; i<vs; i++) {
            System.out.print(dist[i] + " ");
        }
    }



    static class VertexCost implements Comparable<VertexCost> {
        int vertex, cost;

        VertexCost(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(VertexCost o) {
            return this.cost - o.cost;
        }
    }


    private static void shortestPathWithBellManFord(Graph graph, int vs, int es, int startingPoint) {

        long dist[] = new long[vs];
        for (int i = 0; i < vs; i++) {
            dist[i] = Long.MAX_VALUE;
        }
        dist[startingPoint] = 0;

        for (int i = 0; i < vs-1; i++) { // atmost n-1 edges required from src to any other vertex
            for (int j = 0; j < es; j++) { // traverse all edges
                Edge edge = graph.edges[j];
                if (dist[edge.src] != Long.MAX_VALUE && dist[edge.dest] > dist[edge.src] + edge.weight) {
                    dist[edge.dest] = dist[edge.src] + edge.weight;
                }
            }
        }

        for (int i = 1; i < vs; i++) {
            System.out.print(dist[i] + " ");
        }
    }
}