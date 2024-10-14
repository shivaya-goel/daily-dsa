package Geeks;

import java.util.Arrays;

class CountCoinDenominations {
    static long find(int[] coins, int n, int i, int sum, long[][] dp) {
        if (sum < 0 || i == n) return 0;
        if (sum == 0) return 1;
        if (dp[i][sum] != -1) return dp[i][sum];
        long s = 0;
        s += find(coins, n, i,sum - coins[i], dp);
        s += find(coins, n, i + 1, sum,  dp);
        return dp[i][sum] = s;
    }

    public long count(int coins[], int N, int sum) {
        long[][] dp = new long[N + 1][sum + 1];
        for (long[] t : dp) Arrays.fill(t, -1);
        long q = find(coins, N, 0, sum, dp);
        return q;
    }

    public static void main(String[] args) {
        CountCoinDenominations solution = new CountCoinDenominations();
        long c = solution.count(new int[]{89,62,82,87,88,53,29,16,50,95,70,32,17,57,3,61,44,91,24,72,94,34,90,52,7,65,22,15,92,38,60,63,78,64,55,36,46,85,30,11,12,33,96,45,13,4,98,40,93,83,1,42},
                52, 432);
        System.out.println(c);
    }
}