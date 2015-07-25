package com.ggcoke.oj.leetcode;

import java.util.Random;

/**
 * @author Wang Huisong <wanghuisong@letv.com>
 */
public class DeleteNode {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }

        node.val = node.next.val;
        node.next = node.next.next;
    }

    public ListNode buildNode(int val) {
        ListNode node = new ListNode(val);
        node.next = null;

        return node;
    }

    public ListNode initNodeList(int count) {
        if (count <= 0) {
            return null;
        }

        Random random = new Random();

        ListNode head = buildNode(Math.abs(random.nextInt() % (10 * count)));
        ListNode current = head;

        for (int index = 1; index < count; index++) {
            ListNode node = buildNode(Math.abs(random.nextInt() % (10 * count)));
            current.next = node;
            current = node;
        }

        return head;
    }

    public ListNode cherryNode2Delete(ListNode head, int count) {
        if (head == null) {
            return null;
        }

        Random random = new Random();
        int index = Math.abs(random.nextInt() % (count -1));

        ListNode current = head;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }

        return current;
    }

    public void printNodeList(ListNode head) {
        if (head == null) {
            System.out.println("ListNode is EMPTY!");
        }

        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }

        System.out.println("EOL");
    }

    private static final int COUNT_OF_NODE = 8;

    public static void main(String[] args) {
        DeleteNode test = new DeleteNode();
        ListNode nodeList = test.initNodeList(COUNT_OF_NODE);

        System.out.println("Before delete node: ");
        test.printNodeList(nodeList);

        ListNode node2Delete = test.cherryNode2Delete(nodeList, COUNT_OF_NODE);
        System.out.println("Node to delete is " + node2Delete.val);

        test.deleteNode(node2Delete);

        System.out.println("After delete node: ");
        test.printNodeList(nodeList);
    }

}
