package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @link <a href="https://leetcode.com/problems/combination-sum/description/">
 *     39. Combination Sum</a>
 * */
public class CombinationsSumI {
    public static void main(String[] args) {
        System.out.println(combinationSumArray(new int[]{2, 3, 6, 7}, 7));
    }

    public static List<List<Integer>> combinationSumArray(int[] candidates, int n) {
        if (candidates.length == 0) return Collections.emptyList();
        List<Integer> variant = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        variants(0, 0, candidates, variant, n, result);
        return result;
    }

    private static void variants(int start, int sum, int[] candidates, List<Integer> variant, int n, List<List<Integer>> result) {
        if (sum > n) {
            return;
        }
        System.out.println("VARIANT: " + variant);
        if (sum == n) {
            System.out.println("\nACCEPTED:" + variant + "\n");
            result.add(new ArrayList<>(variant));
        }
        for (int i = start; i < candidates.length; i++) {
            variant.add(candidates[i]);
            variants(i, sum + candidates[i], candidates, variant, n, result);
            variant.remove(variant.size() - 1);
        }
    }
}
