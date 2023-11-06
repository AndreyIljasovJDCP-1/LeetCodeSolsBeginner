package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @link <a href="https://leetcode.com/problems/combinations/description/">
 *     77. Combinations</a>
 */
public class CombinationsSum {
    public static List<List<Integer>> RESULT = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(combinationSumArray(1, 1));
    }

    public static List<List<Integer>> combinationSumArray(int n, int k) {
        variants(1, k, n, new ArrayList<>());
        return RESULT;
    }

    private static void variants(int start, int k, int n , List<Integer> variant) {
        if (variant.size() > k) return;
        System.out.println("VARIANT: " + variant);
        if (variant.size() == k) {
            System.out.println("\nACCEPTED:" + variant + "\n");
            RESULT.add(new ArrayList<>(variant));
        }
        for (int i = start; i <= n; i++) {
            variant.add(i);
            variants(i + 1, k, n, variant);
            variant.remove(variant.size() - 1);
        }
    }
}
