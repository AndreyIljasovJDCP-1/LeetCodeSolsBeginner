package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @link <a href="https://leetcode.com/problems/odd-even-linked-list/?envType=study-plan-v2&envId=leetcode-75">
 * 328. Odd Even Linked List</a>
 */
public class ListNodeOddEven {

    public static void main(String[] args) {
        var list1 = new ListNode(1, "1",
                new ListNode(2, "2",
                        new ListNode(3, "3",
                                new ListNode(4, "4",
                                        new ListNode(5, "5",
                                                new ListNode(6, "6",
                                                        //new ListNode(7, "7",
                                                        null))))));

        oddEvenList(list1);
    }

    public static ListNode oddEvenList(ListNode head) {
        ListNode preHead = new ListNode(-1);
        preHead.next=head;
        if (head.next == null || head.next.next == null) return head;
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);
        ListNode preOdd = odd;
        ListNode preEven = even;

        Queue<ListNode> listNodeQueue = new LinkedList<>();

        while (head != null) {
            listNodeQueue.offer(head);
            head = head.next;
        }
        boolean sizeOdd = (listNodeQueue.size() & 1) == 0;
        int index = 0;
        while (!listNodeQueue.isEmpty()) {
            if ((index & 1) == 0) {
                odd.next = listNodeQueue.poll();
                odd = odd.next;
                if (sizeOdd && odd.next.next == null) odd.next = null;
            } else {
                even.next = listNodeQueue.poll();
                even = even.next;
                if (!sizeOdd && even.next.next == null) even.next = null;
            }
            index++;
        }

        odd.next = preEven.next;
        while (preOdd.next != null) {
            System.out.println(preOdd.next);
            preOdd = preOdd.next;
        }
        while (preHead.next != null) {
            System.out.println(preHead.next);
            preHead = preHead.next;

        }
        /*System.out.println("even");
        while (preEven.next != null) {
            System.out.println(preEven.next);
            preEven = preEven.next;
        }*/
        return null;
    }

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        String name;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, String name, ListNode next) {
            this.val = val;
            this.name = name;
            this.next = next;
        }

        public ListNode(int val, String name) {
            this.val = val;
            this.name = name;
        }

        @Override
        public String toString() {
            return "name-> " + name + " value= " + val;
        }

    }
}
