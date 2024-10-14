package stack;

class MyStack {
     class StackNode {
         int data;
         StackNode next;
         StackNode(int a) {
             data = a;
             next = null;
         }
     }
    StackNode top;
    StackNode head;
    // Function to push an integer into the stack.
    void push(int a) {
        StackNode node = new StackNode(a);
        if (top==null) {
            top = node;
            head = node;
        } else {
            top.next = node;
            top = node;
        }
    }

    // Function to remove an item from top of the stack.
    int pop() {
        if (head == null) {
            return -1;
        }
        StackNode temp = head;
        if (top == head) {
            head = null;
            top = null;
            return temp.data;
        }
        while(temp.next != top) {
            temp = temp.next;
        }
        int data = top.data;
        temp.next = null;
        top = temp;
        return data;
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(67);
        stack.pop();
        stack.push(23);

    }
}