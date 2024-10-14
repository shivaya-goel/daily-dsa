package Geeks;

public class ClimbStairMaxWay {

    static long findWays (int n) {
        long dp[] = new long[n+1];
        for (int i=0;i<n+1;i++) {
            dp[i] = -1;
        }
        return maxWays(0,n, dp);
    }

    private static long maxWays(int i, int n, long[] dp) {
        if (i>n) {
            return 0;
        }
        if (n==i) {
            return 1;
        }
        if (dp[i]!=-1) {
            return dp[i];
        }
        long s = 0;
        s+= maxWays(i+1,n,dp);
        s+= maxWays(i+2,n,dp);
        return dp[i] = s;
    }

    public static void main(String[] args) {
        System.out.println(findWays(3));
    }

}
