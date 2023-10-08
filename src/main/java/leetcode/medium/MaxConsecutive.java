package leetcode.medium;

/**
 * @link <a href="https://leetcode.com/problems/max-consecutive-ones-iii/description/?envType=study-plan-v2&envId=leetcode-75">
 *     1004. Max Consecutive Ones III</a>
 */
public class MaxConsecutive {

    public static void main(String[] args) {
        System.out.println(longestOnesTwoPointers1(new int[]{
                1, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 1));
    }

    public static int longestOnesTwoPointers1(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int zeros = 0;
        while (end < nums.length) {
            if (nums[end] == 0) zeros++;
            end++;
            if (zeros > k) {
                if (nums[start] == 0) zeros--;
                start++;
            }
        }
        return end-start;
    }

    public static int longestOnesTwoPointers(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int maxLength = -1;
        int zeros = 0;
        int length;
        while (end < nums.length) {
            if (nums[end] == 0) {
                if (zeros < k) {
                    zeros++;
                    end++;
                } else {
                    if (nums[start] == 0) zeros--;
                    start++;
                }
            } else {
                end++;
            }
            length = end - start;
            maxLength = Math.max(maxLength, length);
            System.out.println("max= " + maxLength + " current= " + length);
        }
        return maxLength;
    }

    public static int longestOnes(int[] nums, int k) {
        int i = 0;
        int maxLength = -1;
        while (i < nums.length) {
            int length = 0;
            int start = i;
            int flips = k;
            while (start < nums.length && (nums[start] == 1 || flips > 0)) {
                if (nums[start] == 0) flips--;
                start++;
                length++;
            }
            maxLength = Math.max(maxLength, length);
            i++;
        }

        return maxLength;
    }
}
