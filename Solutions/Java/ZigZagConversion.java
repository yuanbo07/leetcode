public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String convertedString = new Solution().convert("PAYPALISHIRING", 3);
        System.out.println(convertedString);
    }
}

class Solution {

    public String convert(String s, int numRows) {
        if (1 == numRows) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        int len = s.length();
        String[] newString = new String[numRows];

        for (int i = 0; i < numRows; i++) {
            newString[i] = "";
        }

        int currentRow = 0;
        boolean down = true;

        for (int i = 0; i < len; i++) {
            newString[currentRow] += s.charAt(i);
            if (currentRow == numRows - 1) {
                down = false;
            } else if (0 == currentRow) {
                down = true;
            }
            if (down) {
                currentRow++;
            } else {
                currentRow--;
            }
        }
        for (int i = 0; i < numRows; i++) {
            res.append(newString[i]);
        }
        return res.toString();
    }
}
