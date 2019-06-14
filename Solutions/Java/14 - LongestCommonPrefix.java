public class Main {

    public static void main(String[] args) {
        String[] exemple1 = {"flower", "flow", "flight"};
        String[] exemple2 = {"dog", "racecar", "car"};
        String[] exemple3 = {"dog"};
        System.out.println(new Solution().longestCommonPrefix(exemple1));
        System.out.println(new Solution().longestCommonPrefix(exemple2));
        System.out.println(new Solution().longestCommonPrefix(exemple3));
    }

    static class Solution {
        String longestCommonPrefix(String[] strs) {

            if (null == strs || 0 == strs.length) {
                return "";
            }

            if (1 == strs.length) {
                return strs[0];
            }

            String strMinLen = null;
            int minLen = 0;
            for (String str : strs) {
                if (0 == minLen) {
                    minLen = str.length();
                    strMinLen = str;
                } else if (str.length() < minLen) {
                    minLen = str.length();
                    strMinLen = str;
                }
            }

            String sub = strMinLen;
            for (int i = 0; i < strs.length; i++) {
                while (0 != strs[i].indexOf(sub)) {
                    sub = sub.substring(0, sub.length() - 1);
                }
            }
            return sub;
        }
    }
}

