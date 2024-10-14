package DynamicProgramming;

import java.util.Arrays;

public class Robbery {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return maxLoot(nums, nums.length-1, dp);
    }

    int maxLoot(int[] nums, int i, int[] dp) {
        if (i < 0) {
            return 0;
        }
        if (i == 0) {
            return nums[0];
        }
        if (dp[i]!=-1) {
            return dp[i];
        }
        return dp[i] = Math.max(nums[i] + maxLoot(nums, i-2, dp), maxLoot(nums, i-1, dp));
    }

    public static void main(String[] args) {
        Robbery r = new Robbery();
        System.out.println(r.rob(new int[] {2,1,1,2}));
    }
}
