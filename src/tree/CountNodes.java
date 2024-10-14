package tree;

import java.util.ArrayList;

public class CountNodes {

    private static int count(Node node) {
        if (node == null) {
            return 0;
        }
        int a = count(node.left);
        int b = count(node.right);
        return a+b+1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        System.out.println(count(node));
    }

}
