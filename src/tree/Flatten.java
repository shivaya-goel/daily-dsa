package tree;

import java.util.ArrayList;

import static tree.CommonUtility.printPreOrder;

public class Flatten {

    public static void flatten(TreeNode root) {
        preorder(root);
    }

    static void preorder(TreeNode node) {
        if (node == null) {
            return;
        }
        preorder(node.left);
        if (node.left!=null && node.right != null) {
            TreeNode temp = node.right;
            node.right = node.left;
            node.left = null;
            TreeNode lastNode = getLastNode(node.right);
            lastNode.right = temp;
        } else if(node.left!=null && node.right == null) {
            node.right = node.left;
            node.left = null;
        }
        preorder(node.right);
    }

    private static TreeNode getLastNode(TreeNode right) {
        if (right.right == null) {
            return right;
        }
        return getLastNode(right.right);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
//        node.right = new TreeNode(5);
//        node.left.left = new TreeNode(3);
//        node.left.right = new TreeNode(4);
//        node.right.right = new TreeNode(6);
        flatten(node);
        printPreOrder(node);
    }

}
