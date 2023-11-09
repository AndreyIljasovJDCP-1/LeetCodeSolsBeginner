package leetcode.beginner;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/">
 *     Best Time to Buy and Sell Stock I and 122. Best Time to Buy and Sell Stock II</a>
 */
public class MaxProfit {
  public static void main(String[] args) {
    System.out.println(maxProfitII(new int[]{2, 1, 2, 0, 1}));
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

  public static int maxProfitII(int[] prices) {
    int min = Integer.MAX_VALUE;
    int indexMin = 0;
    int maxProfit = 0;
    int sum = 0;
    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < min) {
        min = prices[i];
        indexMin = i;
        sum += maxProfit;
        maxProfit = 0;
      }
      if (i > indexMin) {
        if (prices[i] - min > maxProfit) {
          maxProfit = prices[i] - min;
        } else {
          System.out.println("maxProfit " + maxProfit);
          System.out.println("sum " + sum);
          sum += maxProfit;
          maxProfit = 0;
          min = prices[i];
          indexMin = i;
        }
        System.out.println("maxProfit " + maxProfit);
        System.out.println("sum " + sum);
      }

    }
    return sum + maxProfit;
  }
}
