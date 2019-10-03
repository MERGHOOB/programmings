package graph;

import java.util.*;

/*
https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

Given N and E, the number of nodes and edges in a directed graph. The task is to do Breadth First Search of this graph.

Input:
The first line of input contains the number of test cases T. For each test case, the first line of input contains N and E separated by space, and next line contains 2*E numbers (E pairs as X Y) are given in the next line which represents an edge from X to Y.

Output:
For each testcase, print the BFS of the graph starting from 0.

Note: The expected output button always produces BFS starting from node 0.

User Task:
Since, this is a functional problem, your task is to complete the function bfs() which do BFS of the given graph starting from node 0 and prints the nodes in BFS order.

Constraints:
1 <= T <= 100
1 <= N <= 100

Example:
Input:
2
5 4
0 1 0 2 0 3 2 4
3 2
0 1 0 2
Output:
0 1 2 3 4    // BFS from node 0
0 1 2
 */
public class GraphTraversal {

    static void bfs(int src, List<List<Integer>> list, boolean vis[]) { // ArrayList is usde

        if (vis[src]) {
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        vis[src] = true;
        while (!queue.isEmpty()) {
            int remove = queue.remove();
            System.out.print(remove + " ");
            List<Integer> integers = list.get(remove);
            for (int vertex : integers) {
                if (!vis[vertex]) {
                    queue.add(vertex);
                    vis[vertex] = true;
                }
            }
        }
        System.out.println();


        // add your code here
    }


    static void dfs(int src, List<List<Integer>> list, boolean vis[])
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(src);
        vis[src] = true;

        while(!stack.isEmpty()) {
            int pop = stack.pop();
            System.out.print(pop + " ");
            List<Integer> integers = list.get(pop);
            for(int neighbour: integers) {
                if(vis[neighbour]) {
                    continue;
                }
                stack.push(neighbour);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = createGraph();

        bfs(1, graph, new boolean[5]);
        dfs(1, graph, new boolean[5]);

    }

    private static List<List<Integer>> createGraph() {
        List<List<Integer>> graph = new ArrayList<>();
//        4  // nodes
        for (int i = 1; i <= 5; i++) {
            graph.add(new ArrayList<>());
        }
//        5  //edges
//        1 2  //showing edge from node 1 to node 2
        graph.get(1).add(2);
//        2 4  //showing edge from node 2 to node 4
        graph.get(2).add(4);
//        3 1  //showing edge from node 3 to node 1
        graph.get(3).add(1);
//        3 4  //showing edge from node 3 to node 4
        graph.get(3).add(4);
//        4 2  //showing edge from node 4 to node 2
        graph.get(4).add(2);

        return graph;

    }


}
