package leetcode.medium;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @link <a href="https://leetcode.com/
 * problems/kth-largest-element-in-an-array/
 * submissions/?envType=study-plan-v2&envId=leetcode-75">
 * 215. Kth Largest Element in an Array</a>
 */
public class QueueFindKthLargest {

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},3));
    }
    public static int findKthLargest(int[] nums, int k) {
        Queue<Integer> sorted = new PriorityQueue<>(Collections.reverseOrder());
        for (int el : nums) {
            sorted.add(el);
        }

        int count = 0;
        while(++count < k){
            sorted.poll();
        }
        return sorted.element();
    }
}
