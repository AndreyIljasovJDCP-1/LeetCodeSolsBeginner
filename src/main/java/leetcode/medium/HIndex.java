package leetcode.medium;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/h-index/">274. H-Index</a>
 */
public class HIndex {

    public static void main(String[] args) {
        //System.out.println(hIndex(new int[]{3, 0, 6, 1, 5}));
    }

    public int hIndex(int[] citations) {

        int left = 0;
        int right = citations.length;
        while (left < right) {
            int middle = left + (right + 1 - left) / 2;
            int count = 0;
            for (int citation : citations) {
                if (citation >= middle) count++;
            }
            if (count >= middle) {
                left = middle;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }

    public  int hIndexSorting(int[] citations) {

        Arrays.sort(citations);
        int n = citations.length;
        int i = 0;
        while (i < n && n - i > citations[i]) {
            i++;
        }
        return n - i;
    }
}
