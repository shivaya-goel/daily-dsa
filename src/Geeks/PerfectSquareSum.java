package Geeks;

import java.util.Arrays;

public class PerfectSquareSum {

    static int findSquareSum(int sum) {
        int dp[] = new int[sum+1];
        Arrays.fill(dp, -1);
        int a = minimumSum(sum, dp);
        return a;
    }

    private static int minimumSum(int sum, int[] dp) {
        if (sum <= 0) {
            return 0;
        }
        if (dp[sum]!=-1) {
            return dp[sum];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1;i*i<=sum;i++) {
            min = Math.min(min, minimumSum(sum-(i*i), dp));
        }
        return dp[sum] = min+1;
    }

    public static void main(String[] args) {
        System.out.println(findSquareSum(20));
    }

}
