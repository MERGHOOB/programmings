package newsession;

import linkedList.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 1) {
            return lists[0];
        }

        ListNode head = new ListNode(Integer.MIN_VALUE); // temp head, will return head.next;
        ListNode temp = head;
        while (true) {
            int minIndex = findMinIndex(lists);
            if (minIndex == -1) {
                break;
            }
            temp.next = lists[minIndex];
            lists[minIndex] = lists[minIndex].next;
        }
        return head.next;

    }

    public ListNode mergeKListsUsingQueue(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });

        for (ListNode node : lists) {
            if (node == null) continue;
            pq.add(node);
        }
        ListNode head = new ListNode(Integer.MIN_VALUE);
        while (!pq.isEmpty()) {
            ListNode poll = pq.poll();
            head.next = poll;
            poll = poll.next;
            if (poll != null) {
                pq.add(poll);
            }
        }
        return head.next;

    }

    private int findMinIndex(ListNode[] lists) {
        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }
            if (minValue > lists[i].val) {
                minValue = lists[i].val;
                minIndex = i;
            }
        }
        return minIndex;
    }
}
