package leetcode.beginner;

import java.util.Random;

public class GuessNumber374 {
    public static void main(String[] args) {

    }

    private static int guess(int num) {

        return new Random().nextInt(-1, 2);
    }

    public static int guessNumber(int n) {
        int first = 1;
        int last = n;
        while (first <= last) {
            int mid = first + (last - first) / 2;
            int answer = guess(mid);
            if (answer == 0) {
                return mid;
            } else if (answer == -1) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }
        }
        return -1;
    }
}
