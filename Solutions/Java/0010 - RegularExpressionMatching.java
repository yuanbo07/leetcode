package main;

public class Main {

    public static void main(String[] args) {
        String s = "mississippi";
        String p = "mis*is*p*.";
        System.out.println(new Solution().isMatch(s, p));
    }

    static class Solution {
        public boolean isMatch(String s, String p) {
            if (p.isEmpty()) return s.isEmpty();
            // only 1 char
            // we assume that '*' is invalid as p
            if (1 == p.length()) return (1 == s.length() && checkFirstChar(s, p));
            // 2nd char is not *, normal recursion
            if ('*' != p.charAt(1)) {
                if (s.isEmpty()) return false;
                return checkFirstChar(s, p) && isMatch(s.substring(1), p.substring(1));
            }
            // 2nd char is *, cut off matching part in s
            while (!s.isEmpty() && checkFirstChar(s, p)) {
                if (isMatch(s, p.substring(2))) return true;
                s = s.substring(1);
            }
            // cut off matching part in p
            return isMatch(s, p.substring(2));
        }
    }

    private static boolean checkFirstChar(String s, String p) {
        return s.charAt(0) == p.charAt(0) || p.charAt(0) == '.';
    }

    static class SolutionDP {
        public boolean isMatch(String s, String p) {

            if (null == s || null == p) {
                return false;
            }

            int lenStr = s.length();
            int lenPattern = p.length();

            boolean[][] dp = new boolean[lenStr + 1][lenPattern + 1];

            // if p and s are both empty, it's a match
            dp[0][0] = true;
            // if s is empty, p can be a match if p = (.*)*
            // attention the array cursor is one more than the str ordinal
            for (int i = 2; i < lenPattern + 1; i += 2) {
                if ('*' == p.charAt(i - 1) && dp[0][i - 2]) {
                    dp[0][i] = true;
                }
            }

            for (int i = 1; i < lenStr + 1; i++) {
                for (int j = 1; j < lenPattern + 1; j++) {
                    char curS = s.charAt(i - 1);
                    char curP = p.charAt(j - 1);
                    // if the character matches or equal to '.'
                    if ('.' == curP || curS == curP) {
                        dp[i][j] = dp[i - 1][j - 1];
                        // if we meet a '*' in p
                    } else if ('*' == curP) {
                        char preCurP = p.charAt(j - 2);
                        // if the latter character does not match, this #* is a match because it can be null
                        if ('.' != preCurP && preCurP != curS) {
                            dp[i][j] = dp[i][j - 2];
                        } else {
                            // dp[i-1][j]: If character before * appears >= 1 times
                            // dp[i][j-2]: If skip is necessary to match (even if c matches)
                            dp[i][j] = dp[i - 1][j] || dp[i][j-2];
                        }
                    }
                }
            }
            return dp[lenStr][lenPattern];
        }
    }
}

