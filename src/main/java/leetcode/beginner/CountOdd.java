package leetcode.beginner;

public class CountOdd {
  public static void main(String[] args) {
    System.out.println(countOdds(8,12));
  }

  public static int countOdds(int low, int high) {
    if ((low & 1) == 0 && (high & 1) == 0) return (high - low) / 2;
    return (high - low) / 2 + 1;
  }
}
