package leetcode;

public class SumBinaryString {
    public static void main(String[] args) {
        System.out.println(addBinaryTwoPointers("101111", "10"));
    }

    public static String addBinaryBest(String a, String b)
    {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry == 1)
        {
            if(i >= 0)
                carry += a.charAt(i--) - '0';
            if(j >= 0)
                carry += b.charAt(j--) - '0';
            sb.append(carry % 2);
            carry /= 2;
        }
        return sb.reverse().toString();
    }

    public static String addBinary(String a, String b) {
        System.out.println(Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2)));
        StringBuilder sb = new StringBuilder();
        boolean aLong = a.length() > b.length();
        int diff = aLong
                ? a.length() - b.length()
                : b.length() - a.length();
        int maxLength = aLong
                ? a.length()
                : b.length();
        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();
        int offset = 0;
        for (int i = maxLength - 1; i >= diff; i--) {
            int sum = aLong
                    ? arrA[i] - '0' + arrB[i-diff] - '0'
                    : arrB[i] - '0' + arrA[i-diff] - '0';
            switch (sum + offset) {
                case 3 -> {sb.append('1'); offset = 1;}
                case 2 -> {sb.append('0'); offset = 1;}
                case 1 -> {sb.append('1'); offset = 0;}
                case 0 -> {sb.append('0'); offset = 0;}
            }
        }
        int i = diff - 1;
        while (offset == 1 && i >= 0){
            int sum = aLong
                    ? arrA[i] - '0'
                    : arrB[i] - '0';
            switch (sum + offset) {
                case 2 -> sb.append('0');
                case 1 -> {sb.append('1'); offset = 0;}
                case 0 -> {sb.append('0'); offset = 0;}
            }
            i--;
        }
        if (offset == 1) {
            sb.append('1');
        }
        var head= aLong
                ? a.substring(0, i + 1)
                : b.substring(0, i + 1);

        return head + sb.reverse();
    }

    public static String addBinaryTwoPointers(String a, String b) {
        System.out.println(Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2)));
        StringBuilder sb = new StringBuilder();
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        int offset = 0;
        int pointerA = aChars.length - 1;
        int pointerB = bChars.length - 1;

        while (pointerA >= 0 && pointerB >= 0){
            int aChar = aChars[pointerA] - '0';
            int bChar = bChars[pointerB] - '0';
            int sum = aChar + bChar + offset;
            offset = sum/2;//0 or 1 (0,1,2,3) 0,1 -> 0 2,3 -> 1
            sb.append(sum % 2); //0 or 1 (0,1,2,3) 0,2 -> 0 1,3 -> 1
            pointerA--;
            pointerB--;
        }

        while(pointerA >= 0 && offset == 1){
            int aChar = aChars[pointerA] - '0';
            int sum = aChar + offset;
            offset = sum/2;
            sb.append(sum % 2);
            pointerA--;
        }
        while(pointerB >= 0 && offset == 1){
            int bChar = bChars[pointerB] - '0';
            int sum = bChar + offset;
            offset = sum/2;
            sb.append(sum % 2);
            pointerB--;
        }
        if (offset == 1){
            sb.append(offset);
        }

        var head= pointerA >= 0
                ? a.substring(0, pointerA + 1)
                : b.substring(0, pointerB + 1);

        return head + sb.reverse();
    }
}
