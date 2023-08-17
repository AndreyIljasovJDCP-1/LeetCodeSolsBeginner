package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RomanNumbers {
  public static Map<String, Integer> ROMAN_NUMERALS = new HashMap<>();

  static {
    ROMAN_NUMERALS.put("I", 1);
    ROMAN_NUMERALS.put("F", 4);
    ROMAN_NUMERALS.put("V", 5);
    ROMAN_NUMERALS.put("N", 9);
    ROMAN_NUMERALS.put("X", 10);
    ROMAN_NUMERALS.put("S", 40);
    ROMAN_NUMERALS.put("L", 50);
    ROMAN_NUMERALS.put("Y", 90);
    ROMAN_NUMERALS.put("C", 100);
    ROMAN_NUMERALS.put("T", 400);
    ROMAN_NUMERALS.put("D", 500);
    ROMAN_NUMERALS.put("R", 900);
    ROMAN_NUMERALS.put("M", 1000);
  }

  public static void main(String[] args) {
    System.out.println(romanToInt("LVIII"));
  }

  public static int romanToInt(String s) {
    Map<String, Integer> romans = new HashMap<>();
    romans.put("I", 1);
    romans.put("F", 4);
    romans.put("V", 5);
    romans.put("N", 9);
    romans.put("X", 10);
    romans.put("S", 40);
    romans.put("L", 50);
    romans.put("Y", 90);
    romans.put("C", 100);
    romans.put("T", 400);
    romans.put("D", 500);
    romans.put("R", 900);
    romans.put("M", 1000);
    s = s.replaceFirst("IV", "F");
    s = s.replaceFirst("IX", "N");
    s = s.replaceFirst("XL", "S");
    s = s.replaceFirst("XC", "Y");
    s = s.replaceFirst("CD", "T");
    s = s.replaceFirst("CM", "R");

    return Arrays.stream(s.split("")).mapToInt(romans::get).sum();
  }
}
