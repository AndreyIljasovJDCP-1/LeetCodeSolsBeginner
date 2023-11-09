package leetcode.medium;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">
 *     167. Two Sum II - Input Array Is Sorted</a>
 */
public class TwoSumII_167 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        System.out.println(Arrays.toString(numbers));
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            System.out.println("index left " + left + " right " + right);
            System.out.println(sum + "  = " + numbers[left] + " + " + numbers[right]);
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                System.out.println("Exact match");
                System.out.println(sum + "  = " + numbers[left] + " + " + numbers[right]);
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[]{};
    }
}
