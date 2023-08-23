package leetcode.medium;

import java.util.Set;

/**
 * Given a string s and an integer k,
 * return the maximum number of vowel letters in any substring of s with length k.
 * <p>
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 */
public class MaxVowelsSubs1456 {
    public static void main(String[] args) {
        System.out.println(maxVowelsN("ibpbhixfiouhdljnjfflpapptrxgcomvnb", 33));
    }

    public static int maxVowelsN(String s, int k) {
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
        int start = 0;
        int end = k;
        int count = 0;
        for (int i = start; i < k; i++) {
            if (set.contains(s.charAt(i))) count++;
        }
        System.out.println(count + " vowels");
        if (count == k) return k;
        int max = count;
        while (end < s.length()) {
            System.out.println(s.substring(start, end));

            char out = s.charAt(start++);
            char in = s.charAt(end++);
            System.out.println(out + " out");
            System.out.println(in + " in");
            if (set.contains(out)) count--;
            if (set.contains(in)) count++;
            if (count == k) return k;
            max = Math.max(max, count);
        }
        return max;
    }

    //TLE
    public static int maxVowels(String s, int k) {
        String VOWELS = "aeiouAEIOU";
        int start = 0;
        int max = -1;
        int end = k;

        while (end <= s.length()) {
            String sub = s.substring(start++, end++);
            System.out.println(sub);
            sub = sub.replaceAll("[aeiouAEIOU]", "");
            int count = 0;
            if (sub.isEmpty()) {
                return k;
            } else {
                count = k - sub.length();
            }
            System.out.println(sub);
            max = Math.max(count, max);
        }
        return max;
    }
}
