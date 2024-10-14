package stack;

import java.util.Stack;

public class ParenthesisChecker {

    public static void main(String[] args) {
        System.out.println(isBalanced("((()))()"));
    }

    private static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                char top = stack.peek();
                if (isCorrectlyBalanced(top, c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isCorrectlyBalanced(char top, char c) {
        return ((c == ']' && top == '[') || (c == '}' && top == '{') || (c == ')' && top == '('));
    }

//    private static boolean isBalanced(String s) {
//        int counter = 0;
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c == '(') {
//                counter++;
//            } else if (c == ')') {
//                counter--;
//                if (counter < 0) {
//                    return false;
//                }
//            }
//        }
//        return counter == 0;
//    }


}
