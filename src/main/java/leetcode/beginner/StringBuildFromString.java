package leetcode.beginner;

import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/ransom-note/">383. Ransom Note</a>
 */
public class StringBuildFromString {
    public static void main(String[] args) {
        System.out.println(canConstructBest("rrreey","gggttrriyeer"));
    }
    public static boolean canConstructBest(String ransomNote, String magazine) {
        int[] indexMap = new int[26];

        for (char c : ransomNote.toCharArray()) {
            int sourceIndex = magazine.indexOf(c, indexMap[c - 'a']);

            if (sourceIndex == -1) {
                return false;
            }
            indexMap[c - 'a'] = sourceIndex + 1;
        }
        return true;
    }
    public static boolean canConstruct(String ransomNote, String magazine) {

        int[] letters = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            letters[magazine.charAt(i) - 97]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 97;
            if (letters[index] == 0) return false;
            letters[index]--;
        }
        return true;
    }

    public static boolean canConstructMap(String ransomNote, String magazine) {
        var magazineMap = magazine.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(c -> c, c -> 1, Integer::sum));
        for (int i = 0; i < ransomNote.length(); i++) {
            var index = ransomNote.charAt(i);
            if (magazineMap.get(index) == null || magazineMap.get(index) == 0) return false;
            magazineMap.merge(index, 1, (old, value) -> old - 1);
        }
        return true;
    }
}
