package LinkedList;

import static common.Utils.printLinkedList;

public class ReverseList {

    private static Node reverseList(Node head) {
        Node temp = head;
        Node temp2 = temp;
        Node prev = null;
        while(temp!=null) {
            temp2 = temp2.next;
            temp.next = prev;
            prev = temp;
            temp = temp2;
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5,6};
        Node head = new Node(arr[0]);
        Node tail = head;
        for (int i=1;i<arr.length;i++) {
            tail.next = new Node(arr[i]);
            tail = tail.next;
        }
        Node node = reverseList(head.next.next);
        printLinkedList(node);
    }
}
