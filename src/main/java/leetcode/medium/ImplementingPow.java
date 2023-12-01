package leetcode.medium;

/**
 * <a href="https://leetcode.com/problems/powx-n/description/">50. Pow(x, n)</a>
 */
public class ImplementingPow {
    public static void main(String[] args) {
        System.out.println(power(5.25, 1, -2));
    }

    public static double power(double num, double res, int pow) {
        if (pow == 0) return res;
        res = pow < 0 ? res/num : res * num;
        return power(num, res, pow < 0 ? pow + 1 : pow - 1);
    }

    public static double myPow(double x, int n) {
        // Base condition: If n is 0, x^0 is 1
        if (n == 0) {
            return 1;
        }
        // Convert n to a long integer to handle the edge case with Integer.MIN_VALUE
        long N = n;
        // If n is negative, take the reciprocal of x and make N positive
        if (N < 0) {
            N = -N;
            x = 1 / x;
        }
        // If N is even, recursively compute the square of x^(N/2)
        // If N is odd, recursively compute x^(N-1) and multiply it by x
        return N % 2 == 0 ? myPow(x * x, (int) (N / 2)) : x * myPow(x, (int) (N - 1));
    }
}
