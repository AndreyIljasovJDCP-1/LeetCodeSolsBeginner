package leetcode.medium;

/**
 * @link <a href="https://leetcode.com/problems/odd-even-linked-list/?envType=study-plan-v2&envId=leetcode-75">
 *     328. Odd Even Linked List</a>
 */
public class ListNodeOddEven {

    public static void main(String[] args) {
        var list1 = new ListNode(1, "1",
                new ListNode(2, "2",
                        new ListNode(3, "3",
                                new ListNode(4, "4",
                                        new ListNode(5, "5",
                                                new ListNode(6, "6",
                                                        // new ListNode(7, "7",
                                                        null))))));

        oddEvenList(list1);
    }

    public static ListNode oddEvenList(ListNode head) {
        ListNode preOdd = new ListNode(-1);
        ListNode preEven = new ListNode(-1);

        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);


        preOdd.next = odd;
        preEven.next = even;

        int count = 0;
        while (head != null) {


            if (head.next.next == null) {
                odd.next = head;
                odd = odd.next;
                odd.next = null;
                even.next = head.next;
                break;
            }


            odd.next = head;
            odd = odd.next;
            even.next = head.next;
            even = even.next;
            head = head.next.next;
            count++;

        }

        while (preOdd.next != null) {
            preOdd = preOdd.next;
            System.out.println(preOdd.next);

        }
        System.out.println("even");
        while (preEven.next != null) {
            preEven = preEven.next;
            System.out.println(preEven.next);

        }

        return null;
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
        while (preHead != null) {
            preHead = preHead.next;
            length++;
        }
        if (length == 1) return null;
        ListNode delete = head;
        int middle = length / 2 - 1;
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
