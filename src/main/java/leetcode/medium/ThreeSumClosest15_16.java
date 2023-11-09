package leetcode.medium;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/3sum/description/">15. 3Sum</a>
 * <a href="https://leetcode.com/problems/3sum-closest/description/">16. 3Sum Closest</a>
 */
public class ThreeSumClosest15_16 {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{0, 0, 0, 0}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if(i>0 && nums[i]==nums[i-1]) continue;
            System.out.println("index: i: " + i);
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                System.out.println("nums[" + i + "] nums[" + left + "] nums[" + right + "]");
                System.out.println(nums[i] + " + " + nums[left] + " + " + nums[right] + " = " + sum);

                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    System.out.println("Exact match");
                    System.out.println(sum + "  = " + nums[i] + "  " + nums[left] + "  " + nums[right]);
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }
            }
        }
        return result;
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int sum;
        int minSum = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            System.out.println("index: i: " + i);
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                System.out.println("nums[" + i + "] nums[" + left + "] nums[" + right + "]");
                System.out.println(nums[i] + " + " + nums[left] + " + " + nums[right] + " = " + sum);

                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    System.out.println("Exact match");
                    System.out.println(sum + "  = " + nums[i] + "  " + nums[left] + "  " + nums[right]);
                    return sum;
                }
                int diff = Math.abs(target - sum);
                System.out.println("sum: " + sum + " target: " + target + " difference: " + diff);
                if (diff < minDiff) {
                    minDiff = diff;
                    minSum = sum;
                }
            }
        }

        System.out.println("Min sum = " + minSum + " target = " + target + " minDiff = " + minDiff);
        return minSum;
    }
}
