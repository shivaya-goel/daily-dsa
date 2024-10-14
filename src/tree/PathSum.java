package tree;

import java.util.ArrayList;

public class PathSum {

    public static boolean hasPathSum(Node root, int targetSum) {
        return path(root, targetSum);
    }

    static boolean path(Node node, int target) {
        if (target == 0) {
            return true;
        }
        if (target < 0) {
            return false;
        }
        if (node == null) {
            return false;
        }
        if (path(node.left, target-node.data)
                || path(node.right, target-node.data)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Node node = new Node(5);
        node.left = new Node(4);
        node.right = new Node(8);
        node.left.left = new Node(11);
        node.left.left.left = new Node(7);
        node.left.left.right = new Node(2);
        node.right.left = new Node(13);
        node.right.right = new Node(4);
        node.right.right.right = new Node(1);
        System.out.println(hasPathSum(node, 22));
    }

}
