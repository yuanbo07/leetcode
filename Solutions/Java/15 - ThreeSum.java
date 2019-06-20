package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] num = {-1, 0, 1, 2, -1, -4};
        System.out.println(new Solution().threeSum(num));
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> temp;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (0 == sum) {
                    temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left + 1 < right && nums[right] == nums[right - 1]) right--;
                }
                if (0 >= sum) left++;
                else right--;
            }
        }
        return result;
    }
}