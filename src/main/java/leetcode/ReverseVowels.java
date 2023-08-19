package leetcode;

/**
 * Given a string s, reverse only all the vowels in the string and return it.
 * The vowels are 'a', 'e', 'i', 'o', and 'u',
 * and they can appear in both lower and upper cases, more than once.
 */
public class ReverseVowels {
    public static void main(String[] args) {
        System.out.println(reverseVowelsBest("Euston saw I was not Sue."));
    }

    public static String reverseVowelsBest(String s) {
        var chars = s.toCharArray();
        String VOWELS = "aeiouAEIOU";
        int first = 0;
        int last = s.length() - 1;
        while (first < last) {

            while (first < last && !VOWELS.contains(chars[first] + "")) {
                first++;
            }
            while (first < last && !VOWELS.contains(chars[last] + "")) {
                last--;
            }

            char temp = chars[first];
            chars[first] = chars[last];
            chars[last] = temp;
            first++;
            last--;
        }

        return new String(chars);
    }

    public static String reverseVowels3(String s) {
        char[] chars = s.toCharArray();
        String VOWELS = "aeiouAEIOU";
        String vow = "";
        for (int i = 0; i < s.length(); i++) {
            if (VOWELS.indexOf(s.charAt(i)) != -1) {
                vow = s.charAt(i) + vow;
            }
        }
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (VOWELS.indexOf(chars[i]) != -1) {
                chars[i] = vow.charAt(index++);
            }
        }
        return new String(chars);
    }

    public static String reverseVowels2(String s) {
        StringBuilder sb = new StringBuilder(s);
        String VOWELS = "aeiouAEIOU";
        char f = 0;
        char l = 0;
        int first = -1;
        int last = -1;
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (VOWELS.indexOf(s.charAt(i)) != -1) {
                first = i;
                f = s.charAt(i);
            }
            if (VOWELS.indexOf(s.charAt(j)) != -1) {
                last = j;
                l = s.charAt(j);
            }
            if (first != -1 & last != -1) {
                if (f != l) {
                    sb.replace(first, first + 1, l + "");
                    sb.replace(last, last + 1, f + "");
                }
                first = -1;
                last = -1;
            }
            i = first == -1 ? i + 1 : i;
            j = last == -1 ? j - 1 : j;
        }

        return sb.toString();
    }

    public static String reverseVowels1(String s) {
        var chars = s.toCharArray();
        int first = -1;
        int last = -1;
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if ((chars[i] + "").matches("[aeiouAEIOU]")) {
                first = i;
            }
            if ((chars[j] + "").matches("[aeiouAEIOU]")) {
                last = j;
            }
            if (first != -1 & last != -1) {
                swap(chars, first, last);
                first = -1;
                last = -1;
            }
            i = first == -1 ? i + 1 : i;
            j = last == -1 ? j - 1 : j;
        }

        return new String(chars);
    }

    public static String reverseVowels(String s) {
        var chars = s.toCharArray();
        boolean[] vowelsPlaces = new boolean[chars.length];
        String vowels = "";
        int i = 0;
        while (i < s.length()) {
            String symbol = chars[i] + "";
            if (symbol.matches("[aeiouAEIOU]")) {
                vowelsPlaces[i] = true;
                vowels = symbol + vowels;
            }
            i++;
        }
        i = 0;
        for (int j = 0; j < chars.length; j++) {
            if (vowelsPlaces[j]) chars[j] = vowels.charAt(i++);
        }
        return new String(chars);
    }

    private static void swap(char[] chars, int first, int next) {
        if (chars[first] != chars[next]) {
            char temp = chars[first];
            chars[first] = chars[next];
            chars[next] = temp;
        }
    }

}
