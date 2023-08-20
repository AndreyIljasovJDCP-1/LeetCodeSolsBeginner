package leetcode.beginner;

public class ArraysSum {
  public static void main(String[] args) {
    System.out.println(
        diagonalSum(
            new int[][] {
              {1, 1, 1, 1},
              {1, 1, 1, 1},
              {1, 1, 1, 1},
              {1, 1, 1, 1}
            }));
  }

  public static int arraySign(int[] nums) {
    int negatives = 0;
    for (int num : nums) {
      if (num == 0) return 0;
      if (num < 0) negatives++;
    }
    return (negatives & 1) == 1 ? -1 : 1;
  }

  public static int diagonalSum(int[][] mat) {
    int sum = 0;
    int length = mat.length;
    for (int i = 0; i < length; i++) {
      for (int j = i; j == i; j++) {
        sum += mat[i][j];
        sum += (mat[length - 1 - i][j]);
      }
    }
    if ((length & 1) == 1) sum -= mat[length / 2][length / 2];
    return sum;
  }
}
