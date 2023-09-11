package leetcode.beginner;

import java.util.Arrays;

public class RemoveZeros {
  public static void main(String[] args) {
    removeZeros(new int[] {1, 2, 3, 0, 0, 0});
  }

  public static void removeZeros(int[] nums) {
    for (int i = 0, pointer = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        if (i > pointer) {
          nums[pointer] = nums[i];
          nums[i] = 0;
        }
        pointer++;
      }
    }
    System.out.println(Arrays.toString(nums));
  }
}
