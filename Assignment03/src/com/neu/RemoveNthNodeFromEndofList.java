package com.neu;

public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head.next == null) return null;
        int size = getLength(head);
        if(n <= 0 || n > size){
            return head;
        }
        ListNode cur = head.next;
        for(int i = 0; i< size - n -1; i++){
            cur = cur.next;
        }

        cur.next = cur.next.next;

        return head;

    }
    static int getLength(ListNode head){
        if(head.next == null) return 0;
        int length = 0;
        ListNode curr = head.next;
        while(curr!=null){
            length++;
            curr = curr.next;
        }
        return length;
    }

}
