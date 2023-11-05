package leetcode.medium;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class TotalCostHireWorkers {

    public static void main(String[] args) {
        System.out.println(totalCostQueue(new int[]{
                18,64,12,21,21,78,36,58,88,58,99,26,
                92,91,53,10,24,25,20,92,73,63,51,65,
                87,6,17,32,14,42,46,65,43,9,75}, 13, 23));
    }

    public static long totalCostQueue(int[] costs, int k, int candidates) {
        if (k > costs.length) throw new IllegalArgumentException("too few workers to hire");
        Queue<Integer> first = new PriorityQueue<>();
        Queue<Integer> last = new PriorityQueue<>();
        int indexLast = costs.length - 1;
        int indexFirst = 0;
        for (int i = 0; i < candidates; i++) {
            indexFirst = i;
            indexLast = costs.length - 1 - i;
            first.offer(costs[indexFirst]);
            last.offer(costs[indexLast]);
        }
        long total = 0L;
        while (k > 0 || (first.isEmpty() && last.isEmpty())) {
            if (first.peek() <= last.peek()) {
                total += first.poll();
                indexFirst++;
                if (indexFirst < indexLast) {
                    first.offer(costs[indexFirst]);
                }
            } else {
                total += last.poll();
                indexLast--;
                if (indexFirst < indexLast) {
                    last.offer(costs[indexLast]);
                }
            }
            k--;
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
