package com.neu;

import java.util.PriorityQueue;


public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        //判空
        if (lists == null || lists.length == 0) {
            return null;
        }
        //虚拟头节点
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        //优先级队列，最小堆，找出当前最小的节点
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
        //将所有链表的头节点加入最小堆
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        //取出最小节点，加入该节点的后继节点
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
            if (cur.next != null) {
                queue.add(cur.next);
            }

        }
        return head.next;
    }
}


//public class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode() {
//    }
//
//    ListNode(int val) {
//        this.val = val;
//    }
//
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}
