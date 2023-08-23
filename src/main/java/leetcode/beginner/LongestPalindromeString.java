package leetcode.beginner;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindromeString {

  public static void main(String[] args) {
      longestPalindrome("abcdefrtsywzjklmn");
  }

  public static String longestPalindrome(String s) {
    int last = s.length();
    int first = 0;
    /*s = s.length() % 2 == 0 ? s + "_" : s;
    int mid = s.length() / 2;*/

    Set<String> combinations = new HashSet<>();
    recList("", s, combinations);
    System.out.println("set");
    combinations.forEach(System.out::println);
    return "result";
  }

  private static void recList(String candidate, String remaining, Set<String> set) {

    // базовый вариант
    if (remaining == null) {
      return;
    }
    System.out.println(candidate);
    if (candidate.length() > 1) {
      // System.out.println(candidate);
      StringBuilder sb = new StringBuilder(candidate);
      if (sb.reverse().toString().equals(candidate)) {
        // System.out.println(candidate);
        set.add(candidate);
      }
    }

    for (int i = 0; i < remaining.length(); i++) {
      String newCandidate = remaining.substring(0, i + 1);
      String newRemaining = remaining.substring(i + 1);
      recList(newCandidate, newRemaining, set);
    }
  }

  private static String rec(String s, int first, int last, int offset) {

    String sub = s.substring(first, last);
    if (sub.length() < 2) return null;
    StringBuilder sb = new StringBuilder(sub);
    if (sb.reverse().toString().equals(sub)) {
      return sub;
    }
    String fRes = rec(s, first + 1, last, offset + 1);
    if (fRes == null) {
      return rec(s, first, last - 1, offset + 1);
    } else return fRes;
  }
}
