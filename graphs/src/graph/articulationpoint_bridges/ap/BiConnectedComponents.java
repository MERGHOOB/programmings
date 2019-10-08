package graph.articulationpoint_bridges.ap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class BiConnectedComponents {
    private static int TIME = 0;
    private static int countOdd= 0;
    private static int countEven= 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        int graph[][] = new int[n][n];

        for (int i = 0; i < m; i++) {
            try {
                split = bufferedReader.readLine().split(" ");
                int u = Integer.parseInt(split[0]);
                int v = Integer.parseInt(split[1]);
                graph[u][v] = graph[v][u] = 1;
            } catch (Exception e) {

            }
        }

        findBiConnectedComponents(graph, n);
//        findArticulationPointWithBackEdge(graph, n);
    }

    private static void findBiConnectedComponents(int[][] graph, int n) {

        boolean [] visited = new boolean[n];
        int [] parent = new int[n];
        Arrays.fill(parent, -1);

        int disc [] = new int[n];
        int low[] = new int[n];
        Arrays.fill(low, Integer.MAX_VALUE);

        Stack<Edge> stack= new Stack<>();
        for(int i = 0; i<n; i++) {
            if(!visited[i]) {
                dfsWithBackEdge(graph, visited, parent, disc, low, i, stack);
                Set<Integer> set = new HashSet<>();
                while (!stack.isEmpty()) {
                    Edge pop = stack.pop();
                    set.add(pop.first);
                    set.add(pop.second);
                }
                if(!set.isEmpty()) {
                    if (set.size() % 2 == 0)
                        countEven++;
                    else
                        countOdd++;
                }
            }
        }

        System.out.println(countOdd + " " + countEven);
    }

    private static void dfsWithBackEdge(int[][] graph,
                                        boolean[] visited,
                                        int[] parent,
                                        int[] disc,
                                        int[] low,
                                        int vertex,
                                        Stack<Edge> stack)
    {

        visited[vertex] = true;
        disc[vertex] = low[vertex] = ++TIME;
        int child = 0;

        for(int i =0; i<parent.length;i++) {
            if(graph[vertex][i] == 0) {
                continue;
            }
            if(!visited[i]) {
                child +=1;
                stack.push(new Edge(vertex, i));
                parent[i] = vertex;
                dfsWithBackEdge(graph, visited, parent, disc, low, i, stack);
//                if(parent[vertex] == -1 && child > 1) {
//
//                }
                if((parent[vertex] == -1 && child > 1) ||
                        (parent[vertex] != -1 && low[i] >= disc[vertex])) {
                    Set<Integer> set = new HashSet<>();
                    while(!stack.peek().isEquals(new Edge(vertex, i))) {
                        Edge pop = stack.pop();
                        set.add(pop.first);
                        set.add(pop.second);

                    }
                    Edge pop = stack.pop();
                    set.add(pop.first);
                    set.add(pop.second);
                    if(set.size() % 2 == 0) {
                        countEven++;
                    }
                    else
                        countOdd++;
                }
            }
            else if(parent[vertex] != i && disc[i] < low[vertex]) {
                low[vertex] = disc[i];
                stack.push(new Edge(vertex, i));
            }

        }


    }

    static  class Edge {
        int first, second;
        Edge(int u, int v) {
            if(u>v) {
                this.first = v;
                this.second = u;
            }
            else{
                this.first = u;
                this.second = v;
            }
        }

        public boolean isEquals(Edge edge) {
            return this.first == edge.first &&
                        this.second == edge.second;
        }
    }
}
