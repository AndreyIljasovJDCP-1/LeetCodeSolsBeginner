package leetcode;

public class MonotonicArray {
  public static void main(String[] args) {
    System.out.println(isMonotonic(new int[] {1, 3, 2}));
  }

  public static boolean isMonotonic(int[] nums) {
    int j = 0;
    int i = 0;
    while (i < nums.length - 1 && nums[i] <= nums[i + 1]) {
      i++;
    }
    while (j < nums.length - 1 && nums[j] >= nums[j + 1]) {
      j++;
    }

    System.out.println("i->" + i + " j->" + j);
    return i == nums.length - 1 || j == nums.length - 1 || j == i;
  }

  public boolean isMonotonic1(int[] nums) {
    boolean increasing = true;
    boolean decreasing = true;

    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] > nums[i + 1]) {
        increasing = false;
      }
      if (nums[i] < nums[i + 1]) {
        decreasing = false;
      }
    }

    return increasing || decreasing;
  }
}
