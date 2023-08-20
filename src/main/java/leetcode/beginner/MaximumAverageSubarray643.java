package leetcode.beginner;

/**
 * You are given an integer array nums consisting of n elements, and an integer k.
 * Find a contiguous subarray whose length is equal to k
 * that has the maximum average value and return this value.
 * Any answer with a calculation error less than 10-5 will be accepted.
 */
public class MaximumAverageSubarray643 {
    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
    }

    public static double findMaxAverage(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                sum -= nums[i - k];
                sum += nums[i];
            } else {
                while (i < k) {
                    sum += nums[i];
                    i++;
                }
                i--;
            }
            max = Math.max(sum, max);
        }
        return 1.0 * max / k;
    }
}
