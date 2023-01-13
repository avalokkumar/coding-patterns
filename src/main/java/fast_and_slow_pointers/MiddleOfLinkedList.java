package fast_and_slow_pointers;

/**
 * Middle of the Linked List
 *
 * Given a singly linked list, return the middle node of the linked list. If the number of nodes in the linked list is even, return the second middle node.
 *
 */
public class MiddleOfLinkedList {

    public static void main(String[] args) {
        // Test Case 1: positive scenario
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);

        LinkedListNode middle = middleNode(head);
        System.out.println("Test Case 1: Middle of the linked list: " + middle.data);

        // Test Case 2: negative scenario
        LinkedListNode head2 = new LinkedListNode(1);
        head2.next = new LinkedListNode(2);
        head2.next.next = new LinkedListNode(3);
        head2.next.next.next = new LinkedListNode(4);

        LinkedListNode middle2 = middleNode(head2);
        System.out.println("Test Case 2: Middle of the linked list: " + middle2.data);
    }


    public static LinkedListNode middleNode(LinkedListNode head) {
        LinkedListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
