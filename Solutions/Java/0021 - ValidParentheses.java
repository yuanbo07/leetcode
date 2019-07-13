package main;

import java.util.HashMap;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("){"));
    }
}

class Solution {
    public boolean isValid(String s) {
        if (s.isEmpty()) return true;
        HashMap<Character, Character> pair = new HashMap<>();
        pair.put(')', '(');
        pair.put(']', '[');
        pair.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                case '[':
                case '{':
                    stack.push(s.charAt(i));
                    break;
                default:
                    // if there is already no open bracket
                    if (stack.isEmpty()) return false;
                    Character poppedChar = stack.pop();
                    if (poppedChar != pair.get(s.charAt(i))) {
                        return false;
                    }
            }
        }
        return stack.isEmpty();
    }
}