package leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * @link <a href="https://leetcode.com/problems/asteroid-collision/description/?envType=study-plan-v2&envId=leetcode-75">
 *     735. Asteroid Collision</a>
 */
public class AsteroidCollisions {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(collision(new int[]{
                10,2,-5
        })));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i : asteroids) {
            if (stack.isEmpty() || i > 0) {
                stack.add(i);
            } else {
                while (true) {
                    int peek = stack.peek();
                    if (peek < 0) {
                        stack.add(i);
                        break;
                    } else if (peek == -i) {
                        stack.pop();
                        break;
                    } else if (peek > -i) {
                        break;
                    } else {
                        stack.pop();
                        if (stack.isEmpty()) {
                            stack.add(i);
                            break;
                        }
                    }
                }
            }
        }
        int[] ans = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    public static int[] collision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        if (asteroids.length < 2) return asteroids;

        for (int direction : asteroids) {
            if (stack.empty() || direction > 0) {
                stack.push(direction);
            } else {
                while (true) {
                    int previous = stack.peek();
                    if (previous < 0) {
                        stack.push(direction);
                        break;
                    } else if (previous == -direction) {
                        stack.pop();
                        break;
                    } else if (previous > -direction) {
                        break;
                    } else {
                        stack.pop();
                        if (stack.isEmpty()) {
                            stack.push(direction);
                            break;
                        }
                    }
                }
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }

    public static int[] collisionAll(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        if (asteroids.length < 2) return asteroids;

        for (int direction : asteroids) {
            if (stack.empty()) {
                stack.push(direction);
            } else {
                int previous = stack.peek();
                int current = direction;
                if (!sign(previous, current)) {
                    while (!stack.empty()) {
                        previous = stack.peek();
                        if (Math.abs(current) == Math.abs(previous)) {
                            stack.pop();
                            current = 0;
                            break;
                        } else if (Math.abs(current) > Math.abs(previous)) {
                            stack.pop();
                        } else {
                            current = 0;
                            break;
                        }
                    }
                    if (current != 0) stack.push(current);

                } else {
                    stack.push(direction);
                }
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }

    private static boolean sign(int x, int y) {
        return x < 0 && y < 0 || x > 0 && y > 0;
    }
}
