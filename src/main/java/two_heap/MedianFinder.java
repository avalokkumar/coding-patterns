package two_heap;


import java.util.Collections;
import java.util.PriorityQueue;

/**
 *
 * In this solution, we are using two heaps: minHeap and maxHeap.
 * minHeap stores the upper half of the integers in the data stream and maxHeap stores the lower half of the integers in the data stream.
 * The maxHeap is implemented as a max heap, so that the root of the heap always contains the largest element.
 * The minHeap is implemented as a min heap, so that the root of the heap always contains the smallest element.
 * We use the addNum method to insert a new number in the data stream. In this method, we first insert the new number in maxHeap. Then, we move the root of maxHeap to minHeap.
 * After inserting the new number in minHeap, if the size of maxHeap is less than minHeap, we again move the root of minHeap to maxHeap.
 * By following this approach, we ensure that maxHeap contains the lower half of the integers and minHeap contains the upper half of the integers in the data stream.
 * The findMedian method is used to find the median of the data stream. If the size of maxHeap and minHeap is equal, we return the average of the roots of maxHeap and minHeap. Otherwise, we return the root of maxHeap.
 * Since we are using two heaps, we are able to insert a new number and find the median in
 */
class MedianFinder {
    static PriorityQueue<Integer> minHeap= new PriorityQueue<>(); // To store the larger half of the input
    static PriorityQueue<Integer> maxHeap= new PriorityQueue<>(Collections.reverseOrder());; // To store the smaller half of the input

    public static void main(String[] args) {
        addNum(1);
        addNum(2);
        System.out.println(findMedian());
        addNum(6);
        System.out.println(findMedian());
    }

    public static void addNum(int num) {
        maxHeap.offer(num); // Adding the element to max heap
        minHeap.offer(maxHeap.poll()); // Balancing the heaps

        // If min heap size is greater than max heap size, then pop the top element of min heap
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public static double findMedian() {
        // If both heaps are of equal size, median is the average of the top element of both heaps
        if (minHeap.size() == maxHeap.size()) {
            return (double)(minHeap.peek() + maxHeap.peek())/2;
        }
        // If max heap size is greater than min heap size, median is the top element of max heap
        else {
            return (double) maxHeap.peek();
        }
    }
}

