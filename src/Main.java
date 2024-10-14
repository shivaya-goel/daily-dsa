import java.util.*;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int s = sc.nextInt();
//        int x = sc.nextInt();
//        ListNode head = new ListNode(x);
//        ListNode node = head;
//        for (int i=1;i<s;i++) {
//            node.next = new ListNode(sc.nextInt());
//            node = node.next;
//        }
//        int k = sc.nextInt();
//        printList(reverseGroup(head, k));
//    }
//
//    static void printList(ListNode headref) {
//        while (headref != null) {
//            System.out.print(headref.val + " ");
//            headref = headref.next;
//        }
//    }
//
//
//    public static class ListNode {
//        public int val;
//        public ListNode next;
//
//        ListNode(int x) {
//            val = x;
//            next = null;
//        }
//    }
//
//    public static ListNode reverseGroup(ListNode head, int k) {
//        if(head == null)
//            return null;
//        ListNode curr = head;
//        ListNode prev = null;
//        ListNode next = null;
//        int count = 0;
//        while (count < k && curr!=null) {
//            next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//            count++;
//        }
//        if (curr != null) {
//            head.next = reverseGroup(next, k);
//        }
//        return prev;
//    }
//
//    public static ListNode sortList(ListNode A) {
//        if (A == null || A.next == null)
//            return A;
//        ListNode middle = middle(A);
//        ListNode h2 = middle.next;
//        middle.next = null;
//        System.out.println("Middle:" + middle.val);
//        ListNode left = sortList(A);
//        ListNode right = sortList(h2);
//        return mergeTwoLists(left, right);
//    }
//
//    public static ListNode middle(ListNode A) {
//        if (A == null)
//            return null;
//        ListNode slow = A;
//        ListNode fast = A;
//        while (fast.next != null && fast.next.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return slow;
//    }
//
//    public static ListNode mergeTwoLists(ListNode A, ListNode B) {
//        ListNode C = null;
//        ListNode temp = null;
//        if (A == null)
//            return B;
//        if (B == null)
//            return A;
//        if (A.val < B.val) {
//            C = A;
//            temp = A;
//            A = A.next;
//        } else {
//            C = B;
//            temp = B;
//            B = B.next;
//        }
//        while (A != null && B != null) {
//            if (A.val < B.val) {
//                temp.next = A;
//                A = A.next;
//            } else {
//                temp.next = B;
//                B = B.next;
//            }
//            temp = temp.next;
//        }
//        if (A != null) {
//            temp.next = A;
//        }
//        if (B != null) {
//            temp.next = B;
//        }
//        return C;
//    }
//}

//public class Main {
//    node head = null;
//    // node a, b;
//    class node {
//        int val;
//        node next;
//
//        public node(int val)
//        {
//            this.val = val;
//        }
//    }
//
//    node sortedMerge(node a, node b)
//    {
//        node result = null;
//        if (a == null)
//            return b;
//        if (b == null)
//            return a;
//        if (a.val <= b.val) {
//            result = a;
//            result.next = sortedMerge(a.next, b);
//        }
//        else {
//            result = b;
//            result.next = sortedMerge(a, b.next);
//        }
//        return result;
//    }
//
//    node mergeSort(node h)
//    {
//        if (h == null || h.next == null) {
//            return h;
//        }
//        node middle = getMiddle(h);
//        node nextofmiddle = middle.next;
//        middle.next = null;
//        System.out.println(middle.val);
//        node left = mergeSort(h);
//        node right = mergeSort(nextofmiddle);
//        node sortedlist = sortedMerge(left, right);
//        return sortedlist;
//    }
////    public static ListNode sortList(ListNode A) {
////        if (A == null || A.next == null)
////            return A;
////        ListNode middle = middle(A);
////        ListNode h2 = middle.next;
////        middle.next = null;
////        System.out.println("Middle:" + middle.val);
////        ListNode left = sortList(A);
////        ListNode right = sortList(h2);
////        return mergeTwoLists(left, right);
////    }
//
//    // Utility function to get the middle of the linked list
//    public static node getMiddle(node head)
//    {
//        if (head == null)
//            return head;
//        node slow = head, fast = head;
//        while (fast.next != null && fast.next.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return slow;
//    }
//    public static ListNode middle(ListNode A) {
//        if (A == null)
//            return null;
//        ListNode slow = A;
//        ListNode fast = A;
//        while (fast.next != null && fast.next.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return slow;
//    }
//
//    void push(int new_data)
//    {
//        / allocate node /
//        node new_node = new node(new_data);
//
//        / link the old list of the new node /
//        new_node.next = head;
//
//        / move the head to point to the new node /
//        head = new_node;
//    }
//
//    // Utility function to print the linked list
//    void printList(node headref)
//    {
//        while (headref != null) {
//            System.out.print(headref.val + " ");
//            headref = headref.next;
//        }
//    }
//
//    public static void main(String[] args)
//    {
//
//        Main li = new Main();
//        /
//          Let us create a unsorted linked list to test the functions
//          created. The list shall be a: 2->3->20->5->10->15
//         /
//        li.push(5);
//        li.push(3);
//        li.push(1);
//        li.push(4);
//        li.push(2);
//
//        // Apply merge Sort
//        li.head = li.mergeSort(li.head);
//        System.out.print("\n Sorted Linked List is: \n");
//        li.printList(li.head);
//    }
//}

//class LinkedList {
//
//    static Node head;
//
//    public static class Node {
//
//        int data;
//        Node next;
//
//        Node(int d)
//        {
//            data = d;
//            next = null;
//        }
//    }
//
//    // Function that detects loop in the list
//    void detectAndRemoveLoop(Node node)
//    {
//
//        // If list is empty or has only one node
//        // without loop
//        if (node == null || node.next == null)
//            return;
//
//        Node slow = node, fast = node;
//
//        // Move slow and fast 1 and 2 steps
//        // ahead respectively.
//        slow = slow.next;
//        fast = fast.next.next;
//
//        // Search for loop using slow and fast pointers
//        while (fast != null && fast.next != null) {
//            if (slow == fast)
//                break;
//
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//
//        / If loop exists /
//        if (slow == fast) {
//            slow = node;
//            if (slow != fast) {
//                while (slow.next != fast.next) {
//                    slow = slow.next;
//                    fast = fast.next;
//                }
//                / since fast->next is the looping point /
//                fast.next = null; / remove loop /
//            }
//            / This case is added if fast and slow pointer meet at first position. /
//            else {
//                while(fast.next != slow) {
//                    fast = fast.next;
//                }
//                fast.next = null;
//            }
//        }
//    }
//
//    // Function to print the linked list
//    void printList(Node node)
//    {
//        while (node != null) {
//            System.out.print(node.data + " ");
//            node = node.next;
//        }
//    }
//    public static class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode(int x) {
//       val = x;
//       left=null;
//       right=null;
//      }
//  }

//    public static ArrayList<ArrayList<Integer>> solve(TreeNode A) {
//        ArrayList<ArrayList<Integer>> levelList = new ArrayList<>();
//        Queue<TreeNode> q = new LinkedList<>();
//        q.add(A);
//        q.add(null);
//        ArrayList<Integer> nodeList = new ArrayList<>();
//        while(q.size()>1) {
//            TreeNode n = q.poll();
//            if(n==null) {
//                levelList.add(nodeList);
//                nodeList = new ArrayList<>();
//                q.add(null);
//                continue;
//            }
//            nodeList.add(n.val);
//            if(n.left!=null) {
//                q.add(n.left);
//            }
//            if(n.right!=null) {
//                q.add(n.right);
//            }
//        }
//        levelList.add(nodeList);
//        return levelList;
//    }
//    public static class Pair {
//        TreeNode key;
//        Integer value;
//
//        Pair(TreeNode x, Integer val) {
//            key = x;
//            value = val;
//        }
//    }

//    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
//        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
//        Queue<Pair> q = new LinkedList<>();
//        q.add(new Pair(A, 0));
//        while(!q.isEmpty()) {
//            Pair pair = q.poll();
//            TreeNode node = pair.key;
//            int index = pair.value;
//            ArrayList<Integer> list = map.getOrDefault(index, new ArrayList<>());
//            list.add(node.val);
//            map.put(index, list);
//            if (node.left!=null) {
//                q.add(new Pair(node.left, index-1));
//            }
//            if (node.right!=null) {
//                q.add(new Pair(node.right, index+1));
//            }
//        }
//
//        ArrayList<ArrayList<Integer>> finalList = new ArrayList<>();
//        for(int i: map.keySet()) {
//            ArrayList<Integer> list = map.get(i);
//            finalList.add(list);
//        }
//        return finalList;
//    }

//    public static ArrayList<Integer> solve(TreeNode A) {
//        Queue<TreeNode> q = new LinkedList<>();
//        q.add(A);
//        ArrayList<Integer> list = new ArrayList();
//        while(!q.isEmpty()) {
//            TreeNode node = q.poll();
//            if(q.isEmpty()) {
//                list.add(node.val);
//            }
//            if(node.left!=null) {
//                q.add(node.left);
//            }
//            if(node.right!=null) {
//                q.add(node.right);
//            }
//        }
//        return list;
//    }
//
//        public static ArrayList<String> prefix(ArrayList<String> A) {
//            TrieNode root = new TrieNode();
//            ArrayList<String> list = new ArrayList<>();
//            for(String s:A) {
//                insert(root, s);
//            }
//            for(String s:A) {
//                list.add(shortestPrefix(root, s));
//            }
//            return list;
//        }
//        public static class TrieNode {
//            HashMap<Character, TrieNode> map = new HashMap<>();
//            int wordCount;
//            int iterateCount;
//            TrieNode() {
//                map =  new HashMap<>();
//                wordCount = 0;
//                iterateCount = 0;
//            }
//        }
//
//        static void insert(TrieNode root, String word) {
//            TrieNode curr = root;
//            for(int i=0;i<word.length();i++) {
//                TrieNode node = curr.map.getOrDefault(word.charAt(i), new TrieNode());
//                node.iterateCount++;
//                if(i==word.length()-1) {
//                    node.wordCount++;
//                }
//                curr.map.put(word.charAt(i), node);
//                curr = node;
//            }
//        }
//
//        static String shortestPrefix(TrieNode root, String word) {
//            TrieNode curr = root;
//            String s = "";
//            for(int i=0;i<word.length();i++) {
//                TrieNode node = curr.map.get(word.charAt(i));
//                if(1!=node.iterateCount) {
//                    s+=word.charAt(i);
//                } else if (1==node.iterateCount) {
//                    s+=word.charAt(i);
//                    break;
//                }
//                curr = node;
//            }
//            return s;
//        }
//    // Driver code
//    public static void main(String[] args)
//    {
////        TreeNode root = new TreeNode(1);
////        root.left = new TreeNode(2);
////        root.right = new TreeNode(3);
////        root.left.left = new TreeNode(4);
////        root.left.right = new TreeNode(5);
////        root.right.left = new TreeNode(6);
////        root.right.right = new TreeNode(7);
////        root.left.left.left = new TreeNode(8);
////        for(ArrayList<Integer> list :solve(root)) {
////            for(int i: list) {
////                System.out.print(i);
////            }
////            System.out.println();
////        }
////        for(int list :solve(root)) {
////            System.out.println(list);
////        }
//        ArrayList<String> input = new ArrayList<>();
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        for (int i=0;i<n;i++) {
//            input.add(sc.next());
//        }
//        ArrayList<String> output = prefix(input);
//        for (int i=0;i<n;i++) {
//            System.out.println(output.get(i));
//        }
//    }
//}