package graph.articulationpoint_bridges.ap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ArticulationPoint {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String [] split = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        int graph[][] = new int[n][n];

        for(int i =0; i<m;i++) {
            try {
                split = bufferedReader.readLine().split(" ");
                 int u = Integer.parseInt(split[0]);
                 int v = Integer.parseInt(split[1]);
                 graph[u][v] = graph[v][u] = 1;
            }catch (Exception e) {

            }
        }
        findArticulationPointWithBackEdge(graph, n);
        /*
        int graph[][] = {
                {0,1,0,0,0,1},
                {0,0,1,1,0,0},
                {0,1,0,1,1,0},
                {0,1,1,0,1,0},
                {0,0,1,1,0,0},
                {1,0,0,0,0,0},
        };

//        System.out.println(findArticulationPointBruteForce(graph, 6));
        System.out.println(findArticulationPointWithBackEdge(graph, 6));
*/
    }
    static class Bridge implements Comparable<Bridge>{
        int first, second;
        Bridge(int u, int v){
                if(u < v) {
                    this.first = u;
                    this.second = v;
                }
                else {
                    this.first = v;
                    this.second = u;
                }
        }

        @Override
        public int compareTo(Bridge o) {
            return this.first != o.first ? this.first - o.first : this.second - o.second;
        }
    }
    private static int findArticulationPointWithBackEdge(int[][] graph, int n) {
        boolean visited[] = new boolean[n];
        int[] discoveryTime = new int[n]; // by default 0 in each cell
        int[] minDiscoveryTime = new int[n]; // by default 0 in each cell
        Arrays.fill(minDiscoveryTime, Integer.MAX_VALUE);
        int[] parent  = new int[n] ;
        Arrays.fill(parent, -1);
        boolean aps[] = new boolean[n]; // initally all false by default

        // Need Bridges
        TreeSet<Bridge> bridges = new TreeSet<>();
        for(int i =0; i<n; i++) {
            dfsForBackEdge(graph, visited,discoveryTime, minDiscoveryTime, parent, aps, i, n, bridges);
        }


        int count  = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i =0; i<n; i++) {
            if(aps[i]) {
                count++;
                stringBuilder.append(i).append(" ");
            }
        }
        System.out.println(count);
        System.out.println(stringBuilder);

        System.out.println(bridges.size());
        for(Bridge bridge: bridges) {
            System.out.println(bridge.first + " " + bridge.second);
        }



        return count;
    }
    private static int TIME = 0;
    private static void dfsForBackEdge(int[][] graph, boolean[] visited, int[] discoveryTime, int[] minDiscoveryTime, int[] parent, boolean[] aps, int vertex, int n, TreeSet<Bridge> bridges) {
        visited[vertex] = true;
        discoveryTime[vertex]  =  minDiscoveryTime[vertex] = ++TIME;

        int child = 0; // check the child of vertex:
        for(int i = 0; i<n;i++) {
                if(graph[vertex][i] == 0) // there is no edge we can to dfs there.
                {
                    continue;
                }

                if(!visited[i]) {

                        child = child +1;
                        parent[i] = vertex;
                        dfsForBackEdge(graph, visited, discoveryTime, minDiscoveryTime, parent, aps, i, n, bridges);
                        minDiscoveryTime[vertex] = Integer.min(minDiscoveryTime[i], minDiscoveryTime[vertex]);

                        if(minDiscoveryTime[i] > discoveryTime[vertex]) {
//                            System.out.println(i + "----------------" + vertex);
                            bridges.add(new Bridge(i, vertex));
                        }

                        if(parent[vertex] == -1 && child > 1) {
                            // if it is a root // more than one child it means it will seprate both of the child.
                            aps[vertex] = true;
                        }
                        if(parent[vertex] != -1 && minDiscoveryTime[i] >= discoveryTime[vertex]) {
                            // if vertex is not root and min discoverty time of any child is grater than vertex,it is ap.
                            aps[vertex] = true;
                        }
                }
                else if(parent[vertex] != i) {// discoveryTime of child is less than minDisvoerytime of vertex then update it.
                    minDiscoveryTime[vertex] = Integer.min(discoveryTime[i], minDiscoveryTime[vertex]);
                }
        }


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
