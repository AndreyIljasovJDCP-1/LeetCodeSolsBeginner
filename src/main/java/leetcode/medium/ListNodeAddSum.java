package leetcode.medium;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 */
public class ListNodeAddSum {

    public static void main(String[] args) {
        MyListNode list1 = new MyListNode(9, "list1-1",
                new MyListNode(9, "list1-2",
                        new MyListNode(3))
        );
        MyListNode list2 = new MyListNode(5, "list2-1",
                new MyListNode(6, "list2-2",
                        new MyListNode(9))
        );
        addTwoNumbers(list1, list2);
    }

    public static MyListNode addTwoNumbers(MyListNode l1, MyListNode l2) {
        MyListNode preHead = new MyListNode(-1);
        MyListNode head = preHead;
        int extra = 0;
        while (l1 != null || l2 != null) {
            int value = 0;
            if (l1 != null) {
                value += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                value += l2.val;
                l2 = l2.next;
            }
            value += extra;
            extra = value / 10;
            value = value % 10;
            head.next = new MyListNode(value);
            head = head.next;
        }
        if (extra > 0) {
            head.next = new MyListNode(extra);
        }
        while (preHead.next != null) {
            System.out.println(preHead.next);
            preHead = preHead.next;
        }

        //return preHead.next;
        return head;
    }

    static class MyListNode {
        int val;
        String name;
        MyListNode next;

        MyListNode() {
        }

        MyListNode(int val) {
            this.val = val;
        }

        MyListNode(int val, String name, MyListNode next) {
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
