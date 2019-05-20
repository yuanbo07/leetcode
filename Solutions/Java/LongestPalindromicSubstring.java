import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        String longestPalindrome = solution.longestPalindrome("babad");
        System.out.println(longestPalindrome);
    }
}

class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int longestPalindromeLen = 0;
        int longestPalindromeStartPos = 0;

        // i stands for the length of the current string
        for (int i = 0; i < len; i++) {
            // j stands for the starting position of the current string
            for (int j = 0; j < len - i; j++) {
                // if the string size if 0 or 1, it must be a palindrome
                if (i <= 2) {
                    dp[j][j + i] = true;
                    // if the string size is larger than 1, if the two extrémités of the string are equal
                } else if (s.charAt(j + i) == s.charAt(j)) {
                    // then if its inner string is a palindrome, it's also a palindrome
                    dp[j][j + i] = dp[j + 1][j + i - 1];
                } else {
                    dp[j][j + i] = false;
                }
                // if the string is a palindrome whose length is bigger, we take it
                if (dp[j][j + i] && i > longestPalindromeLen) {
                    longestPalindromeLen = i;
                    longestPalindromeStartPos = j;
                }
            }
        }
        // note that right side of substring is exclusive
        return s.substring(longestPalindromeStartPos, longestPalindromeStartPos + longestPalindromeLen + 1);
    }
}