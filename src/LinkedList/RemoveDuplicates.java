package LinkedList;

import java.util.HashSet;
import java.util.Set;

import static common.Utils.printLinkedList;

public class RemoveDuplicates {

    public static Node removeDuplicates(Node head) {
        Node temp = head;
        Node temp2 = temp;
        Set<Integer> set = new HashSet<>();
        while(temp!=null) {
            int data = temp.data;
            if (set.contains(data)) {
                temp2.next = temp.next;
                temp = temp.next;
            } else {
                set.add(temp.data);
                temp2 = temp;
                temp = temp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,2,3,4,5,3};
        Node head = new Node(arr[0]);
        Node tail = head;
        for (int i=1;i<arr.length;i++) {
            tail.next = new Node(arr[i]);
            tail = tail.next;
        }
        Node node = removeDuplicates(head);
        printLinkedList(node);
    }

}
