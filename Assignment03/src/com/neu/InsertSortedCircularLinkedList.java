package com.neu;

public class InsertSortedCircularLinkedList {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        // 顺着 head  往下找，先找到最小值的位置
        Node cur = head;
        while (cur.val <= cur.next.val && cur.next != head) {
            cur = cur.next;
        }
        Node max = cur;
        if (insertVal <= max.next.val || insertVal >= max.val) {
            Node min = max.next;
            max.next = new Node(insertVal);
            max.next.next = min;
            return head;
        }
        cur = cur.next;
        // 从最小值开始遍历，找到插入位置
        while (cur.val > insertVal || cur.next.val < insertVal) cur = cur.next;
        Node next = cur.next;
        cur.next = new Node(insertVal);
        cur.next.next = next;
        return head;

    }
}
