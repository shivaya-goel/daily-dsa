package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static common.Utils.printList;
import static tree.BinaryTreePrinter.printTree;

public class RightView {

    public static List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return List.of();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        List<Integer> level = new ArrayList<>();
        while(!queue.isEmpty()) {
            level = new ArrayList<>();
            int size = queue.size();
            for(int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                if(node.left!=null) {
                    queue.add(node.left);
                }
                if(node.right!=null) {
                    queue.add(node.right);
                }
                level.add(node.val);
            }
            list.add(level.get(level.size()-1));
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
//        printTree(node);
        List<Integer> list = rightSideView(node);
        printList(list);
    }

}
