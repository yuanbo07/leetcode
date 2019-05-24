import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        Integer target = 9;

        Solution solution = new Solution();
        int[] sol = solution.twoSum(nums, target);
        System.out.println("first : " + sol[0] + " second : " + sol[1]);
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> valueByPosition = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (null != valueByPosition.get(nums[i])) {
                return new int[]{valueByPosition.get(nums[i]), i};
            } else {
                valueByPosition.put(target - nums[i], i);
            }
        }
        return new int[2];
    }
}