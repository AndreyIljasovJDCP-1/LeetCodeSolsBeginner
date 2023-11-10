package leetcode.medium;

public class CombinationMaxSubScore_2542 {
    public static long MAX_SCORE = Integer.MIN_VALUE;

    public static void main(String[] args) {
        System.out.println(maxScore(
                new int[]{1,3,3,2},
                new int[]{2,1,3,4}, 2));
    }

    public static long maxScore(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0) return 0;
        variantsOpt(0, 0, 0, Integer.MAX_VALUE, nums1, nums2, k);
        return MAX_SCORE;
    }

    private static void variantsOpt(int start, int size, long sum, long min, int[] nums1, int[] nums2, int k) {
        if (size > k ) return;
        if (size == k) {
            long score = sum * min;
            System.out.println("MIN: " + min);
            System.out.println("SUM: " + sum);
            System.out.println("SCORE: " + score);
            MAX_SCORE = Math.max(MAX_SCORE, score);
            System.out.println("MAX_SCORE: " + MAX_SCORE);
            return;
        }

        for (int i = start; i < nums1.length; i++) {
            variantsOpt(i + 1, size + 1, sum + nums1[i], Math.min(min, nums2[i]), nums1, nums2, k);
        }

    }
}
