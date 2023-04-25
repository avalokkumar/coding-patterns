package modified_binary_search;

import java.util.*;

/**
 * Find K Closest Elements
 * Statement
 * Given a sorted integer array nums and two integers—k and num—return the k closest integers to num in this array.
 * Ensure that the result is sorted in ascending order.
 *
 * The integer a is closer to num than an integer b if the following are true:
 *
 * |a - num| < |b - num|, or
 *
 * |a - num| == |b - num| and a < b
 */
public class ClosestElements {
    public static List<Integer> findClosestElements(int[] nums, int k, int x) {
        // initialize start and end pointers for binary search
        int start = 0, end = nums.length - k;

        // perform binary search to find the leftmost index of the k closest elements
        while (start < end) {
            int mid = start + (end - start) / 2;

            // calculate the distance of the mid and mid+k elements to x
            int dist1 = Math.abs(x - nums[mid]);
            int dist2 = Math.abs(x - nums[mid+k]);

            // if the right element is closer to x, update the start pointer
            if (dist1 > dist2) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        // create and return a list of k closest elements
        List<Integer> res = new ArrayList<>();
        for (int i = start; i < start + k; i++) {
            res.add(nums[i]);
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 4, x = 3;
        List<Integer> result = findClosestElements(nums, k, x);
        System.out.println(result); // Output: [1, 2, 3, 4]
    }
}
