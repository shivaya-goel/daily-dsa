package arrays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class MaxSlidingWindow {

    public static void main(String[] args) {
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        maxSlidingWindow.solve(List.of(1, 3, -1, -3, 5, 3, 6, 7), 3);
    }

    ArrayList<Integer> solve(List<Integer> list, int k) {
        ArrayList<Integer> outputList = new ArrayList<>();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i=0;i<list.size();i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i-k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && list.get(deque.peekLast())<list.get(i)) {
                deque.pollLast();
            }
            deque.addLast(i);

            if (i>=k-1) {
                outputList.add(list.get(deque.peekFirst()));
            }
        }
        return outputList;
    }

}
