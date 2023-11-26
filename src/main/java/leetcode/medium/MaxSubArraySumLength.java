package leetcode.medium;

/**
 * <a href="https://leetcode.com/problems/minimum-size-subarray-sum/description/">209. Minimum Size Subarray Sum</a>
 */
public class MaxSubArraySumLength {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(5, new int[]{2, 3, 1, 1, 1, 1, 1}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (right < nums.length) {
            while (sum < target && right < nums.length) {
                sum += nums[right];
                right++;
            }
            if (sum < target && left == 0) return 0;
            while (sum >= target && left < right) {
                sum -= nums[left];
                min = Math.min(min, right - left);
                left++;
            }
        }
        return min;
    }
}
