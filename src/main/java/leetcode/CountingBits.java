package leetcode;

import java.util.Arrays;

public class CountingBits {
    public static void main(String[] args) {
        System.out.println(count(11));
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(2));
        System.out.println(Integer.toBinaryString(3));
        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.toBinaryString(6));
        System.out.println(Integer.toBinaryString(7));
        System.out.println(Integer.toBinaryString(8));
        System.out.println(Integer.toBinaryString(9));
        System.out.println(Integer.toBinaryString(10));
        System.out.println(Integer.toBinaryString(11));
        System.out.println(Integer.toBinaryString(12));
        System.out.println(Arrays.toString(countBits(5)));
    }

    public static int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = count(i);
        }
        return res;
    }

    private static int count(int num) {
        if (num == 0) return 0;
        return num % 2 + count(num >> 1);
    }

    public static int[] countBitsBest(int num) {
        int[] f = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            f[i] = f[i >> 1] + (i & 1); // количество 1 числа всегда совпадает с его половиной для четных
        }
        return f;
    }
}
