package sliding_window;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Find Maximum in Sliding Window
 * <p>
 * Given an integer array and a window of size w, find the current maximum value in the window as it slides through the entire array.
 * <p>
 * Note: If the window size is greater than the array size, we consider the entire array as a single window.
 */
public class MaximumSlidingWindow {

    public static void main(String[] args) {
        // Test Case 1:
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int w = 3;
        int[] result = findMaxInSlidingWindow(nums, w);
        System.out.println("Test Case 1: Maximum in sliding window: " + Arrays.toString(result));

        // Test Case 2:
        int[] nums2 = {2, 4, 6, 8, 10, 12, 14, 16};
        int w2 = 2;

        int[] result2 = findMaxInSlidingWindow(nums2, w2);
        System.out.println("Test Case 2: Maximum in sliding window: " + Arrays.toString(result2));
    }

    public static int[] findMaxInSlidingWindow(int[] nums, int w) {
        if (nums.length == 0) {
            return new int[0];
        }

        int[] result = new int[nums.length - w + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            // remove the elements that are smaller than current element from the deque
            while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
                deque.removeLast();
            }
            // add current element to the deque
            deque.addLast(i);

            // remove the elements that are out of the current window from the deque
            if (i - w >= 0 && deque.getFirst() <= i - w) {
                deque.removeFirst();
            }

            // if the window is filled, add the maximum element to the result array
            if (i - w + 1 >= 0) {
                result[i - w + 1] = nums[deque.getFirst()];
            }
        }
        return result;
    }

}
