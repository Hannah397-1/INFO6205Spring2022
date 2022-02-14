package com.neu;

import java.util.ArrayList;
import java.util.List;

public class ReoderList {
    public void reorderList(ListNode head) {
        List<ListNode> list =new ArrayList<ListNode>();
        ListNode p=head;
        // 节点保存到链表
        while(p!=null){
            list.add(p);
            p=p.next;
        }
        List<ListNode> newlist = new ArrayList<ListNode>();
        int left = 0;
        int right = list.size()-1;
        int flag = 0;
        // 重排
        while(left<=right){
            if(flag == 0){
                newlist.add(list.get(left));
                left++;
                flag = 1;
            }else {
                newlist.add(list.get(right));
                right--;
                flag = 0;
            }
        }
        ListNode newhead=newlist.get(0);
        for(int i=0;i<newlist.size()-1;i++){
            newhead.next = newlist.get(i+1);
            newhead = newhead.next;
        }
        newhead.next = null;
    }
}
