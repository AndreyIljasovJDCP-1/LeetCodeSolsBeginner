package leetcode.beginner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/summary-ranges/">228. Summary Ranges</a>
 */
public class SummaryRange {

    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0, 1, 2, 4, 5, 6}));
    }

    public static List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) return Collections.emptyList();
        String range = "";
        int start = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] != 1) {
                range = start == i ? nums[start] + "" : nums[start] + "->" + nums[i];
                list.add(range);
                start = i + 1;
            }
        }
        System.out.println(range);
        list.add(start == nums.length - 1
                ? nums[start] + ""
                : nums[start] + "->" + nums[nums.length - 1]
        );
        return list;
    }

    public List<String> summaryRangesBest(int[] nums) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            result.add(start == nums[i]
                    ? String.format("%d", start)
                    : String.format("%d->%d", start, nums[i]));
        }
        return result;
    }
}
