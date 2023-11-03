package leetcode.medium;

/**
 * @link <a href="https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/?envType=study-plan-v2&envId=leetcode-75">
 *     2095. Delete the Middle Node of a Linked List</a>
 *
 */
public class ListNodeDeleteMiddle {
    public static void main(String[] args) {
        var list1 = new ListNode(1, "1",
                new ListNode(3, "2",
                        new ListNode(4, "3",
                                new ListNode(7, "4",
                                        new ListNode(1, "5",
                                                //new ListNode(2, "6",
                                                null)))));

        deleteMiddleBest(list1);
    }

    public static ListNode deleteMiddle(ListNode head) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        System.out.println("length " + length);
        ListNode preDelete = new ListNode(-1);
        ListNode delete = preDelete;
        int middle = ((length & 1) == 0) ? (length + 1) / 2 : length / 2;
        System.out.println("middle " + middle);
        while (preHead.next != null) {
            if (middle == 0) {
                preHead = preHead.next.next;
            } else {
                preHead = preHead.next;
            }
            delete.next = preHead;
            delete = delete.next;
            middle--;
            if (preHead == null) break;
        }

        while (preDelete.next != null) {
            System.out.println(preDelete.next);
            preDelete = preDelete.next;
        }
        return head;

    }

    public static ListNode deleteMiddleBest(ListNode head) {
        ListNode preHead = head;
        int length = 0;
        while (preHead!= null) {
            preHead = preHead.next;
            length++;
        }
        if(length == 1)  return null;
        ListNode delete = head;
        int middle =  length / 2 - 1;
        while (middle > 0) {
            delete = delete.next;
            middle--;
        }
        delete.next = delete.next.next;
        return head;
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
