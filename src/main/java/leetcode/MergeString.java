package leetcode;

public class MergeString {

  public static void main(String[] args) {
    System.out.println(mergeAlternately("aaaaaa", "bbb"));
  }

  public static String mergeAlternately(String word1, String word2) {
    StringBuilder sb = new StringBuilder();
    int indexW1 = 0;
    int indexW2 = 0;
    while (indexW1 < word1.length() || indexW2 < word2.length()) {
      if (indexW1 < word1.length()) {
        sb.append(word1.charAt(indexW1++));
      }
      if (indexW2 < word2.length()) {
        sb.append(word2.charAt(indexW2++));
      }
    }
    return sb.toString();
  }
}
