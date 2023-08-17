package leetcode;

public class MatrixWealth {

  public static void main(String[] args) {
    System.out.println(
        maximumWealth(
            new int[][] {
              {1, 2, 3},
              {1, 2, 35},
              {5, 6, 8},
              {9},
              {125}
            }));
  }

  public static int maximumWealth(int[][] accounts) {
    int maxWealth = 0;
    for (int[] customer : accounts) {
      int customerWealth = 0;
      for (int sum : customer) {
        customerWealth += sum;
      }
      if (customerWealth > maxWealth) {
        maxWealth = customerWealth;
      }
    }
    return maxWealth;
  }
}
