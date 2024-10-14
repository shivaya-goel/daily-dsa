package DynamicProgramming;

import java.util.Arrays;

public class PaintHouse {

    public static void main(String[] args) {
        PaintHouse paintHouse = new PaintHouse();
//        int minCost = paintHouse.paint(new int[][]{{14, 2, 11}, {11, 14, 5}, {14, 3, 10}}, 3);
        int minCost = paintHouse.paint(new int[][]{{1, 2, 3}, {1, 4, 6}}, 2);
        System.out.println(minCost);
    }

    int paint(int[][] costs, int n) {
        int dp[][] = new int[n][3];
        for(int[] dp1: dp) {
            Arrays.fill(dp1, -1);
        }
        int min;
        min = Math.min(minPaint(0, costs, n, dp, 0), minPaint(1, costs, n, dp, 0));
        min = Math.min(min, minPaint(2, costs, n, dp, 0));
        return min;
    }

    private int minPaint(int i, int[][] costs, int n, int[][] dp, int house) {
        if (house >= n) {
            return 0;
        }
        i = i%3;
        if (dp[house][i]!=-1) {
            return dp[house][i];
        }
        return dp[house][i] = costs[house][i] + Math.min(minPaint(i+1,costs, n, dp, house+1),
                minPaint(i+2,costs, n, dp, house+1));
    }


}
