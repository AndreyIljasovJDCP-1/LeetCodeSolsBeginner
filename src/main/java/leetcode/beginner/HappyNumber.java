package leetcode.beginner;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/happy-number/description/">202. Happy Number</a>
 */
public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }

    public static boolean isHappy(int n) {
        return rec(n, new HashSet<>());
    }

    private static boolean rec(int n, Set<Integer> memo) {
        if (n == 1 || n == 7) return true;
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        if (!memo.add(sum)) return false;

        return rec(sum, memo);
    }
}
