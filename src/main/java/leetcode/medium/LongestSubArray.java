package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @link <a href="https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/">
 *     1493. Longest Subarray of 1's After Deleting One Element </a>
 */
public class LongestSubArray {
    public static void main(String[] args) {

        System.out.println(longestSubarray(new int[] {0, 1, 1, 1, 0, 1, 0, 0, 0}));
    }
    // best
    public static int longestSubarray(int[] nums) {
        int n = nums.length;

        int left = 0;
        int zeros = 0;
        int ans = 0;

        for (int right = 0; right < n; right++) {
            if (nums[right] == 0) {
                zeros++;
            }
            while (zeros > 1) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1 - zeros);
        }
        return (ans == n) ? ans - 1 : ans;
    }
    // mine
    public static int longSub(int[] arr) {
        int length = 0;
        List<Integer> segments = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                segments.add(length);
                length = 0;
            } else if (i == arr.length - 1) {
                length++;
                segments.add(length);
            } else {
                length++;
            }
        }

        System.out.println(segments);
        if (segments.size() == 1) return arr.length - 1;
        int maxLen = -1;
        for (int i = 0; i < segments.size() - 1; i++) {

            maxLen = Math.max(maxLen, segments.get(i) + segments.get(i + 1));
        }
        return maxLen;
    }
}
