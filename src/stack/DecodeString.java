package stack;

import java.util.Stack;

public class DecodeString {

    static String decodedString(String s){
       Stack<Character> st = new Stack<>();
       for (int i=0;i<s.length();i++) {
           char c = s.charAt(i);
           if (c!=']') {
               st.push(c);
           } else {
               String part = "";
               while(st.peek() != '[') {
                   part = st.pop() + part;
               }
               st.pop();
               int num = getMultiplier(st);
               for (int j=0;j<num;j++) {
                   for(int k=0;k<part.length();k++) {
                       st.push(part.charAt(k));
                   }
               }
           }
       }
       return createStringFromStack(st);
    }

    private static int getMultiplier(Stack<Character> stack) {
        int num = 0;
        int factor = 1;
        while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
            num = (stack.pop() - '0') * factor + num;
            factor *= 10;
        }
        return num;
    }

    private static String createStringFromStack(Stack<Character> st) {
        String s = "";
        while(!st.isEmpty()) {
            s = st.pop() + s;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(decodedString("10[sg]"));
    }

}
