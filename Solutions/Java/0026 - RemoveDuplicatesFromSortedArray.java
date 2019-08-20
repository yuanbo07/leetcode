package main;

public class Main {

    public static void main(String[] args) {
        final int[] nums = {1, 1, 2};
        System.out.println(new Solution().removeDuplicates(nums));
    }
}

/**
 * Using two pointers technique.
 * Space complexity O(1)
 * Time complexity O(n)
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }
        // j is the fast pointer, i is the slow pointer
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                // the number of index i equals to the number of index of last j
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}