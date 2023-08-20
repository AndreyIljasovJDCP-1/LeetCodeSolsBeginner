package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseWordsString {

    public static void main(String[] args) {
        System.out.println(reverseWordsRegex("EPYgiL"));
    }

    public static String reverseWordsRegex(String s) {
        Pattern pattern = Pattern.compile("(?=^|\\s)(\\p{Alnum}+)(?<=\\s|$)");
        Matcher matcher = pattern.matcher(s);
        String res = "";
        while (matcher.find()) {
            res = matcher.group() + " " + res;
        }
        return res.trim();
    }

    public static String reverseWordsReverse(String s) {
        String res = "";
        String total = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                res = s.charAt(i) + res;
                if (i == 0) {
                    return (total + " " + res).trim();
                }
            } else {
                if (res.length() > 0) {
                    total = total + " " + res;
                    res = "";
                }
            }
        }
        return total.trim();
    }

    public static String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        StringBuilder total = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                res.append(s.charAt(i));
                if (i == s.length() - 1) {
                    return total.insert(0, res).toString();
                }
            } else {
                if (res.length() > 0) {
                    total.insert(0, " " + res);
                    res = new StringBuilder();
                }
            }
        }
        return total.toString().trim();
    }

    public static String reverseWordsStack(String s) {
        Stack<String> stack = new Stack<>();
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                res += s.charAt(i);
                if (i == s.length() - 1) stack.push(res);
            } else if (!res.isEmpty()) {
                stack.push(res);
                res = "";
            }
        }
        res = "";
        while (!stack.empty()) {
            res += stack.pop() + " ";
        }
        return res.trim();
    }

    public static String reverseWordsList(String s) {
        List<String> list = new ArrayList<>();
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                res += s.charAt(i);
                if (i == s.length() - 1) list.add(0, res);
            } else if (!res.isEmpty()) {
                list.add(0, res);
                res = "";
            }
        }
        return String.join(" ", list);
    }

    public static String reverseWordsStream(String s) {
        String[] arr = s.split("\\s+");
        return IntStream.iterate(arr.length - 1, x -> x >= 0, x -> x - 1)
                .mapToObj(i -> arr[i])
                .filter(word -> !word.isEmpty())
                .collect(Collectors.joining(" "));
    }

    public String reverseWords1(String s) {
        String[] words = s.trim().split("\\s+");
        String res = "";
        for (int i = words.length - 1; i > 0; i--) {
            res += words[i] + " ";
        }
        return res+words[0];
    }

}
