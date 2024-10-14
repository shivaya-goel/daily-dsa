package DynamicProgramming;

public class FindDigitsAndSum {

    public static void main(String[] args) {
        int mod = 1000000007;
        int n = 75;
        int t = 22;
        int[][] dp = new int[n+1][t+1];
        for (int i=1;i<10 && i<=t;i++) {
            dp[1][i] = 1;
        }

        for(int i=2;i<=n;i++) {
            for(int j=1;j<=t;j++) {
                for(int k=0;k<10 && k<=j;k++) {
                    dp[i][j] += dp[i-1][j-k];
                    dp[i][j]%=mod;
                }
            }
        }
        System.out.println(dp[n][t]);
    }

    public int solve(int A, int B) {
        int mod = 1000000007;
        int dp[][]= new int[A+1][B+1];
        for(int j=1;j<B+1;j++){
            dp[1][j]=1;
        }

        for(int i=2;i<=A;i++) {
            for(int j=1;j<=B;j++) {
                for(int k=0;k<=j && k<10;k++) {
                    dp[i][j] += dp[i-1][j-k];
                    dp[i][j]%=mod;
                }
            }
        }

        return dp[A][B];
    }
}
