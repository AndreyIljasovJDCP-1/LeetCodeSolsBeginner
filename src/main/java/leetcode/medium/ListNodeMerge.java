package leetcode.medium;
/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list.
 * The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 */
public class ListNodeMerge {
    public static void main(String[] args) {
        System.out.println(2 << 3);
        ListNode list1 = new ListNode(1, "list1-1",
                new ListNode(2, "list1-2",
                        new ListNode(4))
        );
        ListNode list2 = new ListNode(1, "list2-1",
                new ListNode(2, "list2-2",
                        new ListNode(4))
        );
        mergeTwoLists(list1, list2);
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode preHead = new ListNode(-1);
        ListNode head = preHead;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                head.next = list1;
                list1 = list1.next;

            } else {
                head.next = list2;
                list2 = list2.next;

            }
            head = head.next;
        }
        head.next = list1 == null ? list2 : list1;

        while (preHead.next != null) {
            System.out.println(preHead.next);
            preHead = preHead.next;
        }
        return null;
    }

    public static ListNode mergeTwoListsDistinct(ListNode list1, ListNode list2) {
        ListNode head1 = list1;
        ListNode head2 = list2;
        ListNode headF = null;
        ListNode cur = null;

        if (list1 == null) return list2;

        if (list2 == null) return list1;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                if (headF == null) {
                    headF = head1;
                    cur = head1;
                } else {
                    cur.next = head1;
                    cur = head1;
                }
                head1 = head1.next;

            } else {
                if (headF == null) {
                    headF = head2;
                    cur = head2;
                } else {
                    cur.next = head2;
                    cur = head2;
                }
                head2 = head2.next;
            }
        }

        if (head1 != null) {
            while (head1 != null) {
                cur.next = head1;
                cur = head1;
                head1 = head1.next;
            }
        } else {
            while (head2 != null) {
                cur.next = head2;
                cur = head2;
                head2 = head2.next;
            }
        }
        while (headF.next != null) {
            System.out.println(headF.next);
            headF = headF.next;
        }
        return headF;
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

        @Override
        public String toString() {
            return "name-> " + name + " value= " + val;
        }

    }
}




