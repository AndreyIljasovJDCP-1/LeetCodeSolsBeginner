package leetcode.medium;

public class RobotInCircle {

    public static void main(String[] args) {
        System.out.println(isRobotBounded("GLRLGLLGLGRGLGL"));
    }

    public static boolean isRobotBounded(String instructions) {

        Direction north = new Direction("north", 0);
        Direction south = new Direction("south", 2);
        Direction east = new Direction("east", 1);
        Direction west = new Direction("west", 3);
        north.setLeft(west);
        north.setRight(east);
        east.setLeft(north);
        east.setRight(south);
        south.setLeft(east);
        south.setRight(west);
        west.setLeft(south);
        west.setRight(north);
        Direction direction = north;
        int x = 0;
        int y = 0;
        int count = 0;
        while (count < 100) {
            for (int i = 0; i < instructions.length(); i++) {
                String command = instructions.charAt(i) + "";
                switch (command) {
                    case "G" -> {
                        switch (direction.name) {
                            case "north" -> y++;
                            case "south" -> y--;
                            case "east" -> x++;
                            case "west" -> x--;
                        }
                        count++;
                        System.out.println("[" + x + ", " + y + "] count= "
                                + count + " DIRECTION: " + direction);


                    }
                    case "R" -> {
                        System.out.println("DIRECTION: " + direction);
                        direction = direction.right;
                        System.out.println("NEW DIRECTION: " + direction);
                    }
                    case "L" -> {
                        System.out.println("DIRECTION: " + direction);
                        direction = direction.left;
                        System.out.println("NEW DIRECTION: " + direction);
                    }
                }

            }
            if (x == 0 && y == 0) return true;
        }
        return false;
    }

    static class Direction {
        int val;
        String name;
        Direction left;
        Direction right;

        public Direction(String name, int val) {
            this.name = name;
            this.val = val;
            this.right = null;
            this.left = null;
        }

        public void setLeft(Direction left) {
            this.left = left;
        }

        public void setRight(Direction right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
