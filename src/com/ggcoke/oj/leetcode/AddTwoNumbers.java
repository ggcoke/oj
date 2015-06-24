package com.ggcoke.oj.leetcode;

/**
 * @author GGCoke <ggcoke@foxmail.com>
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode current = null;
        int x, y, sum, carry = 0;
        while (l1 != null || l2 != null) {
            x = l1 == null ? 0 : l1.val;
            y = l2 == null ? 0 : l2.val;

            sum = x + y + carry;
            ListNode node = buildListNode(sum % 10);

            if (result == null) {
                result = current = node;
            } else {
                current.next = node;
                current = node;
            }
            carry = sum / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (carry > 0) {
            ListNode node = buildListNode(carry);
            current.next = node;
        }

        return result;
    }

    public ListNode buildListNode(int x) {
        ListNode node = new ListNode(x);
        node.next = null;

        return node;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
