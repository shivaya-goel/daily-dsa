package DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String s1 = "aaaaaa";
        String s2 = "ababab";
        int[][] dp = new int[s1.length()][s2.length()];
        for (int[] arr: dp) {
            Arrays.fill(arr, -1);
        }
        System.out.println(lcs.lcs(s1, s2, 0, 0, dp));
    }

    private int lcs(String s1, String s2, int i, int j, int[][] dp) {
        if (i >= s1.length() || j >= s2.length()) {
            return 0;
        }
        if (dp[i][j]!=-1) {
            return dp[i][j];
        }
        if (s1.charAt(i)==s2.charAt(j)) {
            dp[i][j] = 1 + lcs(s1, s2, i+1, j+1, dp);
        } else {
            dp[i][j] = Math.max(lcs(s1, s2, i+1, j, dp), lcs(s1, s2, i, j+1, dp));
        }
        return dp[i][j];
    }

}
