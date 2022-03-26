public class Q2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        if(l1 == null && l2 == null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode c1 = l1;
        ListNode c2 = l2;
        int carry = 0;
        while(c1!= null || c2!= null){
            int x = c1 != null ? c1.val: 0;
            int y = c2 != null ? c2.val: 0;
            int sum = x + y + carry;

            sum = sum /10;
            carry = sum % 10;

            cur.next = new ListNode(sum);
            cur = cur.next;
            if(c1 != null) c1= c1.next;
            if(c2 != null) c2 = c2.next;
        }
        if(carry == 1){
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }


//    //------------Test
//    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
//        System.out.println(addTwoNumbers(l1, l2));
//    }

}

class ListNode{
    ListNode head;
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(ListNode head, int val, ListNode next) {
        this.head = head;
        this.val = val;
        this.next = next;
    }
}
