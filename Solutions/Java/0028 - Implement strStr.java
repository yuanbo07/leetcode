package main;

public class Main {

    public static void main(String[] args) {
        final int[] nums = {2, 2, 3, 3, 4};
        final int value = 3;
        System.out.println(new Solution().removeElement(nums, value));
    }
}

/**
 * Brute force.
 *
 * Space complexity O(1)
 * Time complexity O(n * m)
 */
class Solution {
    public int strStr(String haystack, String needle) {
        if (null == needle || needle.isEmpty()) {
            return 0;
        }
        // there is no need to continue if the length of remained string is <= needle.length() - 1
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int j;
            for (j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (needle.length() == j) {
                return i;
            }
        }
        return -1;
    }
}

/**
 * Knuth-Morris-Pratt (KPM) algorithm.
 *
 * m : length of String
 * n : length of needle
 *
 * LPS (longest prefix suffix) example:
 *
 * ababd
 * 00120
 *
 * Space complexity O(n)
 * Time complexity O(n + m)
 */
class Solution {

    public static int[] getLPS(char[] t) {
        int[] lps = new int[t.length];
        lps[0] = -1;
        lps[1] = 0;
        int k;
        for (int j = 2; j < t.length; j++) {
            k = lps[j - 1];
            while (k != -1) {
                if (t[j - 1] == t[k]) {
                    lps[j] = k + 1;
                    break;
                } else {
                    k = lps[k];
                }
                // when k == -1
                lps[j] = 0;
            }
        }
        return lps;
    }

    int strStr(String haystack, String needle) {
        char[] arrHaystack = haystack.toCharArray();
        char[] arrNeedle = needle.toCharArray();
        int[] lps = getLPS(arrNeedle);
        int i = 0;
        int j = 0;
        while (i < arrHaystack.length && j < arrNeedle.length) {
            if (j == -1 || arrHaystack[i] == arrNeedle[j]) {
                i++;
                j++;
            } else
                j = lps[j];
        }
        if (j == arrNeedle.length)
            return i - j;
        else
            return -1;
    }
}