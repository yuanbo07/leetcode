package main;

public class Main {

    public static void main(String[] args) {
        String str1 = "42";
        String str2 = "   -42";
        String str3 = "4193 with words";
        String str4 = "words and 987";
        String str5 = "-91283472332";
        String str6 = "   +   ";
        String str7 = " ";
        Solution s = new Solution();
        System.out.println(s.myAtoi(str1));
        System.out.println(s.myAtoi(str2));
        System.out.println(s.myAtoi(str3));
        System.out.println(s.myAtoi(str4));
        System.out.println(s.myAtoi(str5));
        System.out.println(s.myAtoi(str6));
        System.out.println(s.myAtoi(str7));
    }
}

class Solution {
    public int myAtoi(String str) {
        if (null == str || str.trim().length() == 0) {
            return 0;
        }
        int startingIndex = 0;
        boolean isPositive = true;
        String first = str.trim().split(" ")[0];
        char firstChar = first.charAt(0);
        if (!Character.isDigit(firstChar)) {
            if (first.length() >= 2 && !Character.isDigit(first.charAt(1)) || first.length() == 1) {
                return 0;
            }
            if (firstChar == '+') {
                startingIndex++;
            } else if (firstChar == '-') {
                isPositive = false;
                startingIndex++;
            } else {
                return 0;
            }
        }
        int num = 0;
        for (int i = startingIndex; i < first.length(); i++) {
            if (!Character.isDigit(first.charAt(i))) {
                return num;
            }
            int intAtI = Character.getNumericValue(first.charAt(i));
            if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && intAtI >= 7)) {
                return Integer.MAX_VALUE;
            }
            if (num < Integer.MIN_VALUE / 10 || (num == Integer.MIN_VALUE / 10 && intAtI >= 8)) {
                return Integer.MIN_VALUE;
            }
            num = num * 10 + (isPositive ? 1 : -1) * intAtI;
        }
        return num;
    }
}