package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static common.Utils.printListOfList;

public class GroupOfAnagrams {

    public static void main(String[] args) {
        GroupOfAnagrams groupOfAnagrams = new GroupOfAnagrams();
//        List<List<String>> lists = groupOfAnagrams.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        List<List<String>> lists = groupOfAnagrams.groupAnagrams(new String[]{"bdddddddddd","bbbbbbbbbbc"});
        printListOfList(lists);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new TreeMap<>();

        for (String str: strs) {
            int[] count = new int[26];
            for (int i=0;i<str.length();i++) {
                char c = str.charAt(i);
                count[c -'a']++;
            }
            String key = getKey(count);
            List<String> group = anagrams.getOrDefault(key, new ArrayList<>());
            group.add(str);
            anagrams.put(key, group);
        }
        return getGroupOfAnagrams(anagrams);
    }

    private String getKey(int[] count) {
        StringBuilder key = new StringBuilder();
        for (int i: count) {
            key.append(i).append('#');
        }
        return key.toString();
    }

    private List<List<String>> getGroupOfAnagrams(Map<String, List<String>> map) {
        List<List<String>> lists = new ArrayList<>();
        for (String key: map.keySet()) {
            lists.add(map.get(key));
        }
        return lists;
    }

}
