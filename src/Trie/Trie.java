package Trie;

import java.util.HashMap;
import java.util.Map;

class Trie {

    private Map<Character, Trie> rootMap;
    private boolean isWord;

    public Trie() {
        rootMap = new HashMap<>();
    }
    
    public void insert(String word) {
        if (0 == word.length()) {
            this.isWord = true;
            return;
        }
        if ("".equals(word)) {
            return;
        }
        Map<Character, Trie> map = this.rootMap;
        Trie root = this;
        Trie temp = root;
        char c = word.charAt(0);
        if (map.containsKey(c)) {
            temp = map.get(c);
        } else {
            Map<Character, Trie> tempMap = temp.rootMap;
            temp = new Trie();
            tempMap.put(c, temp);
        }
        temp.insert(word.substring(1));
    }

    public boolean search(String word) {
        Trie root = this;
        Trie temp = root;
        int i=0;
        while (temp.rootMap.containsKey(word.charAt(i))) {
            temp = temp.rootMap.get(word.charAt(i));
            if (i == word.length()-1) {
                return temp.isWord;
            }
            ++i;
        }
        return false;
    }
    
    public boolean startsWith(String prefix) {
        Trie root = this;
        Trie temp = root;
        int i=0;
        while (temp.rootMap.containsKey(prefix.charAt(i))) {
            if (i == prefix.length()-1) {
                return true;
            }
            temp = temp.rootMap.get(prefix.charAt(i));
            ++i;
        }
        return false;
    }
}



/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */