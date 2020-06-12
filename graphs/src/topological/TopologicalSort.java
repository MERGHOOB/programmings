package topological;

import java.util.*;

/*
Topological sorting of vertices of a Directed Acyclic Graph is an ordering of the vertices v1 to vn
in such a way, that if there is an edge directed towards vertex v, from vertex vi , then  comes before vj . For example consider the graph given below:

    1
   / \
  / 2
 / / \
 3 -- 4
 \
  5

  1-3-5-2-4 || 1-2-3-5-5

  many:

 */
public class TopologicalSort {


    static class DFSNode {
        boolean isParent;
        int vertex;

        DFSNode(boolean p, int v) {
            isParent = p;
            vertex = v;
        }
    }

    private int[] sortUsingDFS(List<List<Integer>> graph) {
        int[] sortArray = new int[graph.size()];
        boolean[] visited = new boolean[graph.size()];
        int indexToFill = 0;

        Stack<DFSNode> dfs = new Stack<>();
        Stack<Integer> postOrder = new Stack<>(); // as child will be the last to fill. // required for postorder

        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) {
                dfs.push(new DFSNode(false, i)); // initially consider it as a child
            }

            while (!dfs.isEmpty()) {
                DFSNode pop = dfs.pop();
                // following line is not required for topo sort but for post order which makes it similar to BFS
                if (pop.isParent) {
                    postOrder.push(pop.vertex);
                    continue;
                } // post order
                visited[pop.vertex] = true;
//                sortArray[indexToFill++] = pop.vertex;
                dfs.push(new DFSNode(true, pop.vertex)); // make it as parent. so that can be pushed post order
                for (int child : graph.get(pop.vertex)) {
                    if (!visited[child]) {
                        dfs.push(new DFSNode(false, child));
                    }
                }
            }
        }


        while (!postOrder.isEmpty()) {
            sortArray[indexToFill++] = postOrder.pop();
        }

        return sortArray;
    }

    private int[] sortUsingBFS(List<List<Integer>> graph) {
        int[] sortArray = new int[graph.size()];

        boolean[] visited = new boolean[graph.size()];

        //in-degree required for bfs only, means incoming direction lik eas 3 has 2 one from 1 and other from 2
        int[] inDegree = new int[graph.size()]; // initialized by 0 by default.

        for (int i = 0; i < graph.size(); i++) {
            for (int j = 0; j < graph.size(); j++) {
                if (graph.get(i).contains(j)) { // there is directed link i to j
                    inDegree[j] += 1;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>(); // For lexicographically smaller sort, use PriorityQueue
        /*
        en-Queue all independent vertex where no incoming path.
         */
        for (int i = 0; i < graph.size(); i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                visited[i] = true;
            }
        }


        int indexToFill = 0;
        while (!queue.isEmpty()) {
            int remove = queue.remove();
            sortArray[indexToFill++] = remove;
            for (int j = 0; j < graph.size(); j++) {
                if (graph.get(remove).contains(j) && !visited[j]) {
                    inDegree[j] -= 1;
                    if (inDegree[j] == 0) {
                        queue.add(j);
                        visited[j] = true;
                    }
                }
            }

        }


        return sortArray;
    }

    public static void main(String[] args) {


        List<List<Integer>> graph = new TopologicalSort().createGraph();
        int[] sort = new TopologicalSort().sortUsingBFS(graph);
        for (int v : sort) {
            System.out.print(v + " ");
        }
        System.out.println();
        sort = new TopologicalSort().sortUsingDFS(graph);
        for (int v : sort) {
            System.out.print(v + " ");
        }
        System.out.println();
    }


    public List<List<Integer>> createGraph() {
        List<List<Integer>> graph = new ArrayList<>();
//        6  // nodes
        for (int i = 0; i <= 5; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(0).add(3);

        graph.get(1).add(2);
        graph.get(1).add(3);

        graph.get(2).add(3);
        graph.get(2).add(4);
        graph.get(2).add(5);

        graph.get(3).add(4);
        graph.get(3).add(5);

        graph.get(4).add(5);


        return graph;

    }
}
