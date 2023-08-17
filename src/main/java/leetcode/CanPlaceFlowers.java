package leetcode;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not
 * empty, and an integer n, return true if n new flowers can be planted in the flowerbed without
 * violating the no-adjacent-flowers rule and false otherwise.
 */
public class CanPlaceFlowers {
  public static void main(String[] args) {
    Flowers flowers = new Flowers(new int[] {1, 0, 0, 0, 0, 0, 0, 0, 0}, 10);
    Iterator<Integer> iterator = flowers.iterator();

    while (iterator.hasNext()) {
      flowers.canPlace();
      if (flowers.isPossible()) break;
      iterator.next();
    }
    System.out.println(flowers.isPossible() + flowers.summaryMessage());
    flowers.getFlowerbed();
  }
}

class Flowers implements Iterable<Integer> {
  private final int[] flowerbed;
  private int previous = 0;
  private int current;
  private int next;
  private int index = 0;
  private int flowers;

  public Flowers(int[] flowerbed, int n) {
    if (flowerbed.length == 0) throw new IllegalArgumentException("Empty flowerbed!");
    this.flowerbed = flowerbed;
    this.current = flowerbed[0];
    this.next = flowerbed.length == 1 ? flowerbed[0] : flowerbed[1];
    this.flowers = n;
  }

  public boolean isPossible() {
    return flowers <= 0;
  }

  public String summaryMessage() {
    String message =
        flowers == 0
            ? ". All flowers on places."
            : flowers < 0
                ? ". " + Math.abs(flowers) + " free places left."
                : ". No places for " + flowers + " flowers.";
    return String.format("%s", message);
  }

  public void getFlowerbed() {
    System.out.println(Arrays.toString(flowerbed));
  }

  public void canPlace() {
    if (previous == 0 && current == 0 && next == 0) {
      flowerbed[index] = 1;
      current = 1;
      flowers--;
    }
  }

  @Override
  public Iterator<Integer> iterator() {
    return new Iterator<>() {
      @Override
      public boolean hasNext() {
        return index < flowerbed.length;
      }

      @Override
      public Integer next() {
        previous = current;
        current = next;
        index++;
        next = index >= flowerbed.length - 1 ? 0 : flowerbed[index + 1];
        return previous;
      }
    };
  }
}
