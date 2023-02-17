package k_way_merge;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge K Sorted Lists
 *
 * Given an array of k sorted linked lists, your task is to merge them into a single sorted list.
 */
public class MergeKList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);

        ListNode[] lists = {node1, node2, node3};
        ListNode result = mergeKLists(lists);
        System.out.print("The merged list is: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Create a priority queue to store the head nodes of all lists
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        // Create a dummy node as the head of the merged listx
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Keep polling the smallest node from the priority queue and adding it to the tail of the merged list
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            tail.next = node;
            tail = tail.next;

            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}
