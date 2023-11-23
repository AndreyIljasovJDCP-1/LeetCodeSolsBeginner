package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/maximum-subsequence-score/description/">
 *     2542. Maximum Subsequence Score</a>
 */
public class CombinationMaxSubScore {
    public static long MAX_SCORE = Integer.MIN_VALUE;

    public long maxScoreMatrixQueuePairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0) return 0;
        long sum = 0;
        long maxScore = 0;
        int[][] matrix = new int[nums1.length][2];
        Queue<Integer> topSum = new PriorityQueue<>(Comparator.comparingInt(o -> o));

        for (int i = 0; i < nums1.length; i++) {
            matrix[i] = new int[]{nums2[i], nums1[i]};
        }

        Arrays.sort(matrix, (o1, o2) -> o2[0] - o1[0]);

        for (int[] pair : matrix) {
            topSum.add(pair[1]);
            sum += pair[1];
            if (topSum.size() > k) {
                sum -= topSum.poll();
            }
            if (topSum.size() == k) {
                maxScore = Math.max(maxScore, sum * pair[0]);
            }
        }
        return maxScore;
    }

    public static long maxScoreLast(int[] nums1, int[] nums2, int k) {
        int[][] matrix = new int[nums1.length][2];
        //Queue<int[]> pairs = new PriorityQueue<>(Comparator.comparingInt(ints->ints[1]));
        boolean[] used = new boolean[nums1.length];
        Queue<int[]> pairs = new PriorityQueue<>((o1, o2) -> o2[1] == o1[1] ? o2[0] - o1[0] : o1[1] - o2[1]);
        for (int i = 0; i < nums1.length; i++) {
            int sum = nums1[i];
            int min = nums2[i];
            matrix[i][0] = sum;
            matrix[i][1] = min;
            pairs.add(new int[]{sum, min});
        }
        Arrays.sort(matrix, (o1, o2) -> o2[0] == o1[0] ? o2[1] - o1[1] : o2[0] - o1[0]);

        System.out.printf("Sorted matrix by sum Descending order : %s%n", Arrays.deepToString(matrix));

        long maxScore = Integer.MIN_VALUE;

        while (!pairs.isEmpty()) {
            int[] pair = pairs.poll();
            System.out.printf("MIN PAIR FROM QUEUE by min Ascending order : %s%n", Arrays.toString(pair));
            long min = pair[1];
            long sum = pair[0];
            System.out.println(" START SUM: " + sum);
            System.out.println(" START MIN: " + min);
            int skipped = 0;
            int add = 0;
            int i = 0;
            //boolean unique = true;
            while (i < nums1.length && add < k - 1) {
                System.out.printf("MAX PAIR FROM matrix[%d]: %s%n", i, Arrays.toString(matrix[i]));
                if (!used[i]) {
                    if (Arrays.equals(matrix[i], pair)) {
                        //unique = false;
                        used[i] = true;
                        System.out.printf("Skip index = %d  equals to MIN PAIR %s%n", i, Arrays.toString(pair));
                    } else if (matrix[i][1] >= min) {
                        sum += matrix[i][0];
                        add++;
                        System.out.printf("Add to sum %d%n", matrix[i][0]);
                    }
                } else {
                    skipped++;
                    System.out.printf("Skip MAX PAIR matrix[%d]: %s . already used = %b skipped = %d%n ", i, Arrays.toString(matrix[i]), used[i], skipped);
                }
                i++;

            }
            System.out.printf("I = %d%n ", i);
            System.out.printf("elements for %d-long subsequence. Added: %d%n", k, add);
            if (add + 1 == k) {
                System.out.printf("(SUM * MIN) %d * %d = %d%n", sum, min, sum * min);
                System.out.printf("MAX SCORE = %d%n", maxScore);
                maxScore = Math.max(sum * min, maxScore);
                System.out.printf("MAX SCORE NEW = %d%n", maxScore);
            } else {
                System.out.printf("Not enough elements for %d-long subsequence. Added: %d%n", k, add);
            }
        }
        return maxScore;
    }

    public static long maxScore(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0) return 0;
        variantsOpt(0, 0, 0, Integer.MAX_VALUE, nums1, nums2, k);
        return MAX_SCORE;
    }

    private static void variantsOpt(int start, int size, long sum, long min, int[] nums1, int[] nums2, int k) {
        if (size > k) return;
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

    public static long maxScoreMatrix2Sort(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0) return 0;
        int[][] matrix = new int[nums1.length][2];
        Queue<Integer> minQueue = new PriorityQueue<>();
        for (int i = 0; i < nums1.length; i++) {
            matrix[i][0] = nums1[i];
            matrix[i][1] = nums2[i];
        }
        Arrays.sort(matrix, (n1, n2) -> n2[0] != n1[0] ? n2[0] - n1[0] : n2[1] - n1[1]);//by sum then by min
        System.out.println(Arrays.deepToString(matrix));
        long sum = 0;
        long min;
        for (int i = 0; i < k; i++) {
            sum += matrix[i][0];
            minQueue.add(matrix[i][1]);
        }
        System.out.println(minQueue);
        System.out.println(sum + " sum start");
        System.out.println(minQueue.peek() + " min start");
        long nextSum = sum;
        long nextMin;
        long maxScore = minQueue.peek() * sum;
        System.out.println(maxScore + " maxScore start");
        for (int i = 0; i < nums1.length - k; i++) {
            minQueue.clear();
            nextSum = nextSum - matrix[i][0] + matrix[i + k][0];
            for (int j = i + 1; j <= i + k; j++) minQueue.add(matrix[j][1]);
            System.out.println(minQueue + " minQueue");
            nextMin = minQueue.peek();
            System.out.println(nextSum + " nextSum");
            System.out.println(nextMin + " nextMin");
            if (nextSum > sum) {
                sum = nextSum;
                min = nextMin;
                maxScore = Math.max(maxScore, sum * min);
                System.out.println(maxScore + " maxScore");
            }
        }
        Arrays.sort(matrix, (n1, n2) -> n2[1] != n1[1] ? n2[1] - n1[1] : n2[0] - n1[0]);//by min then by sum
        System.out.println(Arrays.deepToString(matrix));
        sum = 0;
        for (int i = 0; i < k; i++) sum += matrix[i][0];
        min = matrix[k - 1][1];
        System.out.println(sum + " sum start");
        System.out.println(min + " min start");
        nextSum = sum;
        maxScore = Math.max(maxScore, min * sum);
        System.out.println(maxScore + " maxScore start");
        for (int i = 0; i < nums1.length - k; i++) {
            nextSum = nextSum - matrix[i][0] + matrix[i + k][0];
            nextMin = matrix[i + k][1];
            System.out.println(nextSum + " nextSum");
            System.out.println(nextMin + " nextMin");
            if (nextSum > sum) {
                sum = nextSum;
                min = nextMin;
                maxScore = Math.max(maxScore, sum * min);
                System.out.println(maxScore + " maxScore");
            }
        }
        return maxScore;
    }

    public static long maxScoreMatrix(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0) return 0;
        int[][] matrix = new int[nums1.length][2];
        for (int i = 0; i < nums1.length; i++) {
            matrix[i][0] = nums1[i];
            matrix[i][1] = nums2[i];
        }
        Arrays.sort(matrix, (n1, n2) -> n2[0] != n1[0] ? n2[0] - n1[0] : n2[1] - n1[1]);//by sum then by min
        System.out.println(Arrays.deepToString(matrix));
        long sum = 0;
        //long min = matrix[k - 1][1];
        long min = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            sum += matrix[i][0];
            min = Math.min(min, matrix[i][1]);
        }
        System.out.println(sum + " sum start");
        System.out.println(min + " min start");
        long nextSum = sum;
        long nextMin;
        long maxScore = min * sum;
        System.out.println(maxScore + " maxScore start");
        for (int i = 0; i < nums1.length - k; i++) {
            nextSum = nextSum - matrix[i][0] + matrix[i + k][0];
            //nextMin = matrix[i + k][1];
            nextMin = Math.min(min, matrix[i + k][1]);
            System.out.println(nextSum + " nextSum");
            System.out.println(nextMin + " nextMin");
            if (nextSum > sum) {
                sum = nextSum;
                min = nextMin;
                maxScore = Math.max(maxScore, sum * min);
                System.out.println(maxScore + " maxScore");
            }
        }

        return maxScore;
    }


}
