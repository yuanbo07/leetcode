package main;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }
}

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (0 == n) {
            return result;
        }
        helper(n, n, "", result);
        return result;
    }

    /**
     * Backtracking helper.
     *
     * @param o number of left open parentheses
     * @param c number of left closed parentheses
     * @param currentString current string
     * @param result list of all well-formed parentheses string
     */
    private void helper(int o, int c, String currentString, List<String> result) {
        // if there exists closed parenthese without open one, it can't be well-formed
        if (o > c) {
            return;
        }
        if (o == 0 && c == 0) {
            result.add(currentString);
        }
        if (o > 0) {
            helper(o - 1, c, currentString + "(", result);
        }
        if (c > 0) {
            helper(o, c - 1, currentString + ")", result);
        }
    }
}