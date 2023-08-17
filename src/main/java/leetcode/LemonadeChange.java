package leetcode;

public class LemonadeChange {
    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[]{5, 5, 5, 10, 20,5,5,5,10,20}));
    }

    public static boolean lemonadeChange(int[] bills) {
        int[] change = new int[3];
        for (int bill : bills) {
            switch (bill) {
                case 5:
                    change[0]++;
                    break;
                case 10:
                    if (change[0] > 0) {
                        change[1]++;
                        change[0]--;
                    } else {
                        return false;
                    }
                    break;
                case 20:
                    if (change[1] > 0) {
                        if (change[0] > 0) {
                            change[2]++;
                            change[1]--;
                            change[0]--;
                        } else {
                            return false;
                        }
                    } else if (change[0] >= 3) {
                        change[2]++;
                        change[0] -= 3;
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
}
