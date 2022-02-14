package com.neu;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

//对于链表问题，返回结果为头结点时，通常需要先初始化一个预先指针 pre，该指针的下一个节点指向真正的头结点head。
//使用预先指针的目的在于链表初始化时无可用节点值，而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果。
public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0); //记录的
        ListNode curr = pre; //头结点
        int carry = 0;//记录进位值
        while(l1 != null || l2 != null){
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + carry;

            carry = sum / 10;//先算carry 先算是否进位
            sum = sum % 10; // 再算取余


            curr.next = new ListNode(sum);// curr指针的下一个节点
            curr = curr.next;
            // l1和l2后移
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        // 最后一位需要进位的情况
        if(carry == 1){
            curr.next = new ListNode(carry);
        }
        return pre.next;
    }
}
