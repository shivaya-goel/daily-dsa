package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(2,3,6,7);
        int target = 7;
        Collections.sort(input);
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        combinations(output, new ArrayList<Integer>(), input, target, 0);
        System.out.println(output);
    }

    static void combinations(ArrayList<ArrayList<Integer>> output, ArrayList<Integer> current, List<Integer> input, int target, int start) {
        if(target < 0)
            return;
        else if(target==0) {
            output.add(new ArrayList<>(current));
        } else {
            for(int i=start;i<input.size();i++) {
                if(i>start && input.get(i)==input.get(i-1))
                    continue;
                current.add(input.get(i));
                combinations(output, current, input, target-input.get(i), i);
                current.remove(current.size()-1);
            }
        }
    }
    
}
