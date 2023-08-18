package leetcode.medium;

public class MultiplyStrings {

    public static void main(String[] args) {
        System.out.println(multiplyMatrix("9", "99"));
    }

    /**
     * Given two non-negative integers num1 and num2 represented as strings,
     * return the product of num1 and num2, also represented as a string.
     *
     * Note: You must not use any built-in BigInteger library
     * or convert the inputs to integer directly.
     * @param num1 non-negative integers
     * @param num2 non-negative integers
     * @return num1*num2 as string
     */
    public static String multiplyMatrix(String num1, String num2) {
        char[] first = num1.toCharArray();
        char[] second = num2.toCharArray();
        int rows = first.length * second.length;
        int size = first.length + second.length;
        int[][] matrix = new int[rows][size];
        int row = 0;
        for (int i = second.length - 1; i >= 0; i--) {
            int factorSecond = second[i] - 48;
            int col = size - second.length + i;
            for (int j = first.length - 1; j >= 0; j--) {
                int factorFirst = first[j] - 48;
                int product = factorFirst * factorSecond;
                int offset = 0;
                while (product > 0) {
                    matrix[row][col - offset] = product % 10;
                    product /= 10;
                    offset++;
                }
                row++;
                col--;
            }
        }
        print(matrix);

        return sumMatrix(matrix);
    }

    private static String sumMatrix(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        int extra = 0;
        for (int i = matrix[0].length - 1; i >= 0; i--) {
            int sum = extra;
            for (int j = 0; j < matrix.length; j++) {
                sum += matrix[j][i];
            }
            extra = sum / 10;
            sb.append(sum % 10);
        }
        return sb.reverse().toString().replaceAll("^0+(?!$)", "");
    }

    private static void print(int[][] matrix) {
        for (int[] lines : matrix) {
            for (int el : lines) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }

    public String multiplyBest(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static String multiplySimple(String num1, String num2) {
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        long total = 0;
        long rank2 = 1;
        for (int i = n2.length - 1; i >= 0; i--) {
            long sum = 0;
            long factorN2 = (n2[i] - 48) * rank2;
            long rank1 = 1;
            for (int j = n1.length - 1; j >= 0; j--) {
                long factorN1 = (n1[j] - 48) * rank1;
                sum += factorN1 * factorN2;
                rank1 *= 10;
            }
            System.out.println(sum);
            rank2 *= 10;
            total += sum;
        }
        return String.valueOf(total);
    }
}
