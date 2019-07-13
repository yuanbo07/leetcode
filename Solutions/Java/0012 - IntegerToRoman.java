public class Main {

    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(3999));
    }

    static class Solution {

        String intToRoman(int num) {
            String[][] m =
                    {
                            {"", "M", "MM", "MMM"},
                            {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                            {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                            {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}
                    };

            int[] d = {1000, 100, 10, 1};

            String result = "";
            int i = 0;
            for (int v : d) {
                result += m[i++][num / v];
                num %= v;
            }
            return result;
        }
    }
}

