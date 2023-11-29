package leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * <a href="https://leetcode.com/problems/count-nice-pairs-in-an-array/description/">
 * 1814. Count Nice Pairs in an Array</a>
 */
public class NicePairs {

    public static void main(String[] args) {

        System.out.println(countNicePairs(new Random().ints(10, 0, 100).toArray()));
        System.out.println(countNicePairs(new int[]{1, 1, 1, 1, 1, 10, 10, 10, 10}));
    }

    public static int reverse(int[] nums) {
        Map<Integer, Long> map = new HashMap<>();
        long nice = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] - rev(nums[i]);
            if (map.containsKey(nums[i])) {
                long frequency = map.get(nums[i]);
                nice += frequency;
                map.put(nums[i], frequency + 1);
            } else {
                map.put(nums[i], 1L);
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(map);

        return (int) (nice % 1000000007);
    }

    public static int rev(int num) {
        if (num < 10) return num;
        int revNum = 0;
        while (num != 0) {
            int digit = num / 10;
            revNum = (revNum - digit) * 10 + num;
            num = digit;
        }
        return revNum;
    }

    public static int countNicePairs(int[] nums) {
        System.out.println(Arrays.toString(nums));
        int[] nums1 = nums.clone();
        System.out.println("Reverce = " + reverse(nums1));
        int nice = 0;
        for (int i = 0; i < nums.length; i++) {
            int revI = rev(nums[i]);
            for (int j = i + 1; j < nums.length; j++) {
                int revJ = rev(nums[j]);
                if (nums[i] < 10 && nums[j] < 10) {
                    nice++;
                    System.out.println(nice + " single number pair");
                    System.out.println(nums[i] + "= nums[i] " + " nums[j] = " + nums[j]);
                } else if (nums[i] + revJ == revI + nums[j]) {
                    nice++;
                    System.out.println(nice + " pair");
                    System.out.println(nums[i] + "= nums[i] " + " nums[j] = " + nums[j]);
                    System.out.println(" (nums[i] + revJ) == " + (nums[i] + revJ) + " (revI + nums[j]) == " + (revI + nums[j]));
                }
            }
        }
        return nice;
    }

}
