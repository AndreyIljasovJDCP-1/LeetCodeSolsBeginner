package leetcode.beginner;

public class MaxAltitude1732 {
    public static void main(String[] args) {
        System.out.println(largestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2}));
    }

    public static int largestAltitude(int[] gain) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < gain.length; i++) {
            sum += gain[i];
            max = Math.max(sum, max);
        }
        return Math.max(0, max);
    }
}
