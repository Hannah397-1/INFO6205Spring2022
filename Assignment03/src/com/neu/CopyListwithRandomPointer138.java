package com.neu;

import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

//主要是random指针
class CopyListwithRandomPointer138 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;//判空
        HashMap<Node, Node> map = new HashMap<>();//定义key和value域都为节点类型的哈希表
        Node cur = head;//定义一个cur节点
        while (cur != null) {//第一次遍历链表
            //遍历原链表时，只要cur不为空，就new一个新节点，值与原链表的一样
            //而next域和随机指针域初始值为null
            Node node = new Node(cur.val);
            map.put(cur, node);//建立一个链表，让原链表的cur值作为key，让新链表对应位置的node值作为value
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
