package LinkedList;

import static common.Utils.printLinkedList;

class ReorderList {
    public Node reorderList(Node head) {
        Node middle = getMiddle(head);
        Node reverse = reverseList(middle);
        Node temp = head;
        Node temp2;
        Node reverse2;
        while(temp!=middle) {
            temp2 = temp.next;
            reverse2 = reverse.next;
            temp.next = reverse;
            reverse.next = temp2;
            temp = temp2;
            reverse = reverse2;
        }
        temp.next = null;
        return head;
    }

    private Node getMiddle(Node head) {
        Node temp = head;
        Node temp2 = head;
        while(temp2!=null && temp2.next!=null) {
            temp = temp.next;
            temp2 = temp2.next.next;
        }
        return temp;
    }

    private Node reverseList(Node head) {
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
        ReorderList reorderList = new ReorderList();
        int[] arr = new int[] {1,2,3,4,5};
        Node head = new Node(arr[0]);
        Node tail = head;
        for (int i=1;i<arr.length;i++) {
            tail.next = new Node(arr[i]);
            tail = tail.next;
        }
        Node re = reorderList.reorderList(head);
        printLinkedList(re);
    }
}