package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @link <a href="https://leetcode.com/problems/combination-sum-iii/description/?envType=study-plan-v2&envId=leetcode-75">
 *     216. Combination Sum III</a>
 */
public class CombinationSumIII {

    public static void main(String[] args) {
        System.out.println(combinationSumOpt(4, 20));
    }

    public static List<List<Integer>> combinationSumOpt(int k, int n) {
        if ((k * (k + 1) / 2) > n) return Collections.emptyList();
        List<Integer> variant = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        variantsOpt(1, 0, 0, variant, n, k, result);
        return result;
    }

    private static void variantsOpt(int start, int size, int sum, List<Integer> variant, int n, int k, List<List<Integer>> result) {
        if (sum > n) {
            return;
        }
        if (size == k) {
            System.out.println("VARIANT: " + variant);
            if (sum == n) {
                System.out.println("\nACCEPTED:" + variant +"\n");
                result.add(new ArrayList<>(variant));
            }
            return;
        }
        for (int i = start; i < 10; i++) {
            variant.add(i);
            variantsOpt(i + 1, size + 1, sum + i, variant, n, k, result);
            variant.remove(variant.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum(int k, int n) {
        if ((k * (k + 1) / 2) > n) return Collections.emptyList();
        List<Integer> variant = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            variant.add(0);
        }
        List<List<Integer>> result = new ArrayList<>();
        variants1(0, 0, variant, n, result);
        return result;
    }

    private static void variants1(int index, int start, List<Integer> variant, int n, List<List<Integer>> result) {
        if (index == variant.size()) {
            System.out.println("VARIANT: " + variant);
            int sum = variant.stream().mapToInt(i -> i).sum();
            if (sum == n) {
                System.out.println("ACCEPT: " + variant);

                result.add(new ArrayList<>(variant));
            }
        } else {
            for (int i = start + 1; i < 10; i++) {
                variant.set(index, i);
                variants1(index + 1, i, variant, n, result);
            }
        }
    }

}
