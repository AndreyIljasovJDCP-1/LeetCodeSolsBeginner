package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class SingleNumberII {
    //2ms
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        long sum = 0;
        for (int num : nums) sum += set.add(num) ? num * 2L : -num;
        return (int) (sum / 2);
    }
    // 1ms
    public int singleNumberBest(int[] nums) {
        int ones = 0, twos = 0;

        for (int num : nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }

        return ones;
    }
}
