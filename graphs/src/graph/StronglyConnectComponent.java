package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class StronglyConnectComponent {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        int graph[][] = new int[n][n];
        int reverseGraph[][] = new int[n][n];

        for (int i = 0; i < m; i++) {
            try {
                split = bufferedReader.readLine().split(" ");
                int u = Integer.parseInt(split[0])-1;
                int v = Integer.parseInt(split[1])-1;
                graph[u][v] = reverseGraph[v][u] = 1;
            } catch (Exception e) {

            }
        }

        Stack<Integer> stackByFinishTime = new Stack<>();
        boolean [] visited = new boolean[n];
        for(int i = 0; i<n;i++) {
            if(!visited[i]) {
                dfs(graph, n, stackByFinishTime, i, visited);
            }
        }
        Arrays.fill(visited, false);
        int count = 0;
        int countEven = 0;
        int countOdd = 0;

        while (!stackByFinishTime.isEmpty()) {
            Integer pop = stackByFinishTime.pop();

            if(!visited[pop]) {
                Set<Integer> set = new HashSet<>();
                dfsSimple(reverseGraph, n, pop, visited, set);

                if(set.size() %2 == 0) {
                    countEven += set.size();
                }
                else {
                    countOdd += set.size();
                }
                count++;
            }
        }
        System.out.println(countOdd - countEven);
    }

    private static void dfsSimple(int[][] reverseGraph, int n, Integer pop, boolean[] visited, Set<Integer> set) {
        set.add(pop);
        visited[pop] = true;
        for(int i =0;i<n;i++) {
            if(reverseGraph[pop][i] !=0  && !visited[i]) {
                dfsSimple(reverseGraph, n, i, visited,set);
            }
        }
    }

    private static void dfs(int[][] graph, int n, Stack<Integer> stackByFinishTime, int vertex, boolean [] visited) {

        visited[vertex] = true;
        for(int i = 0; i<n; i++) {
            if(graph[vertex][i] != 0 && !visited[i]) {
                dfs(graph, n, stackByFinishTime, i, visited);
            }
        }
        // child finished add to stack now.
        stackByFinishTime.add(vertex);
    }
}
