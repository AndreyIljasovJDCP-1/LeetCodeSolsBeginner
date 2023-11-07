package leetcode.beginner;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/contains-duplicate-ii/description/">
 *     219. Contains Duplicate II
 *     </a>
 */
public class MapContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate1(
                new int[]{1, 2, 3, 1, 2, 3, 1, 0, 7, 0, 3}, 2));
    }

    public boolean containsNearbyDuplicateMap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer prevPos = map.put(nums[i], i);
            if (prevPos != null && i - prevPos <= k) {
                return true;
            }
        }
        return false;
    }
    // Мапа с массива с дубликатами с индексами в листе
    public static boolean containsNearbyDuplicate1(int[] nums, int k) {
    /*var map = IntStream.range(0, nums.length)
            .boxed()
            .collect(Collectors.groupingBy(i -> nums[i],
                    Collectors.mapping(i -> i, Collectors.toList())));*/
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.merge(nums[i], i,
                    (old, newValue) -> old == -1 ? -1
                            : Math.abs(old - newValue) <= k ? -1 : newValue);
            if (map.containsValue(-1)) return true;
        }
        System.out.println(map);
        return false;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; (j - i) <= k && j < nums.length; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }
}
