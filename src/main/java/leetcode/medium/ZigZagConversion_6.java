package leetcode.medium;

/**
 * <a href="https://leetcode.com/problems/zigzag-conversion/description/">6. Zigzag Conversion</a>
 */
public class ZigZagConversion_6 {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",3));
    }

    public static String convert(String s, int numRows) {
        return encodeBest(s,numRows);
    }

    public static String encodeBest(String s, int n) {
        return process(s, n, true);
    }

    public static String decodeBest(String s, int n) {
        return process(s, n, false);
    }

    private static String process(String s, int n, boolean enc) {
        int len = s.length();
        int step = n * 2 - 2;
        StringBuilder sb = new StringBuilder(s);
        int counter = 0;
        for (int i = 0; i < n; i++) {
            int next = i == n - 1 ? step : step - i * 2;
            int index = i;

            while (index < len) {
                sb.setCharAt((enc ? counter++ : index), s.charAt(enc ? index : counter++));
                index += next;
                next = (next == step ? step : step - next);
            }
        }

        return sb.toString();
    }
}
