package leetcode.medium;

import java.util.Arrays;

public class ProductArrayExceptSelf238 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }
    public static int[] productExceptSelfDivisionFree(int[] nums) {
        long product = Arrays.stream(nums)
                .filter(x -> x != 0)
                .reduce(1, (x, y) -> x * y);
        int zero = 0;
        for (int num : nums) {
            if (num == 0) zero++;
            if (zero > 1) break;
        }
        System.out.println(zero);
        if (zero > 1) {
            Arrays.fill(nums, 0);
            return nums;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = zero == 0
                    ? (int) (product / nums[i])
                    : (int) (nums[i] == 0
                    ? product
                    : 0);
        }
        return nums;
    }
    public static int[] productExceptSelf(int[] nums) {
        long product = Arrays.stream(nums)
                .filter(x -> x != 0)
                .reduce(1, (x, y) -> x * y);
        int zero = 0;
        for (int num : nums) {
            if (num == 0) zero++;
            if (zero > 1) break;
        }
        System.out.println(zero);
        if (zero > 1) {
            Arrays.fill(nums, 0);
            return nums;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = zero == 0
                    ? (int) (product / nums[i])
                    : (int) (nums[i] == 0
                    ? product
                    : 0);
        }
        return nums;
    }
}
