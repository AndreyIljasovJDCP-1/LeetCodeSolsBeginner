package leetcode.beginner;

/**
 * Given two strings str1 and str2,
 * return the largest string x
 * such that x divides both str1 and str2.
 *
 *
 */
public class DivisorStrings {
    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABABABAB","ABABAAB"));
    }

    public static String gcdOfStrings(String str1, String str2) {
        String longer = str1.length() >= str2.length() ? str1 : str2;
        String shorter = str1.length() >= str2.length() ? str2 : str1;
        if (longer.replaceAll(shorter, "").isEmpty()) return shorter;
        int divider = 2;
        while (divider <= shorter.length()) {
            if (shorter.length() % divider == 0) {
                String sub = shorter.substring(0, shorter.length() / divider);
                System.out.println(sub);
                if (shorter.replaceAll(sub, "").isEmpty()) {
                    if (longer.length() % sub.length() == 0) {
                        if (longer.replaceAll(sub, "").isEmpty()) return sub;
                    }

                }
            }
            divider++;
        }
        return "";
    }

    public static String gcdOfStringsBest(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)) return "";
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    /**
     * Поиск наибольшего общего делителя НОД
     * @param n1
     * @param n2
     * @return
     */
    public static int gcd(int n1, int n2)
    {
        if(n2==0)
            return n1;
        return gcd(n2, n1%n2);
    }
}
