package Geeks;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithDistinctChars {

    static int longestSubstrDistinctChars(String s){
        Map<Character, Integer> map = new HashMap<>();
        int j=0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                j=1;
                i = map.get(c) + 1;
                c = s.charAt(i);
                map = new HashMap<>();
            } else {
                j++;
            }
            map.put(c, i);
            max = Math.max(max, j);
        }
        return max;

    }

    public static void main(String[] args) {
        System.out.println(longestSubstrDistinctChars("aewergrththy"));
    }

}
