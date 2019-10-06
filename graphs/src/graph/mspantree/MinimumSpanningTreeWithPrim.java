package graph.mspantree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class MinimumSpanningTreeWithPrim {
    public static void main(String[] args) throws Exception {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("graphs/input.txt")))) {
//        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String str = bufferedReader.readLine();
            String[] s = str.split(" ");
            int vs = Integer.parseInt(s[0].trim());
            int es = Integer.parseInt(s[1].trim());

            Graph graph = new Graph(vs, es);


            for (int i = 0; i < es; i++) {
                s = bufferedReader.readLine().split(" ");

                int from = Integer.parseInt(s[0].trim()) -1; // we consider it Vertex will start from Zero
                int to = Integer.parseInt(s[1].trim())-1;
                int weight = Integer.parseInt(s[2].trim());

                graph.addEdge(from,to, weight);

            }

            System.out.println(prim(graph, 0));


        }
    }

    public static int prim(Graph graph, int x) {
        int minCost = 0;


        int effectVertexSize = (int) (graph.V);
        boolean []mstSet = new boolean[effectVertexSize];
        long [] dist = new long[effectVertexSize];
        for(int i = 0; i<effectVertexSize; i++) {
            dist[i] = 9999;
        }
        PriorityQueue<CostAssociativeVertex> priorityQueue = new PriorityQueue<>(); // for getting minimum from firstNode
        priorityQueue.add(new CostAssociativeVertex(x, 0));
        dist[x] = 0;

        while (!priorityQueue.isEmpty()) {
            CostAssociativeVertex costAssociativeVertex = priorityQueue.remove();
            int vertex = costAssociativeVertex.vertex;
            if(mstSet[vertex]) {
                continue;
            }
            minCost += dist[vertex];
            mstSet[vertex] = true;

            List<WeightedEdge> weightedEdges = graph.adjacencyList.get(vertex);
            for(WeightedEdge weightedEdge: weightedEdges) {

                int targetVertex = (int) weightedEdge.to;
                if(mstSet[targetVertex]) {
                    continue;
                }
                int targetCost = (int) weightedEdge.weight;
                if(dist[targetVertex] > targetCost) {
                    dist[targetVertex]= targetCost;
                    priorityQueue.add(new CostAssociativeVertex(targetVertex, targetCost));
                }

            }

        }
        return minCost;
    }


    private static class CostAssociativeVertex implements Comparable<CostAssociativeVertex> {
        CostAssociativeVertex(int vertex) {
            this.vertex = vertex;
            this.cost = Integer.MAX_VALUE;
        }

        int vertex, cost;

        public CostAssociativeVertex(int x, int cost) {
            this.vertex = x; this.cost = cost;
        }

        @Override
        public int compareTo(CostAssociativeVertex o) {
            Integer weight = cost;
            Integer otherWeight = o.cost;

            return weight.compareTo(otherWeight);
        }
    }

    private static class Graph {

        long V, E;
        Map<Long, List<WeightedEdge>> adjacencyMap = new HashMap<>();
        List<List<WeightedEdge>> adjacencyList = new ArrayList<>();
        Graph(long V, long E) {
            this.V = V;
            this.E = E;

            for(long i = 0; i<=V; i++) {
                adjacencyMap.put(i, new ArrayList<>());
                adjacencyList.add(new ArrayList<>());
            }
        }

        void addEdge(long from, long to, long weight) {
            adjacencyMap.get(from).add(new WeightedEdge(to, weight));
            adjacencyMap.get(to).add(new WeightedEdge(from, weight));
            adjacencyList.get((int) to).add(new WeightedEdge(from, weight));
            adjacencyList.get((int) from).add(new WeightedEdge(to, weight));
        }



    }

    private static class WeightedEdge {
        long to;
        long weight;


        WeightedEdge(long to, long weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
