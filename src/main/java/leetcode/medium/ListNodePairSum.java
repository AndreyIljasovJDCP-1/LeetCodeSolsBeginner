package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 *  @link <a href="https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/?envType=study-plan-v2&envId=leetcode-75">
 *      2130. Maximum Twin Sum of a Linked List
 *      </a>
 *  В связанном списке размером n, где n четно , узел ( с индексом 0 )
 *  связанного списка известен как двойник узла ,
 *  если : ith(n-1-i)th0 <= i <= (n / 2) - 1
 *  Например,
 *  если n = 4, то узел 0 является двойником узла 3,
 *  а узел 1 является двойником узла 2.
 *  Это единственные узлы с двойниками для n = 4.
 *  Сумма близнецов определяется как сумма узла и его двойника.
 *  Учитывая headсвязанный список четной длины, верните максимальную сумму двойников связанного списка .
 */
public class ListNodePairSum {
    public static final ListNode HEAD;
    static {
        HEAD = new ListNode(1, "1",
                new ListNode(2, "2",
                        new ListNode(3, "3",
                                new ListNode(4, "4",
                                        new ListNode(5, "5",
                                                new ListNode(6, "6",
                                                        //new ListNode(7, "7",
                                                        null))))));
    }
    public static void main(String[] args) {
        System.out.println(pairSum(HEAD));
    }

    public static int pairSum(ListNode head) {
        List<Integer> nodeValues = new ArrayList<>();
        while (head != null) {
            ListNode node = head;
            nodeValues.add(node.val);
            head = head.next;
        }

        int middle = nodeValues.size()/2-1;
        System.out.println(middle);
        System.out.println(nodeValues);
        int max = -1;
        int n = nodeValues.size();
        for (int i = 0; i <= middle; i++){
            int sum = nodeValues.get(i) + nodeValues.get(n-i-1);
            max = Math.max(sum, max);
        }
        System.out.println(max);
        return max;
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
