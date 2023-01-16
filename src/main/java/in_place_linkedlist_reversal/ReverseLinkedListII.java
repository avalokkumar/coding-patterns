package in_place_linkedlist_reversal;

/**Reverse Linked List II
 * You’re given the head of a singly linked list with n
 * n nodes and two positive integers, left and right. Our task is to reverse the list’s nodes from position left to position right and return the reversed list.
 *
 */
public class ReverseLinkedListII {

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);

        int left = 2;
        int right = 4;

        LinkedListNode newHead = reverseLinkedListII(head, left, right);
        LinkedListNode.printList(newHead); // 1 4 3 2 5
    }

    public static LinkedListNode reverseLinkedListII(LinkedListNode head, int left, int right) {
        // Edge case: if head is null or left is greater than right
        if (head == null || left > right) {
            return head;
        }

        // Create a dummy node to keep track of the previous node
        LinkedListNode dummy = new LinkedListNode(0);
        dummy.next = head;
        LinkedListNode prev = dummy;

        // Move the prev pointer to the (left-1)th node
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        // Reverse the sublist from the left to right
        LinkedListNode curr = prev.next;
        for (int i = 0; i < right - left; i++) {
            LinkedListNode nextNode = curr.next;
            curr.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
        }

        return dummy.next;
    }

    /**
     * The above solution uses a dummy node to keep track of the previous node before the sublist to be reversed, and a pointer prev to traverse the list until the (left-1)th node. Then, we reverse the sublist from the left to right by adjusting the next pointers of the current node, the next node, and the previous node. Finally, we return the modified list, starting from the dummy node's next. Note that we also check for the edge cases where the head is null or the left index is greater than the right index, in which case we return the original list as it is.
     */
}
