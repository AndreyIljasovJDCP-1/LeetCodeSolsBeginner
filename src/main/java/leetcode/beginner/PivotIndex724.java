package leetcode.beginner;

public class PivotIndex724 {
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }

    public static int pivotIndex(int[] nums) {
        int left = 0;

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (left == sum - nums[i] - left) return i;
            left += nums[i];
        }
        return -1;
    }
}
