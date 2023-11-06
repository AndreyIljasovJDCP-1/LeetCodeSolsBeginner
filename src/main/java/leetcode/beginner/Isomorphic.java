package leetcode.beginner;

/**
 * <a href="https://leetcode.com/problems/isomorphic-strings/">205. Isomorphic Strings</a>
 */
public class Isomorphic {

    public static void main(String[] args) {

    }

    public static boolean isIsomorphic(String s, String t) {
        int[] number1 = new int[256]; // 256 character in Ascii
        int[] number2 = new int[256];

        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (number1[c1] != number2[c2]) {//check if s not point to the same value of t
                return false;
            }
            number1[c1] = i + 1;
            number2[c2] = i + 1;
        }
        return true;
    }
}
