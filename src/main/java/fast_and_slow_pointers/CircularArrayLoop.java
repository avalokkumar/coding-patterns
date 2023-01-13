package fast_and_slow_pointers;

import java.util.HashSet;
import java.util.Set;

/**
 *Circular Array Loop
 *
 * An input array containing non-zero integers is given, where the value at each index represents the number of places to skip forward (if the value is positive) or backward (if the value is negative). When skipping forward or backward, wrap around if you reach either end of the array. For this reason, we are calling it a circular array. Determine if this circular array has a cycle. A cycle is a sequence of indices in the circular array characterized by the following:
 *
 * The same set of indices is repeated when the sequence is traversed in accordance with the aforementioned rules.
 * The length of the sequence is at least two.
 * The loop must be in a single direction, forward or backward.
 *
 */
public class CircularArrayLoop {

    public static void main(String[] args) {
        // Test Case 1: positive scenario
        int[] nums = {2, -1, 1, 2, 2};
        boolean hasCycle = circularArrayLoop(nums);
        System.out.println("Test Case 1: Circular Array has cycle: " + hasCycle);

        // Test Case 2: negative scenario
        int[] nums2 = {-2, 1, -1, -2, -2};
        boolean hasCycle2 = circularArrayLoop(nums2);
        System.out.println("Test Case 2: Circular Array has cycle: " + hasCycle2);
    }

    public static boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue; // skip if the current index is 0
            }
            int slow = i, fast = i;
            boolean forward = nums[i] > 0; // check the direction of the loop
            while (nums[fast] * nums[i] > 0 && nums[getNextIndex(nums, fast, forward)] * nums[i] > 0) {
                slow = getNextIndex(nums, slow, forward);
                fast = getNextIndex(nums, getNextIndex(nums, fast, forward), forward);
                if (slow == fast) {
                    if (slow == getNextIndex(nums, slow, forward)) {
                        break;
                    }
                    return true;
                }
            }
            int j = i;
            int val = nums[i];
            while (nums[j] * val > 0) {
                int next = getNextIndex(nums, j, val > 0);
                nums[j] = 0;
                j = next;
            }
        }
        return false;
    }

    private static int getNextIndex(int[] nums, int i, boolean forward) {
        int next = (i + nums[i]) % nums.length;
        if (next < 0) {
            next += nums.length; // if next index is negative, wrap around the array
        }
        if (nums[next] == 0 || (nums[next] > 0) != forward) {
            return i; // if next index is 0 or the direction of the loop is different, return current index
        }
        return next;
    }

    public static boolean circularArrayLoopBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int slow = i, fast = i;
            boolean forward = nums[i] > 0;
            Set<Integer> seen = new HashSet<>();
            while (!seen.contains(slow)) {
                seen.add(slow);
                slow = getNextIndex(nums, slow, forward);
                fast = getNextIndex(nums, fast, forward);
                fast = getNextIndex(nums, fast, forward);
                if (fast == slow) {
                    if (getNextIndex(nums, slow, forward) != slow) {
                        return true;
                    }
                    break;
                }
            }
        }
        return false;
    }
}
