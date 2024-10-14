package LinkedList;

import static common.Utils.printLinkedList;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[] {3,1,5,4,2};
        Node head = new Node(arr[0]);
        Node tail = head;
        for (int i=1;i<arr.length;i++) {
            tail.next = new Node(arr[i]);
            tail = tail.next;
        }
        Node re = mergeSort(head);
        printLinkedList(re);
    }

    public static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node second = divide(head);

        head = mergeSort(head);
        second = mergeSort(second);

        return merge(head, second);
    }

    private static Node merge(Node first, Node second) {
        if (first == null) return second;
        if (second == null) return first;

        if (first.data < second.data) {
            first.next = merge(first.next, second);
            return first;
        } else {
            second.next = merge(first, second.next);
            return second;
        }
    }

    private static Node divide(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            if (fast != null) {
                slow = slow.next;
            }
        }
        Node temp = slow.next;
        slow.next = null;
        return temp;
    }

}
