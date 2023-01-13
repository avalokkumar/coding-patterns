package fast_and_slow_pointers;

import java.util.HashSet;
import java.util.Set;

/**
 * Check if a linked list contains a cycle or not. If a cycle exists, return TRUE. Otherwise, return FALSE.
 *
 */
public class LinkedListCycle {

    public static void main(String[] args) {
        // Test Case 1: positive scenario
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = head.next; // creating a cycle

        boolean hasCycle = hasCycle(head);
        System.out.println("Test Case 1: Linked List has cycle: " + hasCycle);

        // Test Case 2: negative scenario
        LinkedListNode head2 = new LinkedListNode(1);
        head2.next = new LinkedListNode(2);
        head2.next.next = new LinkedListNode(3);
        head2.next.next.next = new LinkedListNode(4);

        boolean hasCycle2 = hasCycle(head2);
        System.out.println("Test Case 2: Linked List has cycle: " + hasCycle2);
    }


    /**
     * This solution uses Floyd's cycle-finding algorithm (also known as "tortoise and hare" algorithm) which uses two pointers, one moving at a normal pace and another moving at double the pace. The idea is that if a cycle exists, the fast pointer will eventually catch up to the slow pointer. If the fast pointer reaches the end of the linked list and slow pointer and fast pointer never meet, it means there is no cycle and it will return false.
     *
     * It's an O(n) time complexity solution and O(1) space complexity as it does not use any additional data structure to store seen nodes.
     * @param head
     * @return
     */
    public static boolean hasCycle(LinkedListNode head) {
        LinkedListNode slow = head, fast = head;
        // use two pointers, one moving at a normal pace and another moving at double the pace
        while (fast != null && fast.next != null) {
            // check if fast pointer has reached the end of the linked list
            slow = slow.next; // move the slow pointer one step
            fast = fast.next.next; // move the fast pointer two steps
            if (slow == fast) { // if slow pointer and fast pointer meet, it means there is a cycle
                return true;
            }
        }
        return false;
    }



    public static boolean hasCycleBruteForce(LinkedListNode head) {
        Set<LinkedListNode> seen = new HashSet<>();
        LinkedListNode current = head;
        while (current != null) {
            if (seen.contains(current)) {
                return true;
            }
            seen.add(current);
            current = current.next;
        }
        return false;
    }



}

class LinkedListNode {
    public int data;
    public LinkedListNode next;
    // Constructor will be used to make a LinkedListNode type object
    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}