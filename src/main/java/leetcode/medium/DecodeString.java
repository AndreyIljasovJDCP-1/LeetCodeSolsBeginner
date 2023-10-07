package leetcode.medium;

/**
 * @link <a href="https://leetcode.com/problems/decode-string/?envType=study-plan-v2&envId=leetcode-75">
 *     DecodeString</a>
 */
public class DecodeString {
    public static int INDEX=0;
    public static void main(String[] args) {

        String sum = decodeString("3[a2[c]]");

        System.out.println(sum);
}

    public static String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        while (INDEX < s.length()) {
            char c = s.charAt(INDEX);
            INDEX++;
            if (c == '[') {
                sb.append(decodeString(s).repeat(count)); // recursion
                count = 0; // reset counter
            } else if (c == ']') { // exit recursion
                break;
            } else if (Character.isLetter(c)) {
                sb.append(c);
            } else {
                count = count * 10 + c - '0'; // calc count (mb 1-300)
            }
        }
        return sb.toString();
    }

    private static String extract(String str) {
        int koef=0;
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                koef = c - '0';
            } else if (Character.isLetter(c)) {
                result += c + "";
            } else if (c == '[') {
                extract(str.substring(i + 1));
            } else if (c == ']') {
                result+=result.repeat(koef);
                return result;
            }
        }
        return result;
    }
}
