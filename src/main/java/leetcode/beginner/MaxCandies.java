package leetcode.beginner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxCandies {

    public static void main(String[] args) {
        System.out.println(kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> res = new ArrayList<>();
        int max = Arrays.stream(candies).max().getAsInt();
        for (int candy : candies) {
            res.add(candy + extraCandies >= max);
        }
        return res;
    }
}
