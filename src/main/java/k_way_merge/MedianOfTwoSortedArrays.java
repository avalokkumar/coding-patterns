package k_way_merge;

import java.util.PriorityQueue;

/**
 * Median of Two Sorted Arrays
 *
 * Statement
 * You’re given two sorted integer arrays, nums1 and nums2, of size m and n
 * , respectively. Your task is to return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log(m+n))
 *
 */
public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); // max heap to store smaller half
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // min heap to store larger half

        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;

        for (int i = 0; i < m; i++) {
            maxHeap.offer(nums1[i]); // add all elements from nums1 to max heap
            if (maxHeap.size() > (total + 1) / 2) {
                minHeap.offer(maxHeap.poll()); // move maximum element from smaller half to larger half
            }
        }

        for (int j = 0; j < n; j++) {
            minHeap.offer(nums2[j]); // add all elements from nums2 to min heap
            if (minHeap.size() > total / 2) {
                maxHeap.offer(minHeap.poll()); // move minimum element from larger half to smaller half
            }
        }

        if (total % 2 == 0) { // if total number of elements is even, median is average of two middle elements
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        } else { // if total number of elements is odd, median is the middle element
            return (double) maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2)); // expected output: 2.0

        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        System.out.println(findMedianSortedArrays(nums3, nums4)); // expected output: 2.5
    }
}
