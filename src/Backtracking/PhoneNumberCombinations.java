package Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static common.Utils.printList;

public class PhoneNumberCombinations {

    private static Map<Character, String> map;

    public static List<String> letterCombinations(String digits) {
        if (digits.isBlank()) {
            return List.of();
        }
        List<String> list = new ArrayList<>();
        map = getRepresentationMap();
        addWords(digits, 0, "", list);
        return list;
    }

    private static void addWords(String digits, int index, String word, List<String> list) {
        if (index == digits.length()) {
            list.add(word);
        } else {
            String represent = map.get(digits.charAt(index));
            for (int i=0;i<represent.length();i++) {
                word += represent.charAt(i);
                addWords(digits, ++index, word, list);
                word = word.substring(0, word.length()-1);
                index--;
            }
        }
    }

    private static Map<Character, String> getRepresentationMap() {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        return map;
    }

    public static void main(String[] args) {
        List<String> lsit = letterCombinations("23");
        printList(lsit);
    }

}
