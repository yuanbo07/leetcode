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

class SolutionBruteForce {
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current))
                result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }
}