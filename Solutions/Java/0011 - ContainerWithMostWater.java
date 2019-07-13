package main;

public class Main {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(new Solution().maxArea(height));
    }
}

class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0, left = 0, right = height.length - 1;
        while (left < right) {
            maxWater = Math.max(maxWater, (right - left) * Math.min(height[left], height[right]));
            // we can only increase the area by increasing the lower side
            if (height[left] < height[right]) left++;
            else right--;
        }
        return maxWater;
    }
}