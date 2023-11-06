package leetcode.medium;

import java.util.*;

/**
 * @link <a href="https://leetcode.com/problems/combination-sum-ii/description/">
 *     40. Combination Sum II</a>
 */
public class CombinationsSumII {
    public static void main(String[] args) {
        System.out.println(combinationSumDistinctArray(new int[]{
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, 30));
        System.out.println(combinationSumDistinctArray(new int[]{
                10,1,2,7,6,1,5}, 8));
    }

    public static List<List<Integer>> combinationSumDistinctArray(int[] candidates, int n) {
        if (candidates.length == 0) return Collections.emptyList();
        List<Integer> variant = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
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
            return;
        }
        int prev =-1;
        for (int i = start; i < candidates.length; i++) {
            if(prev == candidates[i]) continue;
            variant.add(candidates[i]);
            variants(i + 1, sum + candidates[i], candidates, variant, n, result);
            prev = variant.remove(variant.size() - 1);
        }
    }
}
