package leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class LongestSubsWithoutRepeatedSymbols3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringMap("abcdecfghqc"));
    }

    public static int lengthOfLongestSubstringMap(String s) {
        if (s.isEmpty()) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int first = 0;
        int last = 0;
        int maxLength = -1;
        while (last < s.length()) {
            if (map.containsKey(s.charAt(last))) {
                first = Math.max(map.get(s.charAt(last)) + 1, first);
            }
            map.put(s.charAt(last), last);
            System.out.println(map);
            maxLength = Math.max(last - first + 1, maxLength);
            last++;
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        Set<Character> set = new TreeSet<>();
        int start = 0;
        int end = s.length();
        int maxLength = -1;
        while (start <= end) {
            for (int i = start; i < end; i++) {
                boolean unique = true;
                for (int j = i; j < end; j++) {
                    if (!set.add(s.charAt(j))) {
                        unique = false;
                        break;
                    }
                }
                System.out.println(set);
                if (unique) {
                    maxLength = Math.max(set.size(), maxLength);
                }
                set.clear();
            }
            end--;
        }
        return maxLength;
    }

    private static String rec(String s, int first, int last, int offset) {

        String sub = s.substring(first, last);
        System.out.println(sub);
        if (sub.length() < 2) return null;
        StringBuilder sb = new StringBuilder(sub);
        if (sb.reverse().toString().equals(sub)) {
            return sub;
        }
        String fRes = rec(s, first + 1, last, offset + 1);
        if (fRes == null) {
            return rec(s, first, last - 1, offset + 1);
        } else return fRes;
    }
}
