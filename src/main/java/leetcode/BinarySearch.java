package leetcode;

import java.util.List;

public class BinarySearch {
  public static void main(String[] args) {
    System.out.println(missingNumber(new int[] {0, 1}));
    // System.out.println(wordBreak("leetlcodcodecodeleetlecod", List.of("leet", "code")));
  }

  public static int missingNumber(int[] nums) {
    int sum = nums.length * (1 + nums.length) / 2;
    for (int num : nums) {
      sum -= num;
    }
    return sum;
  }

  /**
   * @param nums a non-empty array of integers nums, every element appears twice except for one.
   *     <p>You must implement a solution with a linear runtime complexity and use only constant
   *     extra space.
   * @return Find that single one.
   */
  public static int singleNumber(int[] nums) {
    int res = 0;
    for (int num : nums) {
      res ^= num;
    }
    return res;
  }

  /**
   * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a
   * space-separated sequence of one or more dictionary words.
   *
   * <p>Note that the same word in the dictionary may be reused multiple times in the segmentation.
   *
   * @param s
   * @param wordDict
   * @return
   */
  public static boolean wordBreak(String s, List<String> wordDict) {
    for (String word : wordDict) {
      s = s.replaceAll(word, "");
      System.out.println(s);
    }
    return s.length() == 0;
  }

  public static int searchBinary(int[] nums, int target) {
    int first = 0;
    int last = nums.length - 1;
    while (first <= last) {
      int mid = first + (last - first) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] >= nums[first]) {
        if (target >= nums[first] && target < nums[mid]) {
          last = mid - 1;
        } else {
          first = mid + 1;
        }
      } else if (nums[mid] <= nums[last]) {
        if (target > nums[mid] && target <= nums[last]) {
          first = mid + 1;
        } else {
          last = mid - 1;
        }
      }
    }
    return -1;
  }

  public static int search(int[] nums, int target) {
    if (nums[0] > nums[nums.length - 1]) {
      int first = 0;
      int last = nums.length - 1;
      int mid = first + (last - first) / 2;
      int indexMin = 0;
      int indexMax = 0;

      if (last == 1) {
        indexMin = last;
      } else {
        int i = 0;
        while (mid + i < last || mid - i > first) {
          if (nums[mid + i + 1] < nums[mid + i]) {
            indexMax = mid + i;
            indexMin = mid + i + 1;
            break;
          }
          if (nums[mid - i - 1] > nums[mid - i]) {
            indexMax = mid - i - 1;
            indexMin = mid - i;
            break;
          }
          i++;
        }
      }
      System.out.println("indexMin= " + indexMin + " indexMax= " + indexMax + " mid= " + mid);
      if (target < nums[indexMin] || target > nums[indexMax]) return -1;
      if (target <= nums[last]) {
        // ищем от indexMin до последнего
        return binarySearchIteration(nums, target, indexMin, last);
      } else {
        return binarySearchIteration(nums, target, first, indexMax);
      } // ищем от начала до indexMax
    }
    if (target < nums[0] || target > nums[nums.length - 1]) return -1;
    return binarySearchIteration(nums, target, 0, nums.length - 1);
  }

  /**
   * BinarySearch. Функция для определения index `target`
   *
   * @param nums отсортированный массив
   * @param target цель поиска
   * @return index, если найден, -1 если нет.
   */
  private static int binarySearchIteration(int[] nums, int target, int first, int last) {
    // область поиска nums[first…last]
    /*int first = 0;
    int last = nums.length - 1;*/

    // цикл до тех пор, пока пространство поиска не будет исчерпано
    while (first <= last) {
      // находим среднее значение в пространстве поиска и
      // сравнивает его с целью

      // int mid = (first + last) / 2;

      // может произойти переполнение. Использовать:
      int mid = first + (last - first) / 2;
      // int mid = last - (last - first) / 2;

      // цель найдена
      if (target == nums[mid]) {
        return mid;
      }

      // отбросить все элементы в правильном пространстве поиска,
      // включая средний элемент
      else if (target < nums[mid]) {
        last = mid - 1;
      }

      // отбрасываем все элементы в левой области поиска,
      // включая средний элемент
      else {
        first = mid + 1;
      }
    }

    // `target` не существует в массиве
    return -1;
  }

  /**
   * Recurtion BinarySearch. Функция для определения index `target`
   *
   * @param nums отсортированный массив
   * @param first index первого элемента(0)
   * @param last index последнего элемента(nums.length - 1)
   * @param target цель поиска
   * @return index, если найден, -1 если нет.
   */
  private static int binarySearchRecursion(int[] nums, int first, int last, int target) {
    // Базовое условие (пространство поиска исчерпано)
    if (first > last) {
      return -1;
    }
    int mid = first + (last - first) / 2;
    if (target == nums[mid]) { // Базовое условие (цель найдена)
      return mid;
    } else if (target < nums[mid]) {
      return binarySearchRecursion(nums, first, mid - 1, target);
    } else {
      return binarySearchRecursion(nums, mid + 1, last, target);
    }
  }
}
