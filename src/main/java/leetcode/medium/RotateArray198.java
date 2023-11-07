package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/rotate-array/description/">189. Rotate Array</a>
 */
public class RotateArray198 {
    public static void main(String[] args) {

        rotate2(new int[]{1, 2, 3, 4, 5, 6, 7}, 2);
    }

    public static void rotate2(int[] nums, int k) {

        int[] temp = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            temp[(i+k)%nums.length] = nums[i];
        }
        System.arraycopy(temp, 0, nums, 0, nums.length);
    }

    public static void rotate1(int[] nums, int k) {

        if (nums.length < 2) return;
        k = k % nums.length;
        System.out.println(k);
        for (int j = 0; j < k; j++) {
            int last = nums[nums.length - 1];
            System.arraycopy(nums, 0, nums, 1, nums.length - 1);
            nums[0] = last;
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        if (nums.length < 2) return;
        k = k % nums.length == 0 ? 0 : k % nums.length;
        System.out.println(k);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length - k; i++) {
            deque.offerLast(nums[i]);
        }
        for (int i = nums.length - 1; i >= nums.length - k; i--) {
            deque.offerFirst(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = deque.poll();
        }
        System.out.println(Arrays.toString(nums));
    }
}
