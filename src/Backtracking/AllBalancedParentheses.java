package Backtracking;


import java.util.ArrayList;

import static common.Utils.printList;

public class AllBalancedParentheses {

    public static void main(String[] args) {
        AllBalancedParentheses allBalancedParentheses = new AllBalancedParentheses();
        int n = 3;
        ArrayList<String> list = new ArrayList<>();
        allBalancedParentheses.fetchBalancedCombinations(n, n, list, "");
        printList(list);
    }

    private void fetchBalancedCombinations(int left, int right, ArrayList<String> list, String s) {
        if (left == 0 && right == 0) {
            list.add(s);
        }
        if (left > right || left < 0 || right < 0) {
            return;
        }
        s += "(";
        fetchBalancedCombinations(left-1, right, list, s);
        s = s.substring(0, s.length()-1);

        s+=")";
        fetchBalancedCombinations(left, right-1, list, s);
        s = s.substring(0, s.length()-1);
    }


}
