package in_place_linkedlist_reversal;


/**
 * Swap Nodes in Pairs
 * Given a singly linked list, swap every two adjacent nodes of the linked list. After the swap, return the head of the linked list.
 *
 * Note: Solve the problem without modifying the values in the list’s nodes. In other words, only the nodes themselves can be changed.
 */
public class SwapNodesInPairs {

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);

        System.out.println("Original Linked List:");
        LinkedListNode.printList(head);

        head = swapNodesInPairs(head);

        System.out.println("\nLinked List After Swapping Nodes in Pairs:");
        LinkedListNode.printList(head);
    }

    public static LinkedListNode swapNodesInPairs(LinkedListNode head) {
        LinkedListNode dummy = new LinkedListNode(0);
        dummy.next = head;
        LinkedListNode current = dummy;

        while (current.next != null && current.next.next != null) {
            // We will be swapping the next two nodes
            LinkedListNode firstNode = current.next;
            LinkedListNode secondNode = current.next.next;

            // Performing the swap
            firstNode.next = secondNode.next;
            current.next = secondNode;
            current.next.next = firstNode;

            // Move the current pointer to the next pair
            current = current.next.next;
        }

        return dummy.next;
    }

    /**
     * This solution has O(n) time complexity, where n is the number of nodes in the linked list. It iterates through the linked list and swaps each pair of nodes in place by adjusting the pointers. The dummy node is used as the new head of the linked list after the swap.
     *
     * In the main method, we have created a linked list of 5 elements, and then we have called the swapNodesInPairs method passing the head of the linked list as an argument, which will return the new head of the linked list after swapping the nodes in pairs.
     */
}
