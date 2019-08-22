package main;

public class Main {

    public static void main(String[] args) {
        final int[] nums = {2, 2, 3, 3, 4};
        final int value = 3;
        System.out.println(new Solution().removeElement(nums, value));
    }
}

/**
 * Two pointers technique.
 *
 * Space complexity O(1)
 * Time complexity O(n)
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}