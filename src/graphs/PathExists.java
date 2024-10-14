package graphs;

import java.util.ArrayList;
import java.util.List;

public class PathExists {

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        boolean[] isVisited = new boolean[A+1];
        List<Integer>[] edges = new List[A+1];
        for (int i = 0; i <= A; i++) {
            edges[i] = new ArrayList<>();
        }
        for (ArrayList<Integer> a: B) {
            edges[a.get(0)].add(a.get(1));
        }
        depthFirstSearch(edges, isVisited, 1);
        return isVisited[A] ? 1 : 0;
    }

    private void depthFirstSearch(List<Integer>[] edges, boolean[] isVisited, int src) {
        isVisited[src] = true;
        for (int i=0;i<edges[src].size();i++) {
            int v = edges[src].get(i);
            if (!isVisited[v]) {
                depthFirstSearch(edges, isVisited, v);
            }
        }
    }

    public static void main(String[] args) {
        PathExists p = new PathExists();
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