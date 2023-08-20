package leetcode.beginner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Majority {
  public static void main(String[] args) {
    System.out.println(
        majorityElementSort(new int[] {1, 2, 1, 2, 2, 0, 0, 0, 2, 2, 5, 5, 5, 2, 2, 2}));
  }

  public static int majorityElementSort(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    return nums[n / 2];
  }

  public static int majorityElement(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.merge(num, 1, Integer::sum);
      if (map.get(num) > nums.length / 2) return num;
    }
    return -1;
  }

  /**
   * Moore Voting Algorithm
   *
   * @param nums
   * @return
   */
  public static int majorityElementMoore(int[] nums) {
    int count = 0;
    int candidate = 0;

    for (int num : nums) {
      if (count == 0) {
        candidate = num;
      }
      count = num == candidate ? count + 1 : count - 1;
    }

    return candidate;
  }
}
