package graph.hamiltonian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class HamiltonianPath {

    public static void main(String[] args) throws IOException {


        //https://www.youtube.com/watch?v=dQr4wZCiJJ4
        /*
        int graph1[][] = {
                {0, 1, 0, 0, 0, 1},
                {0, 0, 1, 1, 0, 0},
                {0, 1, 0, 1, 1, 0},
                {0, 1, 1, 0, 1, 0},
                {0, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 0},
        };

        int graph[][] = {
                {0, 1, 0, 0},
                {0, 0, 1, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
*/

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        boolean graph[][] = new boolean[n][n];
//        int reverseGraph[][] = new int[n][n];

        for (int i = 0; i < m; i++) {
            try {
                split = bufferedReader.readLine().split(" ");
                int u = Integer.parseInt(split[0]);
                int v = Integer.parseInt(split[1]);
                graph[u][v] =true;
//                graph[v][u] = true;
//                reverseGraph[v][u] = 1;
            } catch (Exception e) {

            }
        }
//        findHamiltonianPath(graph);
//        System.out.println(findHamiltonianPathWithDPBellMan(graph)? "YES" : "NO");
        System.out.println(findHamiltonianPathWithDFS(graph)? "YES" : "NO");

    }

    private static boolean findHamiltonianPathWithDFS(boolean[][] graph) {
        int vertices = graph.length;

        boolean [] visited = new boolean[vertices];
        for(int i = 0; i<vertices;i++) {
            visited[i] = true;
            if (dfs(graph, visited, i, 1)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }

    private static boolean dfs(boolean[][] graph, boolean[] visited, int source, int count) {
        if(count == graph.length) {
            return true;
        }
        for(int v = 0; v<graph.length; v++) {
            if(graph[source][v]) {
                visited[v] = true;
                if(dfs(graph,visited, v, count+1)) {
                    return true;
                }
                visited[v] = false;
            }
        }
        return false;
    }

    private static boolean findHamiltonianPathWithDPBellMan(boolean[][] graph) {

        int vertices = graph.length;
        int masks = 1 << vertices;
        boolean [][] dp = new boolean[vertices][masks];

        for(int i =0; i<vertices;i++) {
            dp[i][1<<i] = true;
        }

        for(int mask =0; mask<masks;mask++) { // traverse all sets

            for(int i = 0; i<vertices; i++) {
                //check if jth bit is set in maski it means j is present in i;
                if( (mask & (1<<i)) !=0) {
                    // find the neighbour k for j such that  that k to i-{j} is a path
                    for(int k= 0; k<vertices; k++) {

                        if( (mask &(1<<k)) !=0
                            && graph[k][i] && i!=k && dp[k][mask ^ (1<<i)]) {
                            dp[i][mask]= true;
                            break;

                        }

                    }


                }
            }


        }

        int n = vertices;
        for(int i=0; i<n; i++)
            if(dp[i][masks-1])
                return true;
        return false;
    }




    private static void findHamiltonianPath(int[][] graph) {
        int [] permutation = new int[graph.length];
        for(int i =0; i<graph.length;i++) {
            permutation[i] = i;
        }
        boolean YES = false;
        do{
            boolean isPath = true;
            if(toString(permutation).equalsIgnoreCase("345670128")){
                System.out.println("YES");
            }
            for (int i = 1; i < permutation.length; i++) {
                if (graph[permutation[i-1]][permutation[i]] == 0) {
                    isPath = false;
                }

            }
            if(isPath) {
                System.out.println("YES");
                YES = true;
                break;
//                for (int val : permutation) {
//                    System.out.print(val + " ");
//                }
//                System.out.println();
            }
//            try {
//                nextPermutation(permutation);
//            } catch (Exception e) {
//                break;
//            }
        }while (nextPermutation(permutation));

        if(!YES) {
            System.out.println("NO");
        }
    }

    private static String toString(int[] permutation) {
        String s =  "";
        for(int val: permutation) {
            s+=val;
        }
        return s;
    }

    private static boolean nextPermutation(int [] vertices) {
        if(vertices.length == 1) {
            return false;
        }
        // find lowValue Index;
        int lowValueIndex = vertices.length-1;
        while (lowValueIndex >=0) {
            if(lowValueIndex == 0) {
                return false;
            }
            if(vertices[lowValueIndex] > vertices[lowValueIndex-1]) {
                lowValueIndex -=1;
                break;
            }
            lowValueIndex--;
        }

        // find index whose value is just bigger than lowValueIndex
        int justMaxIndex = lowValueIndex+1;
        while (justMaxIndex <vertices.length && vertices[justMaxIndex] > vertices[lowValueIndex]) {
            justMaxIndex++;
        }
        justMaxIndex -=1;

        swap(vertices, lowValueIndex, justMaxIndex);
        reverse(vertices,lowValueIndex+1, vertices.length-1 );
        return true;
    }

    private static void reverse(int[] vertices, int start, int end) {
        while (start < end) {
            swap(vertices, start++, end--);
        }
    }

    private static void swap(int[] vertices, int lowValueIndex, int justMaxIndex) {
        int temp = vertices[lowValueIndex];
        vertices[lowValueIndex] = vertices[justMaxIndex];
        vertices[justMaxIndex] = temp;
    }


}
