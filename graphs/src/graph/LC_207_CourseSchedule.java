package graph;

import java.util.LinkedList;
import java.util.Stack;

public class LC_207_CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[numCourses];
        stack.push(0);
        visited[0] =true;

        while(!stack.isEmpty()) {
            Integer pop = stack.pop();
            for(int i = 0; i< numCourses; i++) {
                if(prerequisites[pop][i] != 0) {
                    if(visited[i]) {
                        return false;
                    }
                    stack.push(i);
                }
            }
        }



        return true;
    }


}
