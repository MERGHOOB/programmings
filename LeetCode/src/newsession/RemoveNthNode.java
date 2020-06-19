package newsession;

import linkedList.ListNode;

public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {

       if(n== 0) {
           return head;
       }

       ListNode right = head;
       for(int i = 1; i<= n; i++) {
           right = right.next;
       }
       ListNode left = head, prev = null;

       while(right != null) {
           right = right.next;
           prev = left;
           left = left.next;
       }
       if(prev != null) {
           prev.next = left.next;
       }
       else {
           return head.next;
       }
        return head;
    }

    public static void main(String[] args) {

        int n = 2;
        ListNode first = new ListNode(1);
        first.next = new ListNode(2);
        first.next.next = new ListNode(3);
        first.next.next.next = new ListNode(4);
        first.next.next.next.next = new ListNode(5);

        first.print(new RemoveNthNode().removeNthFromEnd(first, n));

    }

}
