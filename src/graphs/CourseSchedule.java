package graphs;

import java.util.ArrayList;

class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adjList = new ArrayList[numCourses];
        for (int i=0;i<numCourses;i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] list : prerequisites) {
            adjList[list[0]].add(list[1]);
        }
        boolean[] isVisited = new boolean[numCourses];
        boolean[] isCycle = new boolean[numCourses];
        
        for (int i=0;i<numCourses;i++) {
            if (!isVisited[i]) {
                if (dfs(adjList, isVisited, isCycle, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(ArrayList<Integer>[] adjList, boolean[] isVisited,
    boolean[] isCycle, int src) {
        isVisited[src] = true;
        isCycle[src] = true;

        for (int i=0;i<adjList[src].size();i++) {
            int v = adjList[src].get(i);
            if (!isVisited[v]) {
                if (dfs(adjList, isVisited, isCycle, v)) {
                    return true;
                }
            } else if (isCycle[v]) {
                return true;
            }
        }
        return isCycle[src] = false;
    }

    public static void main(String[] args) {
        CourseSchedule v = new CourseSchedule();
        System.out.println(v.canFinish(2, new int[][]{{1,0}}));
    }
}