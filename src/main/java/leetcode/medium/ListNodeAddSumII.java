package leetcode.medium;

import java.util.Stack;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 */
public class ListNodeAddSumII {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(7, "list1-0",
                new ListNode(2, "list1-1",
                        new ListNode(4, "list1-2",
                                new ListNode(3))
                ));
        ListNode list2 = new ListNode(5, "list2-1",
                new ListNode(6, "list2-2",
                        new ListNode(4))
        );
       /* ListNode list1 = new ListNode(5);
        ListNode list2 = new ListNode(5);*/
        addTwoNumbersStack(list1, list2);
    }

    public static ListNode addTwoNumbersStack(ListNode l1, ListNode l2) {
        Stack<Integer> stackFirst=new Stack<>();
        Stack<Integer> stackSecond=new Stack<>();

        while (l1 != null) {
            stackFirst.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stackSecond.push( l2.val);
            l2 = l2.next;
        }

        ListNode result = null;
        int extra = 0;
        while (!stackFirst.empty() || !stackSecond.empty()||extra==1) {
            int value = 0;
            if (!stackFirst.empty()) {
                value += stackFirst.pop();
            }
            if (!stackSecond.empty()) {
                value += stackSecond.pop();
            }
            value += extra;
            extra = value / 10;
            value = value % 10;
            ListNode newNode = new ListNode(value);
            newNode.next = result;
            result = newNode;
        }

        /*while (result != null) {
            System.out.println(result);
            result = result.next;
        }*/


        return result;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb = new StringBuilder();
        while (l1 != null) {
            sb.insert(0, l1.val);
            l1 = l1.next;
        }
        String first = sb.toString();
        sb = new StringBuilder();
        while (l2 != null) {
            sb.insert(0, l2.val);
            l2 = l2.next;
        }
        String second = sb.toString();
        System.out.println(first);
        System.out.println(second);
        int iFirst = 0;
        int iSecond = 0;
        sb = new StringBuilder();
        int extra = 0;
        while (iFirst < first.length() || iSecond < second.length() ||extra==1) {
            int value = 0;
            if (iFirst < first.length()) {
                value += first.charAt(iFirst++) - '0';
            }
            if (iSecond < second.length()) {
                value += second.charAt(iSecond++) - '0';
            }
            value += extra;
            extra = value / 10;
            value = value % 10;
            sb.insert(0, value);
        }
        System.out.println(sb);
        String result = sb.toString();
        ListNode fooHead = new ListNode(-1);
        ListNode res = fooHead;
        for (int i = 0; i < result.length(); i++) {
            res.next = new ListNode(result.charAt(i) - '0');
            res = res.next;
        }
        while (fooHead.next != null) {
            System.out.println(fooHead.next);
            fooHead = fooHead.next;
        }


        return res;
    }

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

        @Override
        public String toString() {
            return "name-> " + name + " value= " + val;
        }
    }
}
