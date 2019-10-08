package graph.articulationpoint_bridges.ap;

import java.util.Stack;

public class ArticulationPoint {

    public static void main(String[] args) {

        int graph[][] = {
                {0,1,0,0,0,1},
                {0,0,1,1,0,0},
                {0,1,0,1,1,0},
                {0,1,1,0,1,0},
                {0,0,1,1,0,0},
                {1,0,0,0,0,0},
        };

        System.out.println(findArticulationPointBruteForce(graph, 6));

    }

    private static int findArticulationPointBruteForce(int[][] graph, int n) {
        int count = 0;
        boolean visited[] = new boolean[n];

        int initialConnectComponentCount  =0;

        // step 1: find number of connected component;
        for(int i = 0; i<n; i++) {
            if(!visited[i]) {
                dfs(graph, n, visited, i);
                initialConnectComponentCount++;
            }
        }
        // step2: remove vertices one by one before next push back old state
        int copy[] = new int[n]; // to record the state for ith vertices and used to go back to old state
        for(int i = 0; i<n; i++) {
            //remove ith vertices and its edges.
            for(int j = 0; j<n; j++) {
                visited[j] = false; // re-initialize to complete next step
                copy[j] = graph[i][j];
                graph[i][j]=graph[j][i] = 0; // remove edge
            }
            // Step3: as ith vertices and related edges removed count number of connect component
            int newValue = 0; visited[i] = true; // Mark removed vertices as true to avoid to run dfs on it
            for(int j = 0; j<n; j++) {
                if(!visited[j]) {
                    dfs(graph, n, visited, j);
                    newValue +=1;
                }
            }

            if(newValue > initialConnectComponentCount) {
                count +=1;
            }
            // Step 4: return graph to old state:
            for(int j = 0; j<n; j++) {
                graph[i][j] = graph[j][i] = copy[j];
            }
        }
        return count;

    }

    private static void dfs(int[][] graph, int n, boolean[] visited, int src) {


        Stack<Integer> stack = new Stack<>();
        stack.push(src);
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            if(!visited[pop]) {
                visited[pop] = true;

                for(int j = 0; j<n;j++) {
                    if(graph[pop][j] != 0) {
                        stack.push(j);
                    }
                }
            }
        }

    }


}
