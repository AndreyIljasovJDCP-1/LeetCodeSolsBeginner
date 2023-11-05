package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @link <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/?envType=study-plan-v2&envId=leetcode-75">
 *     17. Letter Combinations of a Phone Number</a><br>
 *     Input: digits = "23" <br>
 *     Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
public class MobileLettersCombination {

    public static final String[][] LETTERS = new String[][]{
            {"0"},
            {"1"},
            {"a","b","c"},
            {"d","e","f"},
            {"g","h","i"},
            {"j","k","l"},
            {"m","n","o"},
            {"p","q","r","s"},
            {"t","u","v"},
            {"w","x","y","z"}
    };

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
    public static List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return Collections.emptyList();
        String [] variant = new String[digits.length()];
        List<String> result = new ArrayList<>();
        variants(0, variant, digits, result);
        return result;
    }

    private static void variants(int index, String[] variant, String digits, List<String> result) {
        if (index == variant.length) {
            System.out.println("PIN: " + Arrays.toString(variant));
            result.add(String.join("", variant));
        } else {
            int digit = digits.charAt(index) - 48;
            for (int i = 0; i < LETTERS[digit].length; i++) {
                variant[index] = LETTERS[digit][i];
                variants(index + 1, variant, digits, result);
            }
        }
    }
}
