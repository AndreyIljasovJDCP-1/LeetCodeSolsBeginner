package leetcode.medium;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/">
 * 26. Remove Duplicates from Sorted Array</a>
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/">
 * 80. Remove Duplicates from Sorted Array II</a>
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        System.out.println(removeTwoDuplicates(new int[]{1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3}));
    }

    public static int removeTwoDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int index = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[index - 2]) nums[index++] = nums[i];
        }
        System.out.println(Arrays.toString(nums));
        return index;
    }

    public static int removeOneDuplicates(int[] nums) {
        int duplicates = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[duplicates] != nums[i]) nums[++duplicates] = nums[i];
        }
        System.out.println(Arrays.toString(nums));
        return duplicates + 1;
    }

    public static int removeDuplicatesOne(int[] nums) {
        var uniqueArr = Arrays.stream(nums).distinct().toArray();
        System.out.println(uniqueArr.length);
        var k = uniqueArr.length;
        System.arraycopy(uniqueArr, 0, nums, 0, uniqueArr.length);
        System.out.println(Arrays.toString(nums));
        return k;
    }
}
