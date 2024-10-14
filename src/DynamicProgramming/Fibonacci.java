package DynamicProgramming;

import java.util.Arrays;

public class Fibonacci {

    public static void main(String[] args) {
        int n = 50;
        long start = System.currentTimeMillis();
        long a = fib(n);
        System.out.println("val: "+ a + " , time: " +(System.currentTimeMillis() - start));


        dp = new long[n+1];
        Arrays.fill(dp, -1);
        start = System.currentTimeMillis();
        a = fibByDP(n);
        System.out.println("val: "+ a + " , time: " +(System.currentTimeMillis() - start));
    }

    private static long fib(int n) {
        if (n<2) {
            return (long) n;
        }
        return fib(n-1)+fib(n-2);
    }

    private static long[] dp;
    private static long fibByDP(int n) {
        if (n<2) {
            return dp[n] = n;
        }
        if (dp[n]!=-1) {
            return dp[n];
        }
        return dp[n] = fibByDP(n-1)+fibByDP(n-2);
    }
}
