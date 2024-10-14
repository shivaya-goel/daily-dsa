package graphs;

import java.util.ArrayList;

class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adjList = new ArrayList[numCourses];
        for (int i=0;i<numCourses;i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] list : prerequisites) {
            adjList[list[0]].add(list[1]);
        }
        boolean[] isVisited = new boolean[numCourses];
        boolean[] isCycle = new boolean[numCourses];

        int[] orderOfCourses = new int[numCourses];
        for (int i=0;i<numCourses;i++) {
            if (!isVisited[i]) {
                if (dfs(adjList, isVisited, isCycle, i, orderOfCourses)) {
                    return orderOfCourses;
                }
            }
        }
        return orderOfCourses;
    }

    private boolean dfs(ArrayList<Integer>[] adjList, boolean[] isVisited,
    boolean[] isCycle, int src, int[] orderOfCourses) {
        isVisited[src] = true;
        isCycle[src] = true;

        for (int i=0;i<adjList[src].size();i++) {
            int v = adjList[src].get(i);
            if (!isVisited[v]) {
                if (dfs(adjList, isVisited, isCycle, v, orderOfCourses)) {
                    return true;
                }
            } else if (isCycle[v]) {
                return true;
            }
            orderOfCourses[v] = src;
        }
        return isCycle[src] = false;
    }

    public static void main(String[] args) {
        CourseSchedule2 v = new CourseSchedule2();
        int numCourses = 4;
        int[] order = v.findOrder(numCourses, new int[][]{{1,0}, {2,0}, {3,1}, {3,2}});
        System.out.println(order);
    }
}