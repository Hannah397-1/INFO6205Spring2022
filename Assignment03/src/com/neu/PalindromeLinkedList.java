package com.neu;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        //判空
        if(head == null || head.next == null) return true;
        //找中点
        ListNode before = mid(head);
        ListNode after = before.next;
        before.next = null;
        //翻转后半部分
        after = reverse(after);
        //比较
        boolean res = compare(head, after);
        //连起来
        before.next = reverse(after);
        return res;
    }

    //快慢指针 找链表中点 快=慢*2
    ListNode mid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //翻转
    ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    //compare linkedlist
    boolean compare(ListNode A, ListNode B) {
        while(B != null) {
            if(A.val != B.val) return false;
            A = A.next;
            B = B.next;
        }
        return true;
    }

}
