package leetcode.beginner;

public class MaxProfit {
  public static void main(String[] args) {
    System.out.println(maxProfit(new int[] {3, 2, 6, 5, 0, 3}));
  }

  public static int maxProfit(int[] prices) {
    int min = Integer.MAX_VALUE;
    int indexMin = 0;
    int maxProfit = 0;
    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < min) {
        min = prices[i];
        indexMin = i;
      }
      if (i > indexMin) {
        if (prices[i] - min > maxProfit) maxProfit = prices[i] - min;
      }
    }
    return maxProfit;
  }
}
