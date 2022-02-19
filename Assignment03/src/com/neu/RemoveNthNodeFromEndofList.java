package com.neu;

public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int len = 0;
        ListNode cur = head;
        while(cur != null){
            len++;
            cur = cur.next;
        }
        ListNode dummy = new ListNode(0,head);
        cur = dummy;
        for (int i = 1; i < len - n + 1; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode res = dummy.next;
        return res;
    }
}
