package LinkedList;

public class Partition {

    public static Node partition(Node node, int x) {
        Node firstHead = new Node(-1);
        Node middleHead = new Node(-1);
        Node lastHead = new Node(-1);
        Node temp = node;
        Node first = firstHead;
        Node middle = middleHead;
        Node last = lastHead;
        while(temp!=null) {
            int data = temp.data;
            if (temp.data<x) {
                first.next = new Node(data);
                first = first.next;
            } else if (data == x) {
                middle.next = new Node(data);
                middle = middle.next;
            } else {
                last.next = new Node(data);
                last = last.next;
            }
            temp = temp.next;
        }
        first.next = middleHead.next;
        middle.next = lastHead.next;
        return firstHead.next;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,4,3,2,5,2};
        Node head = new Node(arr[0]);
        Node tail = head;
        for (int i=1;i<arr.length;i++) {
            tail.next = new Node(arr[i]);
            tail = tail.next;
        }
        Node node = partition(head, 3);
        System.out.println(node.data);
    }

}
