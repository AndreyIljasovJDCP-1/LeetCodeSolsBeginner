package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SnailArray {
  public static void main(String[] args) {
    System.out.println(spiralOrder(new int[][] {{2}, {5}}));
  }

  public static List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    int n = matrix.length;
    int m = matrix[0].length;
    int index = 0;
    int up = 0;
    int down = n - 1;
    int left = 0;
    int right = m - 1;
    while (index < n * m) {
      for (int i = up; i <= right; i++) {
        result.add(matrix[up][i]);
        index++;
      }
      if (index == n * m) break;
      up++;
      for (int i = up; i <= down; i++) {
        result.add(matrix[i][right]);
        index++;
      }
      if (index == n * m) break;
      right--;
      for (int i = right; i >= left; i--) {
        result.add(matrix[down][i]);
        index++;
      }
      if (index == n * m) break;
      down--;
      for (int i = down; i >= up; i--) {
        result.add(matrix[i][left]);
        index++;
      }
      if (index == n * m) break;
      left++;
    }
    // if (n != m) result.remove(result.size() - 1);
    return result;
  }
}
