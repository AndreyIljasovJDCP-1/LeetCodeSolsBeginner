package leetcode;

/**
 * You are given an array coordinates, coordinates[i] = [x, y],
 * where [x, y] represents the coordinate of a point.
 * Check if these points make a straight line in the XY plane.
 */
public class StraightLine {

    public static void main(String[] args) {
        System.out.println(
                checkStraightLine1(
                        new int[][]{
                                {1, 1},
                                {2, 10},
                                {5,37}

                        }));
    }

    public static boolean checkStraightLine1(int[][] coordinates) {
        int xA = coordinates[0][0];
        int xB = coordinates[1][0];
        int yA = coordinates[0][1];
        int yB = coordinates[1][1];
        for (int i = 2; i < coordinates.length; i++) {
            int x = coordinates[i][0];
            int y = coordinates[i][1];
            if ((x - xA) * (yB - yA) != (y - yA) * (xB - xA) ) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkStraightLine(int[][] coordinates) {
        String direction = coordinates[0][0] == coordinates[1][0]
                ? "RIGHT"
                : coordinates[0][1] == coordinates[1][1]
                ? "UP"
                : "DIAG";
        System.out.println(direction);
        switch (direction) {
            case "RIGHT" -> {
                int x = coordinates[0][0];
                for (int i = 1; i < coordinates.length; i++) {
                    if (coordinates[i][0] != x) return false;
                }
                return true;
            }
            case "UP" -> {
                int y = coordinates[0][1];
                for (int i = 1; i < coordinates.length; i++) {
                    if (coordinates[i][1] != y) return false;
                }
                return true;
            }
            case "DIAG" -> {
                int xA = coordinates[0][0];
                int xB = coordinates[1][0];
                int yA = coordinates[0][1];
                int yB = coordinates[1][1];
                int diffY = yB - yA;
                int diffX = xB - xA;
                for (int i = 2; i < coordinates.length; i++) {
                    int x = coordinates[i][0];
                    int y = coordinates[i][1];
                    if ((x - xA) / diffX != (y - yA) / diffY) {
                        return false;
                    }

                }
                return true;
            }
        }

        return false;

    }
}
