package linkedList;
/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
 */
public class LC21_MergeTwoSortedList {

    public ListNode mergeTwoLists(ListNode first, ListNode second) {

        ListNode mergedTwoList = new ListNode(Integer.MIN_VALUE);
        ListNode head = mergedTwoList;

        while(first !=null && second !=null) {
            if(first.val < second.val) {
                mergedTwoList.next = first;
                first =first.next;
            }
            else {
                mergedTwoList.next = second;
                second = second.next;
            }

            mergedTwoList = mergedTwoList.next;
        }

        if(first != null) {
            mergedTwoList.next = first;
        }
        else {
            mergedTwoList.next = second;
        }

        return head.next;
    }


}
