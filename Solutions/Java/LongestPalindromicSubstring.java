import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        String longestPalindrome = solution.longestPalindrome("a");
        System.out.println(longestPalindrome);
    }
}

class Solution {
    public String longestPalindrome(String s) {
        if (null == s || s.length() == 0) {
            return s;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int maxLen = 0;
        String longestPalindrome = "";

        // j stands for the ending position of the current string
        for (int j = 0; j < len; j++) {
            // i stands for the starting position of the current string
            for (int i = 0; i <= j; i++) {
                // checks:
                // 1. two extremity characters are equal
                // 2. if the length is smaller than 2 && 1 => palindrome (e.g. "a" or "aa")
                // 3. inner string is already a palindrome => dynamic programming
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);
                // update the max length
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    // note that right side of substring is exclusive
                    longestPalindrome = s.substring(i, j + 1);
                }
            }
        }
        return longestPalindrome;
    }
}