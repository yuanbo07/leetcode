class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        strlen = len(s)
        charSet = set()
        maxLen = i = j = 0

        while i < strlen and j < strlen:
            if s[j] in charSet:
                charSet.remove(s[i])
                i += 1
            else:
                charSet.add(s[j])
                j += 1
                maxLen = max(maxLen, j - i)
        return maxLen

str1 = "abcabcbb"
str2 = "bbbbb"
str3 = "pwwkew"

print(
    Solution().lengthOfLongestSubstring(str1),
    Solution().lengthOfLongestSubstring(str2),
    Solution().lengthOfLongestSubstring(str3)
)
