package top_k_elements;

import java.util.*;

/**
 * Given an infinite stream of integers, nums, design a class to find the kth
 * largest element in a stream.
 * Note: It is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * The class should have the following functions, inputs, and return values:
 * <p>
 * Init(): It takes an array of integers and an integer k and initializes the class object.
 * Add(value): It takes one integer value, appends it to the stream, and calls the Return kth largest() function.
 * Return kth largest(): It returns an integer value that represents the kth largest element in the stream.
 */
class KthLargestInStream {
    PriorityQueue<Integer> minHeap; // creating a priority queue to hold kth smallest elements
    int k; // kth largest element to find

    public KthLargestInStream(int[] nums, int k) { // constructor to initialize values
        this.k = k;
        minHeap = new PriorityQueue<>(k); // initializing the priority queue to have k elements
        for (int num : nums) { // add all the elements of nums to the heap
            add(num);
        }
    }

    public int add(int val) { // function to add new element to the stream
        if (minHeap.size() < k) { // if the size of heap is less than k, add element to the heap
            minHeap.offer(val);
        } else if (val > minHeap.peek()) { // else if the element is greater than the smallest element in heap, remove the smallest element and add the new element to the heap
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek(); // return the smallest element in heap which is the kth largest element in the stream
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 8, 2};
        int k = 3;
        KthLargestInStream kthLargest = new KthLargestInStream(nums, k);
        System.out.println(kthLargest.add(3));  // returns 4
        System.out.println(kthLargest.add(5));  // returns 5
        System.out.println(kthLargest.add(10));  // returns 5
        System.out.println(kthLargest.add(9));  // returns 8
        System.out.println(kthLargest.add(4));  // returns 8
    }
}
