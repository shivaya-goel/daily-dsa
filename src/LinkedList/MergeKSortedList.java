package LinkedList;

import java.util.ArrayList;
import java.util.List;

import static LinkedList.MergeSort.mergeSort;
import static common.Utils.printLinkedList;

class MergeKSortedList {
    static Node mergeKLists(List<Node> arr) {
        Node head = getWholeList(arr);
        return mergeSort(head);
    }

    private static Node getWholeList(List<Node> arr) {
        Node newHead = new Node(-1);
        newHead.next = arr.get(0);
        Node temp = newHead;
        for (Node node: arr) {
            temp.next = node;
            while (temp.next!=null) {
                temp = temp.next;
            }
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3},{7,8},{4,5},{5,6}};
        List<Node> list = new ArrayList<>();
        for (int a[]: arr) {
            Node head = new Node(a[0]);
            Node tail = head;
            for (int i = 1; i < a.length; i++) {
                tail.next = new Node(a[i]);
                tail = tail.next;
            }
            list.add(head);
        }
        Node node = mergeKLists(list);
        printLinkedList(node);
    }
}