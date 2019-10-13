package maxFlow;

import java.util.*;

public class FordFulkerson {

    public static void main(String args[]) {
        FordFulkerson ff = new FordFulkerson();
        int[][] capacity =
                {{0, 3, 0, 3, 0, 0, 0},
                        {0, 0, 4, 0, 0, 0, 0},
                        {3, 0, 0, 1, 2, 0, 0},
                        {0, 0, 0, 0, 2, 6, 0},
                        {0, 1, 0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 0, 0, 9},
                        {0, 0, 0, 0, 0, 0, 0}};

        System.out.println("\nMaximum capacity " + ff.maxFlow(capacity, 0, 6));
    }

    private int maxFlow(int[][] capacity, int source, int sink) {

        int[][] residualCapacity = new int[capacity.length][capacity.length];
        for(int i = 0; i<capacity.length;i++) {
            for(int j=0; j<capacity.length;j++) {
                residualCapacity[i][j] = capacity[i][j];
            }
        }
        List<List<Integer>> augmentedPaths = new ArrayList<>();
        Map<Integer, Integer> parent = new HashMap<>();
        int maxFlow = 0;

        while (bfs(residualCapacity, source, sink,  parent)) {

            List<Integer> augmentedPath = new ArrayList<>();
//            augmentedPath.add(sink);
            int v = sink;
            int flow = Integer.MAX_VALUE;
            while(v != source) {
                augmentedPath.add(v);
                int u = parent.get(v);
                if(flow > residualCapacity[u][v]) {
                    flow = residualCapacity[u][v];
                }
                v = u;
            }

            augmentedPath.add(v);
            Collections.reverse(augmentedPath);
            augmentedPaths.add(augmentedPath);

            maxFlow += flow;

            // decrease residualCapacity
            v = sink;
            while (v!=source){
                int u  = parent.get(v);
                residualCapacity[u][v] -=flow;
                residualCapacity[v][u] +=flow;
                v= u;
            }
        }

        printAugmentedPaths(augmentedPaths);
        return maxFlow;
    }

    private boolean bfs(int[][] residualCapacity, int source, int sink, Map<Integer, Integer> parent) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(source);
        visited.add(source);

        boolean foundAugmentedPath = false;
        while (!queue.isEmpty()) {
            Integer remove = queue.remove();
            for(int v = 0; v<residualCapacity.length; v++){
                if(!visited.contains(v) && residualCapacity[remove][v] > 0) {
                    parent.put(v, remove); // fill the parent array
                    visited.add(v); //bfs
                    queue.add(v); // bfs
                    if(v == sink) {
                        foundAugmentedPath = true;
                        break;
                    }
                }

            }

        }
        return foundAugmentedPath;
    }

    private void printAugmentedPaths(List<List<Integer>> augmentedPaths) {
        augmentedPaths.forEach(System.out::println);
    }

}
