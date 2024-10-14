package common;

import LinkedList.Node;

import java.util.List;

public class Utils {

    public static <T> void printListOfList(List<List<T>> input) {
        for (List<T> dataType: input) {
            for (T object: dataType) {
                System.out.print(object + " ");
            }
            System.out.println();
        }
    }

    public static void printLinkedList(Node head) {
        Node temp = head;
        while(temp!=null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static <T> void printList(List<T> list) {
        for(T key: list) {
            System.out.print(key + " ");
        }
        System.out.println();
    }

}
