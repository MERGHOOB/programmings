package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
/*
https://www.hackerearth.com/practice/algorithms/graphs/minimum-spanning-tree/tutorial/
 */
public class MinimumSpanningTree {

    public static final int MAX = 10005;
    private static int [] disJoint = new int[MAX];
    public static void main(String[] args) throws Exception {
//        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("graphs/input.txt")))) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String str = bufferedReader.readLine();
            String[] s = str.split(" ");
            int vs = Integer.parseInt(s[0].trim());
            int es = Integer.parseInt(s[1].trim());

            Edge [] edges = new Edge[es];
            for(int i = 0; i<es;i++) {
                s = bufferedReader.readLine().split(" ");
                edges[i] = new Edge(Integer.parseInt(s[0].trim()),
                                    Integer.parseInt(s[1].trim()),
                                    Integer.parseInt(s[2].trim()));

                if(edges[i].toString().length() <= 0) {
                    System.out.println(edges[i]);
                }
            }


            System.out.println(kruskal(edges));


        }
    }

    private static int kruskal(Edge[] edges) {

        sortEdges(edges);

        intializeDisjointSet();
        int minimumCost = 0;

        for(Edge edge: edges) {

            int x = edge.start;
            int y = edge.end;

            if(findRoot(x) != findRoot(y)) {
                minimumCost += edge.weight;
                union(x, y);
            }


        }
        return minimumCost;
    }

    private static void sortEdges(Edge[] edges) {
        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                Integer first = o1.weight;
                Integer second = o2.weight;
                return first.compareTo(second);
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });
    }

    private static void intializeDisjointSet() {
        for(int i = 0; i<MAX; i++) {
            disJoint[i] = i;
        }
    }

    private static boolean union(int x, int y) {
        int p = findRoot(x);
        int q = findRoot(y);

        disJoint[p] = disJoint[q];
        return true;
    }

    private static int findRoot(int x) {
        while(disJoint[x] != x) {
            disJoint[x] = disJoint[disJoint[x]]; // path compression
            x = disJoint[x];
        }
        return x;
    }



}
