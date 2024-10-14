package tree;

import java.util.HashMap;
import java.util.Map;

import static tree.CommonUtility.printPostOrder;

public class TreeFromInAndPreOrder {

    static int preIndex = 0;
    public static void main(String[] args) {
        int[] inorder = new int[]{3,1,4,0,5,2};
        int[] preorder = new int[]{0,1,3,4,2,5};
        Node node = constructTree(inorder, preorder);
        printPostOrder(node);
        System.out.println();
    }

    private static Node constructTree(int[] inorder, int[] preorder) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(inorder, preorder, 0, inorder.length-1, indexMap);
    }

    private static Node buildTree(int[] inorder, int[] preorder, int start, int end, Map<Integer, Integer> indexMap) {
        if (start > end) {
            return null;
        }
        int temp = preorder[preIndex++];
        Node root = new Node(temp);
        if(start == end) {
            return root;
        }

        root.left = buildTree(inorder, preorder, start, indexMap.get(temp)-1, indexMap);
        root.right = buildTree(inorder, preorder, indexMap.get(temp)+1, end, indexMap);

        return root;
    }

}
