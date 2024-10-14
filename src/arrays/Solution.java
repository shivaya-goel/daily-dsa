package arrays;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println((findMedianSortedArrays(List.of(-49, 33, 35, 42), List.of(-26))));
    }

	private static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        int i = a.size();
        int j = b.size();
        double sum = 0;
        if (i==0 && j==0) {
            return sum;
        } else if (i==0) {
            sum = b.get(0);
            return sum;
        } else if (j==0) {
            sum = a.get(0);
            return sum;
        }
        int mid = (i+j)/2;
        List<Integer> c = merge(a,b);
        if ((a.size()+b.size())%2==0) {
            sum = (c.get(mid-1) + c.get(mid))/2;
        } else {
            sum = c.get(mid);
        }
        return sum;
	}

    static List<Integer> merge(List<Integer> a, List<Integer> b) {
        List<Integer> c = new ArrayList<>();
        int i = 0;
        int j = 0;
        int x = a.size();
        int y = b.size();
        while (x > 0 && y > 0) {
            if(a.get(i) >= b.get(j)) {
                c.add(b.get(j));
                y--;
                j++;
            } else {
                c.add(a.get(i));
                x--;
                i++;
            }
        }
        while (x > 0) {
            c.add(a.get(i));
            x--;
            i++;
        }
        while (y > 0) {
            c.add(b.get(j));
            y--;
            j++;
        }
        return c;
    }
}
