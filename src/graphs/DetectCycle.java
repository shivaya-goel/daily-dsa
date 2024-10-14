package graphs;

import java.util.ArrayList;
import java.util.List;

public class DetectCycle {

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        boolean[] isVisited = new boolean[A+1];
        boolean[] recStack = new boolean[A+1];
        List<Integer>[] edges = new List[A+1];
        for (int i = 0; i <= A; i++) {
            edges[i] = new ArrayList<>();
        }
        for (ArrayList<Integer> a: B) {
            edges[a.get(0)].add(a.get(1));
        }
        for (int i = 1; i <= A; i++) {
            if (!isVisited[i]) {
                if (depthFirstSearch(edges, isVisited, recStack, i)) {
                    return 1;
                }
            }
        }
        return 0;
    }

    private boolean depthFirstSearch(List<Integer>[] edges, boolean[] isVisited, boolean[] recStack, int src) {
        isVisited[src] = true;
        recStack[src] = true;
        for (int i=0;i<edges[src].size();i++) {
            int v = edges[src].get(i);
            if (!isVisited[v]) {
                if (depthFirstSearch(edges, isVisited, recStack, v)) {
                    return true;
                }
            } else if (recStack[v]) {
                return true;
            }
        }
        return recStack[src] = false;
    }

    public static void main(String[] args) {
        DetectCycle p = new DetectCycle();
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        paths.add(new ArrayList<>(List.of(1,2)));
        paths.add(new ArrayList<>(List.of(2,3)));
        paths.add(new ArrayList<>(List.of(3,4)));
        paths.add(new ArrayList(List.of(4,5)));
//        paths.add(new ArrayList<>(List.of(5,2)));
//        paths.add(new ArrayList<>(List.of(1,3)));
        System.out.println(p.solve(5, paths));
    }
}