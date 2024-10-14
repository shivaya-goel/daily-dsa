package practice;

public class Solution {

    public static boolean checkInclusion(String s1, String s2) {
        int start = 0;
        int end = s1.length()-1;
        for(int i=0;i<s2.length();i++) {
            if (s1.charAt(start) == s2.charAt(i)) {
                int j=i;
                while (start < s1.length() && j<s2.length() && s1.charAt(start)== s2.charAt(j)) {
                    start++;
                    j++;
                }
                if (start == s1.length()) {
                    return true;
                }
                start=0;
            } else if (s1.charAt(end) == s2.charAt(i)) {
                int j = i;
                while (end >= 0 && j<s2.length() && s1.charAt(end)== s2.charAt(j)) {
                    end--;
                    j++;
                }
                if (end < 0) {
                    return true;
                }
                end = s1.length()-1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("abc", "bbbca"));
    }
}
