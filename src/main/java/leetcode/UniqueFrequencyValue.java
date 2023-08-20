package leetcode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 1207.
 * Given an array of integers arr,
 * return true if the number of occurrences
 * of each value in the array is unique or false otherwise.
 */
public class UniqueFrequencyValue {
    public static void main(String[] args) {
        System.out.println(uniqueOccurrences1(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}));
    }

    public static boolean uniqueOccurrences1(int[] arr) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int num : arr) {
            m.merge(num, 1, Integer::sum);
        }
        Set<Integer> set = new HashSet<>();
        for (int el : m.values()) {
            if (!set.add(el)) return false;
        }
        return true;
    }

    public static boolean uniqueOccurrences(int[] arr) {


        Map<Integer, Integer> m = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toMap(Function.identity(), i -> 1, Integer::sum));

        return m.size() == new HashSet<>(m.values()).size();
    }
}
