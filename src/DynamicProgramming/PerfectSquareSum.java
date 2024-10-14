package DynamicProgramming;

import java.util.Arrays;

public class PerfectSquareSum {

    public static void main(String[] args) {
        int n = 1007;
        System.out.println("Minimum number of perfect squares are");
        System.out.println(squareSum(n));
    }

    private static int squareSum(int n) {
        int dp[] = new int[n+1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for(int i=1;i<=n;i++) {
            for(int j=1;j*j<=i;j++) {
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }

        return dp[n];
    }


}
