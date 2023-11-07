package leetcode.beginner;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/word-pattern/">290. Word Pattern</a>
 */
public class WordPattern {
    public static void main(String[] args) {
        System.out.println(wordPatternArr("ccccccdd", " s s s s s s t t"));
    }

    public static boolean wordPattern1(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i = 0; i < words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }

    public static boolean wordPatternArr(String pattern, String s) {
        String[] sArr = s.split(" ");
        if (pattern.length() != sArr.length) return false;
        var map = new HashMap<>();
        for (Integer i = 0; i < pattern.length(); i++) {
            var indexChar = map.put(pattern.charAt(i), i);
            var indexWord = map.put(sArr[i], i);
            if (indexChar != indexWord) return false;
        }
        return true;
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] sArr = s.split(" ");
        if (pattern.length() != sArr.length) return false;
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = sArr[i];
            if (!map.containsKey(c)) {
                if (map.containsValue(word)) return false;
                map.put(c, word);
            } else if (!map.get(c).equals(word)) {
                return false;
            }
        }
        return true;
    }
}
