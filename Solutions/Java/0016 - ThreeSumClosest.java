package main;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] num = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(new Solution().threeSumClosest(num, target));
    }
}

class Solution {
    public int threeSumClosest(int[] num, int target) {
        int result = num[0] + num[1] + num[num.length - 1];
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            // two pointers
            int start = i + 1, end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                // when the sum is bigger than the target, that means we have to pick a smaller end element
                // when the sum is smaller than the target, we have to pick a bigger start
                // until start meets end
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }
}