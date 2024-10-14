package LinkedList;

public class Palindromic {

    static boolean isPalindrome(Node head) {
        Node middle = getMiddle(head);
        Node head2 = reverse(middle.next);
        Node head1 = head;
        while(head1!=null && head2!=null) {
            if (head1.data!=head2.data) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }
    static Node getMiddle(Node head) {
        Node slow = head;
        Node fast = slow.next.next;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static Node reverse(Node head) {
        Node temp = head;
        Node temp1 = head;
        Node temp2 = null;
        while(temp!=null) {
            temp1 = temp.next;
            temp.next = temp2;
            temp2 = temp;
            temp = temp1;
        }
        return temp2;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {375,961,677,596,1,1,596,677,961,375};
        Node head = new Node(arr[0]);
        Node tail = head;
        for (int i=1;i<arr.length;i++) {
            tail.next = new Node(arr[i]);
            tail = tail.next;
        }
        Boolean node = isPalindrome(head);
        System.out.println(node);
    }


}
