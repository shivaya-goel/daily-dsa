package Backtracking;

import java.util.*;

public class BreakingWord {

    public static void main(String[] args) {
        List<String> dictionary = Arrays.asList("shivaya","goel");
        String word = "shivayagoel";
        TrieNode root = new TrieNode();
        for(String s: dictionary) {
            insert(root, s);
        }
        if (segment(word, root, root, 0))
            System.out.print(1);
        else
            System.out.print(0);
    }

    private static boolean segment(String word, TrieNode root, TrieNode node, int start) {
        if(start == word.length() && node.isWord)
            return true;

        TrieNode t = root;
        for(int i=start;i<word.length();i++) {
            t = t.map.getOrDefault(word.charAt(i), null);
            if(t==null)
                return false;
            if(t.isWord) {
                if(segment(word, root, t, i+1))
                    return true;
            }
        }
        return false;
    }

    static class TrieNode {
        HashMap<Character, TrieNode> map = new HashMap<>();
        boolean isWord;
        TrieNode() {
            map =  new HashMap<>();
        }
    }

    static void insert(TrieNode root, String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++) {
            TrieNode node = curr.map.getOrDefault(word.charAt(i), new TrieNode());
            if(i == word.length()-1) {
                node.isWord = true;
            }
            curr.map.put(word.charAt(i), node);
            curr = node;
        }
    }

}
