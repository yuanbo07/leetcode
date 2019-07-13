import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String str = "ababd";
        String res1 = new SolutionDynamicProgramming().longestPalindrome(str);
        String res2 = new SolutionDiffusion().longestPalindrome(str);
        System.out.println(res1);
        System.out.println(res2);
    }
}

// Time : O(n*n), space: O(n*n)
class SolutionDynamicProgramming {
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

// Time : O(n*n), space: O(n)
class SolutionDiffusion {

    String res = "";

    public String longestPalindrome(String s) {
        if (null == s || s.length() == 0) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }
        return res;
    }

    // l'l
    // a b a b d
    //       r r'
    private void helper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        String str = s.substring(left + 1, right);
        if (str.length() > res.length()) {
            res = str;
        }
    }
}