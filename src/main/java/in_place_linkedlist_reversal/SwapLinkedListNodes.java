package in_place_linkedlist_reversal;

/**
 * Swapping Nodes in a Linked List
 * Given the linked list and an integer k
 * , return the head of the linked list after swapping the values of the kth
 *  node from the beginning and the k^{th}
 * k
 * th
 *
 *  node from the end of the linked list.
 *
 * Note: We’ll number the nodes of the linked list starting from 1  to n
 */
public class SwapLinkedListNodes {

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);

        int k = 2;
        head = swapNodes(head, k);
        LinkedListNode.printList(head);
    }

    // function to swap kth node from beginning and kth node from end
    public static LinkedListNode swapNodes(LinkedListNode head, int k) {
        // Edge cases:
        if (head == null || head.next == null) return head;
        if (k < 1) return head;

        // Initialize pointers
        LinkedListNode curr = head;
        LinkedListNode prev = null;
        LinkedListNode end = head;
        LinkedListNode endPrev = null;

        // Finding kth node from beginning and end of the list
        int i = 1;
        while (i < k && curr != null) {
            prev = curr;
            curr = curr.next;
            i++;
        }

        if (curr == null) return head;

        while (end.next != null) {
            endPrev = end;
            end = end.next;
        }

        if (curr == end) return head;

        // swapping values of kth node from beginning and end
        int temp = curr.data;
        curr.data = end.data;
        end.data = temp;

        return head;
    }

    /**
     * n the above solution, we are swapping the kth node from the beginning and kth node from the end of the linked list.
     * We first initialize pointers to head, end and prev pointers. Then we traverse the list to find kth node from the beginning and kth node from the end.
     * Then we swap the values of kth node from beginning and end.
     * In the main method, I have created a sample linked list and swapped 2nd node from the beginning and end.
     *
     * This solution has a time complexity of O(n) and space complexity of O(1) as we are using only a few pointers and traversing the list only once.
     */
}
