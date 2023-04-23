package top_k_elements;

import java.util.*;

/**
 * Kth Largest Element in an Array
 * Find the kth largest element in an unsorted array.
 */
public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int kthLargest = KthLargestElement.findKthLargest(nums, k);
        System.out.println("The " + k + "th largest element is " + kthLargest);
    }

}
