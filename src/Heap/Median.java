package Heap;

import java.util.*;

public class Median {

    public static void main(String[] args) {
        List<Integer> list = List.of(2,3,4,1,5);
        System.out.println("Median is : " + getMedian(list));
    }

    private static int getMedian(List<Integer> list) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int n : list) {
            if(maxHeap.isEmpty() || n < maxHeap.peek()) {
                maxHeap.add(n);
                if(maxHeap.size() - minHeap.size() > 1) {
                    minHeap.add(maxHeap.poll());
                }
            } else {
                minHeap.add(n);
                if (minHeap.size() > maxHeap.size()) {
                    maxHeap.add(minHeap.poll());
                }
            }
        }

        if(maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek())/2;
        } else {
            return maxHeap.peek();
        }

    }


}