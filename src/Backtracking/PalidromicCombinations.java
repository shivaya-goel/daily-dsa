package Backtracking;

import java.util.ArrayList;

public class PalidromicCombinations {

    public static void main(String[] args) {
        System.out.println(partition("efe"));
    }

    public static ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<ArrayList<String>> output = new ArrayList<>();
        ArrayList<String> current = new ArrayList<>();
        palindrome(a, 0, current, output);
        return output;
    }

    static void palindrome(String a, int start, ArrayList<String> current, ArrayList<ArrayList<String>> output) {
        if(start == a.length()) {
            output.add(new ArrayList<>(current));
            return;
        }

        for(int i=start;i<a.length();i++) {
            String sub = a.substring(start, i+1);
            if(isPalindrome(sub)) {
                current.add(sub);
                palindrome(a, i+1, current, output);
                current.remove(current.size()-1);
            }
        }
    }

    static boolean isPalindrome(String sub) {
        int start = 0, end = sub.length()-1;
        while(start<end) {
            if(sub.charAt(start)!=sub.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
