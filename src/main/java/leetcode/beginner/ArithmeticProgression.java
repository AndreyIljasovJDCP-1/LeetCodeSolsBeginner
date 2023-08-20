package leetcode.beginner;

import java.util.Arrays;

public class ArithmeticProgression {
  public static void main(String[] args) {
    System.out.println(canMakeArithmeticProgressionD(new int[] {2, 10, 7, 8, 3}));
  }

  public static boolean canMakeArithmeticProgression(int[] arr) {

    int n = arr.length;
    var statistic = Arrays.stream(arr).summaryStatistics();
    int min = statistic.getMin();
    int sum = (int) statistic.getSum();
    double d = 2.0 * (sum - min * n) / (n * n - n);
    System.out.println(d);
    return d % 1 == 0;
  }

  public static boolean canMakeArithmeticProgressionD(int[] arr) {


    Arrays.sort(arr);
    for (int i = 1; i < arr.length - 1; i++) {
      if (arr[i + 1] - arr[i] != arr[1] - arr[0]) return false;
    }

    return true;
  }
}
