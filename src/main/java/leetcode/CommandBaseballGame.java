package leetcode;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CommandBaseballGame {
  public static void main(String[] args) {
    System.out.println(
        calPointsCommandMapStack(new String[] {"5", "-2", "4", "C", "D", "9", "+", "+"}));
  }

  public static int calPointsCommandMapStack(String[] operations) {
    Stack<Integer> result = new Stack<>();
    Map<String, Consumer<String>> commandMap = new HashMap<>();
    commandMap.put(
        "+",
        (c) -> {
          int last = result.pop();
          int prev = result.peek();
          result.push(last);
          result.push(prev + last);
        });
    commandMap.put("D", (c) -> result.push(result.peek() * 2));
    commandMap.put("C", (c) -> result.pop());
    for (String operation : operations) {
      if (operation.matches("-?\\d+")) {
        result.add(Integer.parseInt(operation));
      } else if (operation.matches("[CD+]")) {
        commandMap.get(operation).accept(operation);
      } else {
        throw new IllegalArgumentException("Illegal operation: " + operation);
      }
    }
    return result.stream().mapToInt(i -> i).sum();
  }

  public static int calPointsStack(String[] operations) {
    Deque<Integer> result = new LinkedList<>();
    for (String operation : operations) {
      if (operation.matches("-?\\d*")) {
        result.add(Integer.parseInt(operation));
      } else if (operation.matches("\\+")) {
        int last = result.removeLast();
        int prev = result.getLast();
        result.offer(last);
        result.offer(last + prev);
      } else if (operation.matches("D")) {
        result.offer(result.getLast() * 2);
      } else if (operation.matches("C")) {
        result.removeLast();
      } else {
        throw new IllegalArgumentException("Illegal operation!");
      }
    }
    return result.stream().mapToInt(i -> i).sum();
  }

  public static int calPoints(String[] operations) {
    List<Integer> result = new ArrayList<>();

    for (String operation : operations) {
      if (operation.matches("-?\\d*")) {
        result.add(Integer.parseInt(operation));
      } else if (operation.matches("\\+")) {
        result.add(result.get(result.size() - 1) + result.get(result.size() - 2));
      } else if (operation.matches("D")) {
        result.add(result.get(result.size() - 1) * 2);
      } else if (operation.matches("C")) {
        result.remove(result.size() - 1);
      } else {
        throw new IllegalArgumentException("Illegal operation!");
      }
    }
    return result.stream().mapToInt(i -> i).sum();
  }

  public static int calPointsCommandMap(String[] operations) {
    List<Integer> result = new ArrayList<>();
    Map<String, Supplier<Boolean>> commandMap = new HashMap<>();
    commandMap.put(
        "+", () -> result.add(result.get(result.size() - 1) + result.get(result.size() - 2)));
    commandMap.put("D", () -> result.add(result.get(result.size() - 1) * 2));
    commandMap.put(
        "C",
        () -> {
          result.remove(result.size() - 1);
          return true;
        });
    for (String operation : operations) {
      if (operation.matches("-?\\d*")) {
        result.add(Integer.parseInt(operation));
      } else {
        commandMap
            .getOrDefault(
                operation,
                () -> {
                  throw new IllegalArgumentException("Illegal operation!");
                })
            .get();
      }
    }
    return result.stream().mapToInt(i -> i).sum();
  }
}
