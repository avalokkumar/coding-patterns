package fast_and_slow_pointers;


import java.util.Stack;

/**
 * Palindrome Linked List
 * For the given head of the linked list, find out if the linked list is a palindrome or not. Return TRUE if the linked list is a palindrome. Otherwise, return FALSE.
 *
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {
        // Test Case 1: positive scenario
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(2);
        head.next.next.next.next = new LinkedListNode(1);
        boolean isPalindrome = isPalindrome(head);
        System.out.println("Test Case 1: Linked List is palindrome: " + isPalindrome);

        // Test Case 2: negative scenario
        LinkedListNode head2 = new LinkedListNode(1);
        head2.next = new LinkedListNode(2);
        head2.next.next = new LinkedListNode(3);
        head2.next.next.next = new LinkedListNode(4);
        head2.next.next.next.next = new LinkedListNode(5);
        boolean isPalindrome2 = isPalindrome(head2);
        System.out.println("Test Case 2: Linked List is palindrome: " + isPalindrome2);
    }


    public static boolean isPalindrome(LinkedListNode head) {
        LinkedListNode slow = head, fast = head;
        Stack<Integer> stack = new Stack<>();

        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) { // if the linked list is odd, skip the middle element
            slow = slow.next;
        }

        while (slow != null) {
            if (stack.pop() != slow.data) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

}
