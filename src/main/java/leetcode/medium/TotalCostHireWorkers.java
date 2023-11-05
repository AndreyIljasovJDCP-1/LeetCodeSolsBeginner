package leetcode.medium;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @link <a href="https://leetcode.com/problems/total-cost-to-hire-k-workers/description/?envType=study-plan-v2&envId=leetcode-75">
 * 2462. Total Cost to Hire K Workers</a>
 */
public class TotalCostHireWorkers {

    public static void main(String[] args) {
        System.out.println(totalCostQueue(new int[]{
                47, 48, 46, 63, 91, 56, 3, 55, 40, 93, 97, 37, 31, 31, 37,
                58, 41, 10, 74, 40, 17, 58, 58, 33, 78, 53, 88, 1, 15,
                44, 82, 74, 56, 41, 48, 96, 71, 35, 89, 57, 71, 34, 43, 4}, 35, 15));
        System.out.println(totalCostQueue(new int[]{2, 1, 2}, 1, 1));
    }

    public static long totalCostQueue(int[] costs, int k, int candidates) {
        if (k > costs.length) throw new IllegalArgumentException("too few workers to hire");
        Queue<Integer> first = new PriorityQueue<>();
        Queue<Integer> last = new PriorityQueue<>();
        int indexLast = costs.length - 1;
        int indexFirst = 0;
        int c = 0;
        while (c++ < candidates && indexFirst < indexLast) {
            first.offer(costs[indexFirst++]);
            last.offer(costs[indexLast--]);
        }
        if (indexFirst == indexLast && indexFirst < candidates) {
            first.offer(costs[indexFirst++]);
        }

        long total = 0L;

        while (k-- > 0) {
            if (indexFirst <= indexLast) {
                if (first.peek() <= last.peek()) {
                    total += first.poll();
                    first.offer(costs[indexFirst++]);
                } else {
                    total += last.poll();
                    last.offer(costs[indexLast--]);
                }
            } else {
                if (!first.isEmpty() && !last.isEmpty()) {
                    total += first.peek() <= last.peek() ? first.poll() : last.poll();
                } else {
                    total += first.isEmpty() ? last.poll() : first.poll();
                }
            }
            System.out.println("total= " + total);
        }
        return total;
    }

    public static long totalCost(int[] costs, int k, int candidates) {
        if (k > costs.length) throw new IllegalArgumentException("too few workers to hire");
        List<Integer> listCosts = Arrays.stream(costs).boxed().collect(Collectors.toList());
        long total = 0L;
        while (k > 0) {
            int size = listCosts.size();
            int min = Integer.MAX_VALUE;
            int indexMin = Integer.MAX_VALUE;
            int middle = (size & 1) == 0 ? size / 2 - 1 : size / 2;
            System.out.println("size " + size);
            System.out.println("middle " + middle);
            int limitCandidates = Math.min(candidates - 1, middle);
            System.out.println("candidates " + candidates);
            System.out.println("limitCandidates " + limitCandidates);
            System.out.println(listCosts);

            for (int i = 0; i <= limitCandidates; i++) {
                int first = listCosts.get(i);
                int last = listCosts.get(size - i - 1);
                int tempMinIndex = first <= last ? i : size - i - 1;
                int tempMin = Math.min(first, last);
                if (tempMin < min) {
                    min = tempMin;
                    indexMin = tempMinIndex;
                }
                //min = Math.min(min, Math.min(, listCosts.get(size- i -1)));
                System.out.println("index " + i + " indexLast " + (size - i - 1));
                System.out.println("tempMinIndex " + tempMinIndex + " indexMin " + indexMin);
            }
            System.out.println(min);
            total += min;
            listCosts.remove(indexMin);
            k--;
        }
        System.out.println("total = " + total);
        return total;
    }
}
