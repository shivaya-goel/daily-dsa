package DynamicProgramming;

import java.util.Arrays;

// https://leetcode.com/problems/house-robber-ii/submissions/1397331554/
public class Robbery2 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[][] dp = new int[nums.length][nums.length];
        for (int[] dp1: dp) {
            Arrays.fill(dp1, -1);
        }
        int maxLoot =  Math.max(maxLoot(nums, 0, dp, nums.length-2), maxLoot(nums, 1, dp, nums.length-1));
        return maxLoot;
    }

    int maxLoot(int[] nums, int start, int[][] dp, int end) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            return nums[start];
        }
        if (dp[start][end]!=-1) {
            return dp[start][end];
        }
        return dp[start][end] = Math.max(nums[start] + maxLoot(nums, start+2, dp, end), maxLoot(nums, start+1, dp, end));
    }

    public static void main(String[] args) {
        Robbery2 r = new Robbery2();
        System.out.println(r.rob(new int[] {1,2,1,1}));
    }
}
