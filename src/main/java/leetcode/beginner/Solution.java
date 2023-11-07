package leetcode.beginner;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Solution {
  public static void main(String[] args) {
    System.out.println(lengthOfLastWord("ffff  ggggrty   "));
    // System.out.println(search(new int[] {0, 7, 12, 44, 55, 68, 256, 357}, 55));
  }

  public static int lengthOfLastWord(String s) {
    System.out.println(s.matches(".*(\\w*)(?=\\s+$|$)"));
    Pattern pattern = Pattern.compile("(\\w*)(?=\\s+$|$)");
    Matcher matcher = pattern.matcher(s);
    matcher.find();
    s = s.substring(matcher.start());
    return s.substring(0, s.contains(" ") ? s.indexOf(" ") : s.length()).length();
  }

  public static int searchInsert(int[] nums, int target) {
    if (target > nums[nums.length - 1]) return nums.length;
    if (target < nums[0]) return 0; // or 1
    for (int i = 0; i < nums.length; i++) {
      if (target <= nums[i]) return i;
    }
    return 0;
  }

  public static int[] plusOne(int[] digits) {
    for (int i = digits.length - 1; i >= 0; i--) {
      if (digits[i] != 9) {
        digits[i]++;
        return digits;
      }
      digits[i] = 0;
    }
    digits = new int[digits.length + 1];
    digits[0] = 1;
    return digits;
  }

  public static int strStr(String haystack, String needle) {
    return haystack.indexOf(needle);
  }

  public static void minSubArrayLenCombi() {
    List<Integer> list = new ArrayList<>();
    List<int[]> result = new ArrayList<>();
    var arr = new int[] {5, 6, 9, 13, 8, 3};
    Map<Integer, int[]> map = new HashMap<>();
    search(0, list, arr, 8, result);
    // map.forEach((k, v) -> System.out.println("key=" + k + " value=" + Arrays.toString(v)));
    result.forEach(s -> System.out.println(Arrays.toString(s)));
  }

  private static void search(
      int index, List<Integer> combinations, int[] arr, int target, List<int[]> result) {
    if (index == arr.length) {
      // обработка индексов
      System.out.println(combinations);
      int sum = combinations.stream().reduce(0, Integer::sum);
      if (sum >= target) {
        var subArray = combinations.stream().mapToInt(i -> i).toArray();
        if (result.isEmpty()) {
          result.add(subArray);
        } else {
          if (subArray.length < result.get(0).length) {
            result.clear();
            result.add(subArray);
          }
        }
      }
    } else {
      combinations.add(arr[index]);
      search(index + 1, combinations, arr, target, result);
      combinations.remove(combinations.size() - 1);
      search(index + 1, combinations, arr, target, result);
    }
  }

  public static int minSubArrayLen(int target, int[] nums) {
    int ans = nums.length + 1, j = 0, sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum = sum + nums[i];
      if (sum >= target) {
        while (sum >= target) {
          sum -= nums[j++];
        }
        ans = Math.min(ans, i - j + 2);
      }
    }
    return ans == nums.length + 1 ? 0 : ans;
  }

  public static int reverse(int x) {

    String reversed = new StringBuilder(Integer.toString(Math.abs(x))).reverse().toString();
    int result;
    try {
      result = Integer.parseInt(reversed);
    } catch (Exception e) {
      return 0;
    }

    return x < 0 ? result * -1 : result;
  }

  public static boolean buddyStringLong(String s, String goal) {
    int sLength = s.length();
    if (sLength != goal.length()) return false;
    if (sLength < 2) return false;

    if (s.intern() == goal.intern()) {
      // check for duplicates
      Set<String> setS = new HashSet<>();
      for (int i = 0; i < sLength; i++) {
        System.out.println(s.charAt(i));
        if (!setS.add(s.charAt(i) + "")) {
          return true;
        }
      }
    }
    for (int i = 0; i < sLength; i++) {
      for (int j = i + 1; j < sLength; j++) {
        StringBuilder candidate = new StringBuilder(s);
        candidate.replace(i, i + 1, s.charAt(j) + "");
        candidate.replace(j, j + 1, s.charAt(i) + "");
        System.out.println(candidate);
        if (candidate.toString().equals(goal)) return true;
      }
    }
    return false;
  }

  public static boolean buddyStringLoop(String s, String goal) {
    int sLength = s.length();
    if (sLength < 2) return false;
    if (sLength != goal.length()) return false;

    if (s.equals(goal)) {
      // check for duplicates
      Set<String> setS = new HashSet<>();
      for (int i = 0; i < sLength; i++) {
        System.out.println(s.charAt(i));
        if (!setS.add(s.charAt(i) + "")) {
          return true;
        }
      }
    }
    for (int i = 0; i < s.length(); i++) {
      for (int j = i + 1; j < s.length(); j++) {
        StringBuilder candidate = new StringBuilder(s);
        candidate.replace(i, i + 1, s.charAt(j) + "");
        candidate.replace(j, j + 1, s.charAt(i) + "");
        System.out.println(candidate);
        if (candidate.toString().equals(goal)) return true;
      }
    }
    return false;
  }

  public static boolean buddyString(String s, String target) {

    // List<String> result = new ArrayList<>();
    // String[] seq = new String[s.length()];
    // combination(0, seq, result, s);
    // permutations(0, s.split(""), result);

    permutationsStr("", target, s);
    return true;
  }

  private static void permutationsStr(String candidate, String remaining, String target) {
    // базовый вариант

    if (remaining.length() == 0) {
      System.out.println(candidate);
      if (candidate.equals(target)) {
        System.out.println("true->" + candidate);
        return;
      }
    }

    for (int i = 0; i < remaining.length(); i++) {
      String newCandidate = candidate + remaining.charAt(i);
      String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
      permutationsStr(newCandidate, newRemaining, target);
    }
  }

  public static String longestCommonPrefix(String[] strs) {
    var shortestStr = Arrays.stream(strs).min(Comparator.comparingInt(String::length)).get();
    int i = shortestStr.length();
    while (i > 0) {
      String prefix = shortestStr.substring(0, i--);
      if (Arrays.stream(strs).allMatch(s -> s.startsWith(prefix))) return prefix;
    }
    return "";
  }

  public static int removeElement(int[] nums, int val) {
    int count = 0;
    int i = 0;
    while (i < nums.length - count) {
      if (nums[i] == val) {
        count++;
        System.arraycopy(nums, i + 1, nums, i, nums.length - count - i);
        i--;
      }
      i++;
    }

    return nums.length - count;
  }

  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = 0;
    int transfer = 0;
    for (int j = 0; j < n; j++) {
      if (i == m + transfer) {
        System.arraycopy(nums2, j, nums1, i, n - j);
        break;
      }
      if (nums2[j] < nums1[i]) {
        System.arraycopy(nums1, i, nums1, i + 1, n + m - 1 - i);
        transfer++;
        nums1[i] = nums2[j];
      } else {
        j--;
      }
      i++;
    }
    System.out.println(Arrays.toString(nums1));
    System.out.println(Arrays.toString(nums2));
  }

  public static boolean isAnagramSet(String s, String t) {
    var sa = s.chars().sorted().toArray();
    var ta = t.chars().sorted().toArray();

    return Arrays.equals(sa, ta);
  }

  public static boolean isAnagramSub(String s, String t) {

    for (int i = 0; i < s.length(); i++) {
      t = t.replaceFirst(s.charAt(i) + "", "");
    }
    return t.length() == 0;
  }

  public static boolean isAnagram(String s, String t) {
    return Arrays.stream(t.split(""))
        .sorted()
        .collect(Collectors.joining())
        .equals(Arrays.stream(s.split("")).sorted().collect(Collectors.joining()));
  }

  public static boolean isPalindromeString(String s) {

    String clearStr = s.replaceAll("[^\\p{Alnum}]", "").toUpperCase();
    System.out.println(clearStr);

    for (int i = 0; i < clearStr.length() / 2; i++) {
      if (!(clearStr.charAt(i) == clearStr.charAt(clearStr.length() - 1 - i))) return false;
    }
    System.out.println(s);
    return true;
  }

  public static boolean containsDuplicate(int[] nums) {
    return Arrays.stream(nums).distinct().count() != nums.length;
  }

  public static boolean containsDuplicate1(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (!set.add(num)) return true;
    }

    return false;
  }



  public static int[] twoSum(int[] nums, int target) {

    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] > target) continue;
        if (nums[i] + nums[j] == target) return new int[] {i, j};
      }
    }
    return new int[] {};
  }

  public static int[] twoSumMap(int[] nums, int target) {
    Map<Integer, Integer> integerMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (integerMap.containsKey(target - nums[i])) {
        return new int[] {integerMap.get(target - nums[i]), i};
      }
      integerMap.put(nums[i], i);
    }
    System.out.println(integerMap);
    return new int[] {};
  }

  public static boolean isPalindrome(int x) {
    return Integer.toString(x).equals(new StringBuilder(Integer.toString(x)).reverse().toString());
  }

  public static boolean isPalindrome1(int x) {
    if (x < 0) return false;
    if (x == 0) return true;
    System.out.println(sum(x));
    return Long.parseLong(sum(x)) == x;
  }

  private static String sum(int number) {
    if (number == 0) {
      return "";
    }
    return "" + number % 10 + sum(number / 10);
  }

  public static boolean isPalindrome3(int x) {
    if (x < 0) return false;
    if (x == 0) return true;
    int copyX = x;
    int digits = (int) (Math.log10(x));
    int rank = (int) Math.pow(10, digits);
    int middle = (int) Math.pow(10, digits / 2);
    while (rank > middle) {
      int lastDigit = copyX % 10;
      int firstDigit = x / rank;
      if (firstDigit != lastDigit) return false;
      copyX /= 10;
      x = x - rank * firstDigit;
      rank /= 10;
    }
    return true;
  }

  public boolean isAnagramANSII(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int[] alphabet = new int[26];
    for (int i = 0; i < s.length(); i++) {
      alphabet[s.charAt(i) - 'a']++;
      alphabet[t.charAt(i) - 'a']--;
    }

    return Arrays.stream(alphabet).noneMatch(j -> j != 0);
  }
}
