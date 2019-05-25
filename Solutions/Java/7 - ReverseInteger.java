public class Main {

    public static void main(String[] args) {
    	// test overflow case
        int reversedInt = new Solution().reverse(-2147483648);
        System.out.println(reversedInt);
    }
}

// solution which actually overflows 1 time
class Solution {
    public int reverse(int x) {
        int reversedInt = 0;
        while (0 != x) {
            int temp = reversedInt * 10 + x % 10;
            // if it overflows, number will change sign and this is no longer true
            if (temp / 10 != reversedInt)
                return 0;
            reversedInt = temp;
            x /= 10;
        }
        return reversedInt;
    }
}

// solution that does not overflow
class Solution2 {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
