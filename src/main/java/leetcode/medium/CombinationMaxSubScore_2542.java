package leetcode.medium;

import java.util.*;

public class CombinationMaxSubScore_2542 {
    public static long MAX_SCORE = Integer.MIN_VALUE;

    public static void main(String[] args) {
        System.out.println(maxScoreMatrixQueuePairs(
                new int[]{44,10,25,0,25,49,0},
                new int[]{18,39,15,31,43,20,45}, 6));
        /*System.out.println(maxScoreMatrixQueuePairs(
                new int[]{2, 1, 14, 12},
                new int[]{11, 7, 13, 6}, 3));*/
       /* System.out.println(maxScoreMatrixQueuePairs(
                new int[]{1, 3, 3, 2},
                new int[]{2, 1, 3, 4}, 3));*/
    }

    public static long maxScoreMatrixQueuePairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0) return 0;
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] ints1, int[] ints2) {
                if (ints1[1] == 0 ||ints2[1] == 0) return 1;
                return ints2[0] * ints2[1] - ints1[0] * ints1[1];
            }
        });
        for (int i = 0; i < nums1.length; i++) {
            queue.add(new int[]{nums1[i], nums2[i]});
        }
        queue.forEach(s -> System.out.println(Arrays.toString(s)));
        long sum = 0;
        long min = Integer.MAX_VALUE;
        long maxScore = Integer.MIN_VALUE;
        int i = 0;
        Deque<int[]> sub = new ArrayDeque<>();
        while (i < k && !queue.isEmpty()) {
            int[] next = queue.poll();
            sum += next[0];
            min = Math.min(min, next[1]);
            i++;
            sub.offer(next);
        }

        System.out.println("before");
        sub.forEach(s -> System.out.println(Arrays.toString(s)));
        maxScore = sum * min;
        System.out.println(maxScore);

        for (int j = k; j < nums1.length && !queue.isEmpty() && !sub.isEmpty(); j++) {
            int[] next = queue.poll();
            int[] prev = sub.pollLast();
            System.out.println("next " + Arrays.toString(next));
            System.out.println("prev " + Arrays.toString(prev));
            min = Math.min(sub.stream().min(Comparator.comparingInt(s -> s[1])).get()[1], next[1]);
            System.out.println("min " + min);
            sum = sum - prev[0] + next[0];
            System.out.println("sum " + sum);
            if (sum * min > maxScore) {
                maxScore = sum * min;
                sub.offerLast(next);
            } else {
                sub.offerLast(prev);
                sum = sum + prev[0] - next[0];
            }

        }
        System.out.println("after");
        sub.forEach(s -> System.out.println(Arrays.toString(s)));
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
        nextMin = Integer.MAX_VALUE;
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
