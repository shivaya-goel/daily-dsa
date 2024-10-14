package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class SpiralOrderTraversal {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(7);
        node.left.right = new Node(6);
        node.right.left = new Node(5);
        node.right.right = new Node(4);
        findSpiral(node, list);
    }

    static ArrayList<Integer> findSpiral(Node root, ArrayList<Integer> list) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> levelList = new ArrayList<>(size);
            for (int i=0;i<size;i++) {
                Node node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (!flag)
                    levelList.add(0, node.data);
                else
                    levelList.add(node.data);
            }
            list.addAll(levelList);
            flag = !flag;
        }
        return list;
    }

}
