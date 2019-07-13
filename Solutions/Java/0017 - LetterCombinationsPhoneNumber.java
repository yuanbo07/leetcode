package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(new Solution().letterCombinations(digits));
    }
}

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        letterCombinationsRec(digits, 0, "", list, map);
        return list;
    }

    public void letterCombinationsRec(String digits, int index, String letters, List<String> list, Map<Character, String> map) {
        if (index == digits.length()) {
            if (!letters.equals(""))
                list.add(letters);
            return;
        }
        char digit = digits.charAt(index);
        if ('0' == digit || '1' == digit) {
            letterCombinationsRec(digits, index + 1, letters, list, map);
            return;
        }
        // Three choices
        String s = map.get(digit);
        for (int i = 0; i < s.length(); i++) {
            letterCombinationsRec(digits, index + 1, letters + s.charAt(i), list, map);
        }
    }
}
