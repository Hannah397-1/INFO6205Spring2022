package com.neu;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        if(head == null) return null;
        ListNode cur = head;
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        //记录所有节点出现的次数
        while(cur != null){
            map.put(cur.val, map.getOrDefault(cur.val, 0) + 1);
            cur = cur.next;
        }
        //出现一次的拿出来组成新链表
        while(head != null){
            if(map.get(head.val) == 1){
                node.next = new ListNode(head.val);
                node = node.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}
