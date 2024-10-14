package Geeks;

import java.util.List;

// Kadans Algorithm
public class MaxProductSubArray {

    public static int maxProduct(final List<Integer> A) {

        if (A == null || A.size() == 0) return 0;
        int min = A.get(0);
        int max = A.get(0);
        int result = A.get(0);

        for(int i=1;i<A.size();i++) {
            int curr = A.get(i);
            if (curr<0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(curr, max*curr);
            min = Math.min(curr, min*curr);

            result = Math.max (result, max);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(List.of(0,0,0,-3,-2,0,1,0,0,0,0,0,-2,0,0,0,3,3,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-2,0,0,0,-1,0,0,0,0,0,0,2,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,-1,0,0,3,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-2,0,0,0,0,-1,0,0,0,0,0,0,-3,0,0,0,0,-1,0,2,0,0,0,0,3,0,0,0,0,0,0,0,0,0,2,0,2,0,0,-2,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,0,-3,1,0,0,0,0,0,0,0,0,0,0,-2,0,0,3,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,-1,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,-3,0,0,0,0,0,0,0,-1,-2,0,0,0,0,0,0,0,0,0,0,0,-1,0,0,0,0,0,0,0,0,0,0,0,0,0)));
    }

}
