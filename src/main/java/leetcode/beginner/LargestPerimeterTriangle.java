package leetcode.beginner;

import java.util.Arrays;

public class LargestPerimeterTriangle {
    public static void main(String[] args) {
        System.out.println(largestPerimeter(new int[]{2, 1, 2}));
    }

    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            int sumTwoSides = nums[i - 1] + nums[i];
            if (sumTwoSides > max) {
                return sumTwoSides + max;
            } else {
                max = nums[i];
            }
        }
        return 0;
    }
}
