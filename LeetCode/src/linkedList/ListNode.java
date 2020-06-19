package linkedList;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    public void print(ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode.val + " -> ");
            listNode = listNode.next;
        }
        System.out.println();
    }

    public void print() {
        print(this);
    }
}
