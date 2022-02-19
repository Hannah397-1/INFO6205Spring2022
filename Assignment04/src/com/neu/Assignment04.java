package com.neu;

import java.util.*;

public class Assignment04 {
    public static void main(String[] args) {

    }
    public static class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val){ this.val = val; }
        ListNode(int val, ListNode next){ this.val= val; this.next = next; }
    }


    //Q1 1669. Merge In Between Linked Lists

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head1 = list1;
        ListNode cur1 = head1;
        int i = 0;
        while(i<a-1){
            cur1 = cur1.next;
            i++;
        }
        ListNode pre = cur1;
        //pre -> a的前一个节点
        while(i<= b){
            cur1 = cur1.next;
            i++;
        }
        //cur1 -> b后一个节点
        ListNode head2 = list2;
        ListNode cur2 = head2;
        pre.next = cur2;
        while(cur2.next != null){
            cur2 = cur2.next;
        }
        cur2.next = cur1;
        return head1;
    }


    //Q2 86. Partition List

    public ListNode partition(ListNode head, int x) {
        ListNode SH = null;//小于等于头
        ListNode ST = null;//小于等于尾
        ListNode BH = null;//大于头
        ListNode BT = null;//大于尾

        while(head != null){
            ListNode next = head.next;
            head.next = null;
            if(head.val < x){
                if(SH == null){//是第一个往小于等于区放的
                    SH = head;
                    ST = head;
                }else{
                    ST.next = head;
                    ST = head;// ST = ST.next
                }
            }
            if(head.val >= x){
                if(BH == null){
                    BH = head;
                    BT = head;
                }else{
                    BT.next = head;
                    BT = head;
                }
            }
            head = next;
        }
        if(ST != null){
            if(BT != null){
                ST.next = BH;
                return SH;
            }else{
                ST.next = null;
                return SH;
            }
        }return BH;
    }

    //Q3 2074. Reverse Nodes in Even Length Groups



    //Q4 2058. Find the Minimum and Maximum Number of Nodes Between Critical Points

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] res1 = {-1,-1};
        if(head.next == null || head.next.next == null) return res1;
        ListNode pre = head;
        ListNode cur = head.next;
        int i = 0;
        List<Integer> list = new ArrayList<>();
        while(cur.next != null){
            ListNode nxt = cur.next;
            if((cur.val > pre.val && cur.val > nxt.val)
                    ||(cur.val < pre.val && cur.val < nxt.val)){
                list.add(i);
            }
            pre = cur;
            cur = nxt;
            i++;
        }
        if(list.size() < 2){
            return res1;
        }else if(list.size() == 2){
            int dis = list.get(1) - list.get(0);
            int[]res2 = {dis,dis};
            return res2;
        }else{
            int maxDis = list.get(list.size()-1) - list.get(0);
            int[] arr = new int[list.size() - 1];
            for(i = 0 ; i < arr.length; i++){
                int dis = list.get(i+1) - list.get(i);
                arr[i] = dis;
            }
            Arrays.sort(arr);
            int minDis = arr[0];
            int[] res = {minDis,maxDis};
            return res;
        }
    }


    //Q5 148. Sort List

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        //快慢指针找中点
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast.next!= null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;//右区
        slow.next = null;//左区断开
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode res = merge(left,right);
        return res;
    }
    public ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(left != null && right != null){
            if(left.val <= right.val){
                cur.next = left;
                left = left.next;
            }else{
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left != null ? left : right;
        return dummy.next;
    }


    //Q6 382. Linked List Random Node

    List<Integer> list = new ArrayList<>();
    Random random;

    public Solution(ListNode head) {
        ListNode cur = head;
        while(cur!= null){
            list.add(cur.val);
            cur = cur.next;
        }
    }

    public int getRandom() {
        return list.get((int)(Math.random() * list.size()));
    }


    //Q7 92. Reverse Linked List II
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fPre = dummy;
        for (int i = 0; i < left -1 ; i++){
            fPre = fPre.next;
        }
        ListNode tail = fPre.next;
        ListNode cur = tail.next;
        for(int i = left; i < right; i++){
            ListNode nxt = cur.next;
            cur.next = fPre.next;
            fPre.next = cur;
            cur = nxt;
        }
        tail.next = cur;
        return dummy.next;
    }


    //Q8 725. Split Linked List in Parts

    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode cur = head;
        while(cur != null){
            len++;
            cur = cur.next;
        }
        int n = len/k;//每组n个数
        int a = len%k;//余数

        // 共k组，前边有a组长度为(n+1)的链表
        ListNode[] res = new ListNode[k];

        if(n != 0){
            //前边的a组长度为n+1
            for(int i = 0; i<a; i++){
                cur = head;
                for(int j = 1; j < n+1;j++){//循环完 cur走到n+1的
                    cur = cur.next;
                }
                ListNode nxt = cur.next;
                cur.next = null;
                res[i] = head;
                head = nxt;
            }

            //剩下的每组n个
            for(int i = a; i < k; i++){//不是i<k-1
                cur = head;
                for(int j = 1; j< n; j++){
                    cur = cur.next;
                }
                ListNode nxt = cur.next;
                cur.next = null;
                res[i] = head;
                head = nxt;
            }
            return res;
        }else{
            int i = 0;
            cur = head;
            while(cur!= null){
                ListNode tmp = cur.next;
                cur.next = null;
                res[i] = cur;
                cur = tmp;
                i++;
            }
            for(i= len;i<k;i++){
                res[i] = null;
            }
            return res;
        }
    }


    //Q9 817. Linked List Components

    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i:nums){set.add(i);}

        ListNode cur = head;
        int res = 0;

        while(cur != null){
            if(set.contains(cur.val) &&
                    (cur.next == null || !set.contains(cur.next.val))){
                res++;
            }
            cur = cur.next;
        }
        return res;
    }


    //Q10 2130. Maximum Twin Sum of a Linked List
    
    public int pairSum(ListNode head) {
        if(head == null || head.next == null) return 0;
        if(head.next.next == null) return head.val+head.next.val;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast.next != null && fast.next.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }//slow在中间靠左(0->1->2->3),slow 在1处
        // right右边
        ListNode right = slow.next;
        slow.next = null;
        right = reverse(right);
        ListNode p1 = head;
        ListNode p2 = right;
        int max = 0;
        while(p1 !=null){
            max = ((p1.val+p2.val) > max) ? (p1.val+p2.val) : max;
            p1 = p1.next;
            p2 = p2.next;
        }
        return max;
        // TreeSet<Integer> tSet = new TreeSet<>();
        // while(p1!= null){
        //     tSet.add(p1.val+p2.val);
        //     p1= p1.next;
        //     p2 = p2.next;
        // }
        // // 不需要复原原链表吗？？？
        // // right = reverse(right);
        // // p1.next = right;
        // return tSet.last();
    }
    public ListNode reverse(ListNode head){
        if(head == null) return null;
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null){
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }





}
