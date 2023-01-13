package fast_and_slow_pointers;

import java.util.HashSet;
import java.util.Set;

/**
 * Happy Number
 *
 * Write an algorithm to determine if a number n
 * n is happy.
 *
 * A happy number is a number defined by the following process:
 *
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1
 * 1
 *  (where it will stay), or it loops endlessly in a cycle which does not include 1
 * 1
 * .
 * Those numbers for which this process ends in 1
 * 1
 *  are happy.
 * Return TRUE if n
 * n
 *  is a happy number, and FALSE if not.
 */
public class HappyNumbers {

    public static void main(String[] args) {
        // Test Case 1: positive scenario
        int n = 19;
        boolean isHappy = isHappy(n);
        System.out.println("Test Case 1: Number " + n + " is happy: " + isHappy);

        // Test Case 2: negative scenario
        int n2 = 20;
        boolean isHappy2 = isHappy(n2);
        System.out.println("Test Case 2: Number " + n2 + " is happy: " + isHappy2);
    }


    /**
     * This solution uses Floyd's Cycle-Finding Algorithm. It uses two pointers, slow and fast, and the idea is that if a loop exists, the fast pointer will eventually catch up to the slow pointer. When they meet, if the value is 1, the number is happy otherwise it is not.
     *
     * It's an O(1) space complexity solution as it does not use any additional data structure to store seen numbers.
     *
     * I will make sure to include detailed inline comments for all the upcoming solutions that I provide to help you better understand the solution.
     * @param n
     * @return
     */
    public static boolean isHappy(int n) {
        int slow = n, fast = n;
        // use two pointers, slow and fast,
        do {
            slow = nextNumber(slow); // move the slow pointer one step
            fast = nextNumber(nextNumber(fast)); // move the fast pointer two steps
        } while (slow != fast); // if there is a loop, the fast pointer will eventually catch up to the slow pointer

        return slow == 1; // if the value is 1, the number is happy otherwise it is not
    }

    public static boolean isHappyBruteForce(int n) {
        Set<Integer> seen = new HashSet<>();
        // loop through the process until the number equals 1 or it loops endlessly in a cycle
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = nextNumber(n);
        }
        // return true if the number equals 1, false otherwise
        return n == 1;
    }

    private static int nextNumber(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

}
