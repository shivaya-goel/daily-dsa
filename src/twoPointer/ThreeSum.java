package twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        List<List<Integer>> output = threeSum(new int[]{-1,0,1,2,-1,-4});
        for(List<Integer> arr : output) {
            System.out.println(arr);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        for (int i=0;i<nums.length-2;i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i+1;
            int k = nums.length-1;
            while(j<k) {
                int sum = nums[i]+nums[j]+nums[k];
                if (sum == 0) {
                    output.add(new ArrayList<>(List.of(nums[i],nums[j],nums[k])));
                    j++;
                    k--;

                    while (j<k && nums[j]==nums[j-1]) {
                        j++;
                    }
                    while (j<k && nums[k]==nums[k+1]) {
                        k--;
                    }
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return output;
    }

}
