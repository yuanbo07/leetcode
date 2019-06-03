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
}

