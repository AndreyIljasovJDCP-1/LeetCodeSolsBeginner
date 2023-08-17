package leetcode;

import java.util.Arrays;

public class AverageSalary {

    public static double average(int[] salary) {
        Arrays.sort(salary);
        int sum = Arrays.stream(salary, 1, salary.length - 1).sum();
        return sum * 1.0 / (salary.length - 2);
    }
}
