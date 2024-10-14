package Geeks;

public class MaximumPath {

//    static int maximumPath(int n, int m[][])
//    {
//        int res = 0;
//        for (int i=n-2;i>=0;i--) {
//            for(int j=0;j<n;j++) {
//                if (j==0) {
//                    res = Math.max(m[i+1][j], m[i+1][j+1]);
//                } else if (j==n-1) {
//                    res = Math.max(m[i+1][j], m[i+1][j-1]);
//                } else {
//                    res = Math.max(m[i+1][j-1], m[i+1][j]);
//                    res = Math.max(res, m[i+1][j+1]);
//                }
//                m[i][j]+=res;
//            }
//        }
//        res = m[0][0];
//        for (int j=0;j<n;j++) {
//            res = Math.max(res, m[0][j]);
//        }
//        return res;
//    }

    static int solve(int r, int c, int mat[][], int n, int dp[][]) {
        if (r == n)
            return 0;
        if (c < 0 || c == n)
            return Integer.MIN_VALUE;

        if (dp[r][c]!=-1) return dp[r][c];

        int res = mat[r][c]
                + Math.max(solve(r + 1, c, mat, n, dp), Math.max(solve(r + 1, c + 1, mat, n, dp), solve(r + 1, c - 1, mat, n, dp)));
        return dp[r][c]=res;

    }

    static int maximumPath(int n, int mat[][]) {
        // code
        int res = Integer.MIN_VALUE;
        int dp[][] = new int[n+1][n+1];
        for (int i=0; i<n+1; i++){
            for (int j=0; j<n+1; j++){
                dp[i][j] = -1;
            }
        }
        for (int i = 0; i < n; i++) {
            res = Math.max(res, solve(0, i, mat, n, dp));
        }
        return res;
    }

    public static void main(String[] args) {
        int matrix[][] = new int[][]{
                {348,391},
                {618,193}};
        int n = maximumPath(2, matrix);
        System.out.println(n);
    }

}
