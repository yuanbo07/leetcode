class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        hashmap = {}
        for i in range(len(nums)):
            if hashmap.get(nums[i]) is not None:
                return [hashmap.get(nums[i]), i]
            else:
                hashmap[target - nums[i]] = i
        return None

nums = [2, 7, 11, 15]
target = 9
print(Solution().twoSum(nums, target))