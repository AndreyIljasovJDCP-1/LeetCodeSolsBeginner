package leetcode.medium;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CloseStrings {

    public static void main(String[] args) {
        System.out.println(closeStrings("aaabc","bbbac"));
    }

    /**
     * @link <a href="https://leetcode.com/problems/determine-if-two-strings-are-close/description/?envType=study-plan-v2&envId=leetcode-75">...</a>
     * @param word1
     * @param word2
     * @return
     */
    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        var set1 = Arrays.stream(word1.split("")).collect(Collectors.toSet());
        var set2 = Arrays.stream(word2.split("")).collect(Collectors.toSet());
        System.out.println(set1);
        System.out.println(set2);
        if (set1.containsAll(set2)) {
            var map1 = Arrays.stream(word1.split("")).collect(Collectors.toMap(Function.identity(), s -> 1, Integer::sum));
            var map2 = Arrays.stream(word2.split("")).collect(Collectors.toMap(Function.identity(), s -> 1, Integer::sum));
            System.out.println(map1);
            System.out.println(map2);
            var values1 = map1.values().stream().sorted().toList();
            var values2 = map2.values().stream().sorted().toList();
            System.out.println(values1);
            System.out.println(values2);
            return values1.equals(values2);
        }
        return false;
    }
}
