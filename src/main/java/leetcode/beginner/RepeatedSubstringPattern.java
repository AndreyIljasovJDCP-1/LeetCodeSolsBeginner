package leetcode.beginner;

public class RepeatedSubstringPattern {
  public static void main(String[] args) {
    System.out.println(repeatedSubstringPattern1("aaa"));
  }

  public static boolean repeatedSubstringPattern(String s) {
    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j < s.length(); j++) {
        String subs = s.substring(i, j + 1);
        System.out.println(subs);
        if (subs.length() == s.length()) continue;
        if (s.replaceAll(subs, "").length() == 0) return true;
      }
    }
    return false;
  }

  public static boolean repeatedSubstringPattern1(String s) {
    if (s.length() == 1) return false;
    int divider = 1;
    while (divider <= s.length()) {
      divider++;
      if (s.length() % divider == 0) {
        String sub = s.substring(0, s.length() / divider);
        System.out.println(sub);
        if (s.replaceAll(sub, "").isEmpty()) return true;
      }
    }

    return false;
  }
}
