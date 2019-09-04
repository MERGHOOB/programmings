package linkedList;


public class LC_19_RemoveNthNodeFromLinkedList {


    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode requiredNode;
        ListNode currentNode = head;
        while (n != 0) {
            currentNode = currentNode.next;
            n--;
        }
        if (currentNode == null) {

            return head.next;
        }
        requiredNode = head;
        ListNode prevNode = null;
        while (currentNode != null) {
            prevNode = requiredNode;
            requiredNode = requiredNode.next;
            currentNode = currentNode.next;
        }

        prevNode.next = requiredNode.next;
        return head;
    }

    public static void main(String[] args) {

        int n = 2;
        ListNode first = new ListNode(1);
        first.next = new ListNode(2);
        first.next.next = new ListNode(3);
        first.next.next.next = new ListNode(4);
        first.next.next.next.next = new ListNode(5);

        first.print(new LC_19_RemoveNthNodeFromLinkedList().removeNthFromEnd(first, n));

    }


}
