package leetcode.beginner;

public class OneUniqueInArrayXOR {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{3,3,3,3,3,3,3,3,3,8,3}));
    }
    public static int singleNumber(int[] nums) {
        int number = nums[0];
        for (int i = 1; i < nums.length; i++) {
            number ^= nums[i];
        }
        return number;
    }
}
