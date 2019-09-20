package linkedList;

import java.util.*;

/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:
Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
 */
public class LC23_MergeKSortedList {
    //BruteForce
//    public static ListNode mergeKLists(ListNode[] lists) {
//
//        if (lists.length == 1) {
//            return lists[0];
//        }
//
//
//        ListNode listNode = new ListNode(Integer.MIN_VALUE);
//        ListNode resultNode = listNode;
//        boolean notToBreak = true;
//        while (notToBreak) {
//
//            int minimumValue = Integer.MAX_VALUE;
//            boolean allNull = true;
//            int indexToBeIncrement = -1;
//            for (int i = 0; i < lists.length; i++) {
//                if (lists[i] != null) {
//                    if (lists[i].val < minimumValue) {
//                        indexToBeIncrement = i;
//                        minimumValue = lists[i].val;
//                    }
//                    allNull = false;
//                }
//            }
//
//            if (allNull) {
//                notToBreak = false;
//            } else {
//                listNode.next = lists[indexToBeIncrement];
//                lists[indexToBeIncrement] = lists[indexToBeIncrement].next;
//                listNode = listNode.next;
//
//            }
//        }
//
//
//        return resultNode.next;
//    }


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        return mergeKLists(lists, 0, lists.length - 1);


    }

    private ListNode mergeKLists(ListNode[] lists, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return lists[left];
        }
        if (left == right - 1) {
            return mergeTwoLists(lists[left], lists[right]);
        } else {
            int mid = (left + right) / 2;
            return mergeTwoLists(mergeKLists(lists, left, mid), mergeKLists(lists, mid + 1, right));
        }

    }

    private ListNode mergeTwoLists(ListNode first, ListNode second) {

        ListNode mergedTwoList = new ListNode(Integer.MIN_VALUE);
        ListNode head = mergedTwoList;

        while (first != null && second != null) {
            if (first.val < second.val) {
                mergedTwoList.next = first;
                first = first.next;
            } else {
                mergedTwoList.next = second;
                second = second.next;
            }

            mergedTwoList = mergedTwoList.next;
        }

        if (first != null) {
            mergedTwoList.next = first;
        } else {
            mergedTwoList.next = second;
        }

        return head.next;
    }


    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        first.next = new ListNode(4);
        first.next.next = new ListNode(5);

        ListNode second = new ListNode(1);
        second.next = new ListNode(3);
        second.next.next = new ListNode(4);

        ListNode third = new ListNode(2);
        third.next = new ListNode(6);

        ListNode[] lists = new ListNode[3];
        lists[0] = first;
        lists[1] = second;
        lists[2] = third;

        ListNode listNode = new LC23_MergeKSortedList().mergeKLists(lists);
        listNode.print();


    }

}
