package arrays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NegativeSlidingWindow {

    public static void main(String[] args) {
        NegativeSlidingWindow negativeSlidingWindow = new NegativeSlidingWindow();
//        ArrayList<Integer> out = negativeSlidingWindow.solve(List.of(-8, 2, 3, -6, 10), 2);
        negativeSlidingWindow.printFirstNegativeInteger(new long[]{-8l, 2l, 3l, -6l, 10l}, 5, 2);
    }

//    ArrayList<Integer> solve(List<Integer> list, int k) {
//        ArrayList<Integer> outputList = new ArrayList<>();
//        Deque<Integer> deque = new ArrayDeque<>();
//
//        for (int i=0;i<list.size();i++) {
//            if (!deque.isEmpty() && deque.peekFirst() == i-k) {
//                deque.pollFirst();
//            }
//
//            while (!deque.isEmpty() && list.get(deque.peekLast()) >= 0) {
//                deque.pollLast();
//            }
//            deque.addLast(i);
//            if (i>=k-1) {
//                if (list.get(deque.peekFirst())<0) {
//                    outputList.add(list.get(deque.peekFirst()));
//                } else {
//                    outputList.add(0);
//                }
//            }
//        }
//        return outputList;
//    }

    public long[] printFirstNegativeInteger(long A[], int n, int k) {
        long[] output = new long[n-k+1];
        Deque<Integer> deque = new ArrayDeque<>();
        int j=0;
        for (int i=0;i<n;i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i-k) {
                deque.pollFirst();
            }
            while(!deque.isEmpty() && A[deque.peekLast()] >= 0) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (i>=k-1) {
                long l = A[deque.peekFirst()];
                if (l<0) {
                    output[j] = l;
                } else {
                    output[j] = 0;
                }
                j++;
            }
        }
        return output;
    }

}