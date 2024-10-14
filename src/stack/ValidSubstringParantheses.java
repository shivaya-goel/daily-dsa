package stack;

import java.util.Stack;

public class ValidSubstringParantheses {
    public static void main(String[] args) {
        System.out.println(isBalanced("))(("));
    }

    private static int isBalanced(String s) {
        int left = 0, right = 0, maxLength = 0;

        // Left to Right scan
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLength = Math.max(maxLength, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }

        // Reset and do Right to Left scan
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLength = Math.max(maxLength, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxLength;
    }

//    private static int isBalanced(String s) {
//        int left = 0, right = 0, maxLength = 0;
//
//        // Left to Right scan
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(') {
//                left++;
//            } else {
//                right++;
//            }
//            if (left == right) {
//                maxLength = Math.max(maxLength, 2 * right);
//            } else if (right > left) {
//                left = right = 0;
//            }
//        }
//
//        // Reset and do Right to Left scan
//        left = right = 0;
//        for (int i = s.length() - 1; i >= 0; i--) {
//            if (s.charAt(i) == '(') {
//                left++;
//            } else {
//                right++;
//            }
//            if (left == right) {
//                maxLength = Math.max(maxLength, 2 * left);
//            } else if (left > right) {
//                left = right = 0;
//            }
//        }
//
//        return maxLength;
//    }

}
