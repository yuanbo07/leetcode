package main;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(123321));
        System.out.println(new Solution().isPalindrome(12321));
        System.out.println(new Solution().isPalindrome(123421));
        System.out.println(new Solution().isPalindrome(0));
        System.out.println(new Solution().isPalindrome(-212));
    }
}

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || 0 == x % 10) return false;
        int temp = 0;
        while (x > temp) {
            temp = temp * 10 + x % 10;
            x /= 10;
        }
        return (x == temp || x == temp / 10);
    }
}