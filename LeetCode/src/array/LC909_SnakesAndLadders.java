package array;

import java.util.LinkedList;
import java.util.Queue;

public class LC909_SnakesAndLadders {


    public int snakesAndLadders(int[][] board) {

        int n = board.length;

        int lastDestination = n * n;
        int[] oned = new int[lastDestination + 1];

        boolean leftToRight = true; // last
        int k = 1;
        for (int i = n - 1; i >= 0; i--) { // row

            if (leftToRight) {
                for (int j = 0; j < n; j++) {
                    oned[k++] = board[i][j];

                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    oned[k++] = board[i][j];
                }
            }
            leftToRight = !leftToRight;
        }


        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        boolean[] visited = new boolean[lastDestination + 1];
        visited[1] = true;

        int result = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            result++;

            for (int i = 0; i < size; i++) {
                int curr = queue.remove();
                for (int neighbour = curr+ 1; neighbour <= curr+6; neighbour++) {

                    if (oned[neighbour] != -1) {
                        neighbour = oned[neighbour];
                    }
                    if (visited[neighbour]) {
                        continue;
                    }
                    if (neighbour == lastDestination) {
                        return result;
                    }
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }

        return -1;

    }
}
