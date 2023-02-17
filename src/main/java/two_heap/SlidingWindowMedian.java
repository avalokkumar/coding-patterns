package two_heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;


/**
 * 480. Sliding Window Median
 *
 *The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle values.
 *
 * For examples, if arr = [2,3,4], the median is 3.
 * For examples, if arr = [1,2,3,4], the median is (2 + 3) / 2 = 2.5.
 * You are given an integer array nums and an integer k. There is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * Return the median array for each window in the original array. Answers within 10-5 of the actual value will be accepted.
 */
public class SlidingWindowMedian {
        // minHeap stores the larger half of the window
        static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // maxHeap stores the smaller half of the window
        static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    /**
     * Here we are using an array nums of integers {1, 2, 3, 4, 5, 6, 7, 8, 9, 10} and a window size k of 3. We create an instance of the SlidingWindowMedian class and call the findSlidingWindowMedian method on it, passing in nums and k as arguments. The method returns an array of doubles, which is the median of each window of size k as the window slides through the nums array. We print out this array using System.out.println(Arrays.toString(medians)).
     * @param nums
     * @param k
     * @return
     */
        public static double[] medianSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            double[] result = new double[n - k + 1];

            for (int i = 0; i < n; i++) {
                // add element to the window
                maxHeap.offer(nums[i]);
                minHeap.offer(maxHeap.poll());

                // balance the heaps if the size of minHeap is greater than maxHeap
                if (minHeap.size() > maxHeap.size()) {
                    maxHeap.offer(minHeap.poll());
                }

                // remove element from the window if the window size is greater than k
                if (i >= k) {
                    if (nums[i - k] <= maxHeap.peek()) {
                        maxHeap.remove(nums[i - k]);
                    } else {
                        minHeap.remove(nums[i - k]);
                    }
                }

                // balance the heaps if the size of minHeap is greater than maxHeap
                if (minHeap.size() > maxHeap.size()) {
                    maxHeap.offer(minHeap.poll());
                }

                // if the window size is equal to k, then calculate the median
                if (i >= k - 1) {
                    if (k % 2 == 0) {
                        result[i - k + 1] = (maxHeap.peek() + minHeap.peek()) / 2.0;
                    } else {
                        result[i - k + 1] = maxHeap.peek();
                    }
                }
            }
            return result;
        }

        public static void main(String[] args) {
            int[] nums = {1, 2, 2, 3, 5, 6, 11, 2, 11, 10};
            int k = 3;
            double[] medians = medianSlidingWindow(nums, k);
            System.out.println(Arrays.toString(medians));
        }
}
