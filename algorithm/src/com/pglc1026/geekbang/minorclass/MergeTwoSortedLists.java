package com.pglc1026.geekbang.minorclass;

/**
 * leetcode-21: https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * MergeTwoSortedLists
 *
 * @author Liu Chang
 * @date 2020/1/13
 */
public class MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val > l2.val) {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode merge = mergeTwoLists(l1, l2);

        while (merge != null) {
            System.out.println(merge.val);
            merge = merge.next;
        }
    }





    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

}
