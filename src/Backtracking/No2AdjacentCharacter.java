package Backtracking;

public class No2AdjacentCharacter {

    public static void main(String[] args) {
        No2AdjacentCharacter rea = new No2AdjacentCharacter();
        String str = rea.rearrangeString("aabbbccca");
        if (str == "") {
            System.out.println("Not Possible");
        }
        System.out.println(str);
    }

    private String rearrangeString(String input) {
        int n = input.length();
        if (n == 0) {
            return "";
        }
        int count[] = new int[26];
        for (char c: input.toCharArray()) {
            count[c-'a']++;
        }
        char ch = getMaxOccurCharacter(count);
        if (count[ch-'a'] > (n+1)/2) {
            return "";
        }
        int index = 0;
        char[] result = new char[n];
        while (count[ch - 'a'] > 0) {
            result[index] = ch;
            index+=2;
            count[ch - 'a']--;
        }
        for (int i=0;i<26;i++) {
            while (count[i] > 0) {
                if (index >= n) {
                    index = 1;
                }
                result[index] = (char) (i+'a');
                index +=2;
                count[i]--;
            }
        }
        return new String(result);
    }

    private char getMaxOccurCharacter(int[] count) {

        int max = 0;
        char c = ' ';
        for (int i=0;i<26;i++) {
            if (count[i] > max) {
                max = count[i];
                c = (char) ('a' + i);
            }
        }
        return c;
    }

}
