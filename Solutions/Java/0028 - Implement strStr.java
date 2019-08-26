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