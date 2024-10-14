package stack;

import java.util.Stack;

public class MinimumElementFromStack {

    private int min;
    private Stack<Integer> stack;

    MinimumElementFromStack() {
        stack = new Stack<>();
    }

    void push(int x) {
        if (stack.isEmpty()) {
            min = x;
        }
        if (min > x) {
            stack.push(2*x - min);
            min = x;
        } else {
            stack.push(x);
        }
    }

    int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        int curr = stack.peek();
        if (curr >= min) {
            return stack.pop();
        } else {
            stack.pop();
            min = 2*min - curr;
            return min;
        }
    }

    int getMin() {
        if (stack.isEmpty()) {
            return -1;
        }
        return min;
    }

    public static void main(String[] args) {
        MinimumElementFromStack mStack = new MinimumElementFromStack();
        mStack.push(5);
        mStack.push(3);
        mStack.push(7);
        mStack.getMin();
        mStack.pop();
        mStack.getMin();
        mStack.pop();
        mStack.getMin();
        mStack.pop();
    }


}
