package leetcode.medium;

import java.util.Arrays;

/**
 * Given an integer array nums,
 * return true if there exists a triple of indices (i, j, k)
 * such that i < j < k and nums[i] < nums[j] < nums[k].
 * If no such indices exists, return false.
 */
public class IncreasingTripletSubsequence334 {

    public static void main(String[] args) {
        System.out.println(increasingTripletBest(new int[]{1, 5, 0, 4, 1, 3}));
    }
    public static boolean increasingTripletBest(int[] nums) {
        int min = Integer.MAX_VALUE, firstMin = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for(int num : nums){
            if(num <= min) min = num;
            else if(num < secondMin) { secondMin = num; firstMin = min; }
            else if(num > secondMin) {
                System.out.print(firstMin + " " + secondMin + " " + num);
                return true; }
        }
        return false;
    }
    public static boolean increasingTriplet(int[] nums) {
        var sumStats = Arrays.stream(nums).summaryStatistics();
        if (sumStats.getMax() - sumStats.getMin() < 2) return false;
        if (nums.length < 3) return false;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            while (j < nums.length - 1) {
                if (nums[j] > nums[i]) {
                    int k = j + 1;
                    while (k < nums.length) {
                        if (nums[k] > nums[j]) return true;
                        k++;
                    }
                }
                j++;
            }
        }
        return false;

    }
}
