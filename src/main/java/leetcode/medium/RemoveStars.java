package leetcode.medium;

import java.util.Stack;

/**
 * @link <a href="https://leetcode.com/problems/removing-stars-from-a-string/?envType=study-plan-v2&envId=leetcode-75">
 *     2390. Removing Stars From a String</a>
 */
public class RemoveStars {

    public static void main(String[] args) {
        System.out.println(removeStars4("**********aaaaaabbbbbb***n**ffffggggg**"));
    }

    public static String removeStars(String s) {
        int countStars = (int) s.chars().filter(c -> c == '*').count();
        if (countStars >= s.length()) {
            return "";
        } else if (countStars == 0) {
            return s;
        }
        while (s.contains("*")) {
            int indexStar = s.indexOf("*");
            if (indexStar == -1) return s;
            int lengthStar;
            int i = indexStar;
            while (i + 1 < s.length() && s.charAt(i + 1) == '*') {
                i++;
            }
            lengthStar = i - indexStar + 1;
            System.out.println("lengthStar: " + lengthStar);
            s = indexStar - lengthStar < 0
                    ? s.substring(indexStar + lengthStar)
                    : s.substring(0, indexStar - lengthStar) + s.substring(indexStar + lengthStar);
        }
        return s;
    }
    //my
    public static String removeStars2(String s) {
        if (!s.contains("*")) return s;
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else {
                stack.push(s.charAt(i) + "");
            }
        }
        return String.join("", stack);
    }

    public static String removeStars3(String s) {
        char[] arr = s.toCharArray();
        int ind = 0;

        for (int i = 0; i < s.length(); i++) {
            if (arr[i] == '*') {
                ind--;
            } else {
                arr[ind] = arr[i];
                ind++;
            }
        }

        return new String(arr, 0, ind);
    }

    public static String removeStars4(String str) {
        StringBuilder sb = new StringBuilder();
        for (int s = 0; s < str.length(); s++)
            if (str.charAt(s) == '*')
                sb.deleteCharAt(sb.length() - 1);
            else
                sb.append(str.charAt(s));
        return sb.toString();
    }
}
