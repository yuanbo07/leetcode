package main;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        System.out.println(new Solution().fourSum(nums, 0));
    }
}

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        // 4Sum
        for (int i = 0; i < nums.length - 3; i++) {
            // ignore duplicate element
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // here is 3Sum
            for (int j = i + 1; j < nums.length - 2; j++) {
                // ignore duplicate element
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // here it's the same as 2Sum
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    // 2 pointers technique
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        results.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;

                        // ignore duplicate element
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }

                        // ignore duplicate element
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                }
            }
        }
        return results;
    }
}