package Geeks;

import java.util.Set;
import java.util.TreeSet;

public class UncommonChars {

    String uncommonChars(String A, String B)
    {
        Set<Character> aSet = new TreeSet<>();
        Set<Character> bSet = new TreeSet<>();
        for (int i=0;i<A.length(); i++) {
            aSet.add(A.charAt(i));
        }
        for (int i=0;i<B.length(); i++) {
            bSet.add(B.charAt(i));
        }
        for (char c: bSet) {
            if (aSet.contains(c)) {
                aSet.remove(c);
            } else {
                aSet.add(c);
            }
        }
        String out = "";
        for (char c: aSet) {
            out+=c;
        }
        return out;
    }

    public static void main(String[] args) {
        UncommonChars solution = new UncommonChars();
        String a = "geeksforgeeks";
        String b = "geeksquiz";
        System.out.println(solution.uncommonChars(a, b));
    }
}
