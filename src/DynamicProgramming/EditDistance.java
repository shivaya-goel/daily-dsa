package DynamicProgramming;

import java.util.Arrays;

public class EditDistance {

    public static void main(String[] args) {
        String s1 = "anshuman";
        String s2 = "antihuman";
        int[][] dp = new int[s1.length()][s2.length()];
        for (int arr[]: dp) {
            Arrays.fill(arr, 0);
        }
        EditDistance editDistance = new EditDistance();
        System.out.println(editDistance.insertDeleteReplace(s1, s2, 0, 0, dp));
    }

    private int insertDeleteReplace(String s1, String s2, int i, int j, int[][] dp) {
        if ( i>=s1.length() || j>=s2.length() ) {
            return 0;
        }
        if (dp[i][j]!=0) {
            return dp[i][j];
        }
        if (s1.charAt(i)!=s2.charAt(j)) {
            dp[i][j] = 1 + Math.min(insertDeleteReplace(s1, s2, i+1, j, dp), insertDeleteReplace(s1, s2, i, j+1, dp));
        } else {
            dp[i][j] = insertDeleteReplace(s1, s2, i+1, j+1, dp);
        }
        return dp[i][j];
    }

}
