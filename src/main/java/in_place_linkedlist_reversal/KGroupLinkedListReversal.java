package in_place_linkedlist_reversal;

/**
 * Reverse Nodes in k-Group
 * <p>
 * Given a linked list, reverse the nodes of the linked list k
 * at a time and return the modified list. Here, k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k
 * k
 * , the nodes left in the end will remain in their original order.
 * <p>
 * You can’t alter the values of the linked list nodes. Only the nodes themselves may be changed.
 * <p>
 * Note: Use only O(1)
 * extra memory space.
 */
public class KGroupLinkedListReversal {

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);
        System.out.println("Original List:");
        LinkedListNode.printList(head);
        head = reverseKGroup(head, 2);
        System.out.println("\nReversed List: ");
        LinkedListNode.printList(head);
    }


    public static LinkedListNode reverseKGroup(LinkedListNode head, int k) {
        // Edge case: if k is less than or equal to 1, return the original list
        if (k <= 1 || head == null) return head;

        // Initialize dummy node to act as starting point for reversed sublists
        LinkedListNode dummy = new LinkedListNode(0);
        dummy.next = head;

        // Initialize pointers for start and end of sublist to reverse
        LinkedListNode start = dummy, end = dummy;

        // Iterate through the linked list
        while (end.next != null) {
            int count = k;
            // Move end pointer to kth position
            while (count > 0 && end != null) {
                end = end.next;
                count--;
            }
            // If end pointer becomes null, break the loop
            if (end == null) break;
            // Save next pointers of start and end nodes
            LinkedListNode nextStart = start.next;
            LinkedListNode nextEnd = end.next;
            // Break link between end and next node
            end.next = null;
            // Reverse sublist between start and end pointers
            start.next = reverse(start.next);
            // Connect start of reversed sublist with next element of end of reversed sublist
            nextStart.next = nextEnd;
            // Move start and end pointers to next sublist
            start = nextStart;
            end = nextStart;
        }

        return dummy.next;
    }

    // Helper function to reverse a sublist
    private static LinkedListNode reverse(LinkedListNode head) {
        LinkedListNode prev = null;
        LinkedListNode current = head;
        while (current != null) {
            LinkedListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

}
