package leetcode.medium;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/successful-pairs-of-spells-and-potions/description/">
 *     2300. Successful Pairs of Spells and Potions</a>
 */
public class SpellsAndPotions_2300 {
    public static void main(String[] args) {
       /* System.out.println(Arrays.toString(successfulPairsOpt(
                new int[]{20,26,38,23,23,20,14,30},
                new int[]{24,1,7,26,19,17,7},
                510)));*/
        System.out.println(Arrays.toString(successfulPairs(
                new int[]{40, 11, 24},
                new int[]{31, 40, 29, 19, 27, 16, 25, 8, 33, 25, 36,
                        21, 7, 27, 40, 24, 18, 26, 32, 25, 22, 21, 38,
                        22, 37, 34, 15, 36, 21, 22, 37, 14, 31, 20, 36,
                        27, 28, 32, 21, 26, 33, 37, 27, 39, 19, 36, 20,
                        23, 25, 39, 40},
                600)));
    }

    public static int[] successfulPairsStream(int[] spells, int[] potions, long success) {

        return Arrays.stream(spells)
                .map(spell -> (int) Arrays.stream(potions)
                        .filter(potion -> (long) potion * spell >= success)
                        .count()
                ).toArray();

    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        System.out.println(Arrays.toString(potions));
        int[] res = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            System.out.println(" round " + (i + 1));
            int left = 0;
            int right = potions.length - 1;
            int middle = 0;
            boolean equals = false;
            while (left <= right) {
                middle = left + (right - left) / 2;
                long target = (long) potions[middle] * spells[i];
                System.out.printf("potions[%d] * spells[%d] = %d * %d  %d , middle %d%n",
                        middle, i, potions[middle], spells[i], target, middle);
                if (target > success) {
                    right = middle - 1;
                    System.out.printf("right= %d%n", right);
                } else if (target < success) {
                    left = middle + 1;
                    System.out.printf("left= %d%n", left);
                } else {
                    System.out.println("EQUALS");
                    System.out.printf("left= %d%n", left);
                    System.out.printf("right= %d%n ", right);
                    if (potions[middle] == potions[left]) middle = left;
                    equals = true;
                    break;
                }
            }
            res[i] = equals ? potions.length - middle : potions.length - left;
        }
        return res;
    }

    public static int[] successfulPairsOpt(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            //                           (1.0*success) is vital
            long least = (long) Math.ceil(1.0*success / spells[i]);
            int lo = 0;
            // m instead of m-1
            int hi = m;
            int mi;
            while(lo < hi) {
                mi = lo + (hi - lo) / 2;
                if(potions[mi] >= least) {
                    hi = mi;
                }else {
                    lo = mi+1;
                }
            }
            ans[i] = m-lo;
        }
        return ans;
    }
}
