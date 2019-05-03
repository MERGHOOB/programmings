
package linkedList;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class LC2AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode first, ListNode second) {

        if(first == null && second == null){
            return null;
        }
        if(first == null)
            return second;

        if(second == null){
            return first;
        }

        int additon = first.val + second.val;
        int toAdd = 0;
        ListNode result = new ListNode(additon%10);
        if(additon > 9) {
            toAdd = 1;
        }
        first = first.next; second = second.next;
        ListNode current = result;

        while(first !=null || second!=null) {

            additon = 0;
            if(first != null) {
                additon +=first.val;
            }
            if(second!=null) {
                additon +=second.val;
            }

            additon +=toAdd;

            if(additon > 9) {
                toAdd = 1;
            }
            else{
                toAdd = 0;
            }
            current.next = new ListNode(additon%10);
            current = current.next;

            if(first!=null) {
                first = first.next;
            }
            if(second!=null) {
                second = second.next;
            }
        }
        if(toAdd == 1){
            current.next = new ListNode(toAdd);
        }
        return result;


    }

    public static void main(String[] args) {
        ListNode first = new ListNode(5);
        first.next = new ListNode(4);
//        first.next.next = new ListNode(6);

        ListNode second = new ListNode(5);
        second.next = new ListNode(6);
        second.next.next = new ListNode(4);

//        new LC2AddTwoNumbers().print(second);

        ListNode listNode = new LC2AddTwoNumbers().addTwoNumbers(first, second);
new LC2AddTwoNumbers().print(listNode);
    }

    public void print(ListNode second) {
        while(second != null) {
            System.out.print(second.val + "->");
            second = second.next;
        }
    }

}

 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }


     public void print() {
         do {
             System.out.print(val + "->");

         }while (this.next != null);
         System.out.println();
      }
 }
