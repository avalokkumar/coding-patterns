package top_k_elements;

import java.util.*;

/**
 * Top K Frequent Elements
 * Given an array of integers arr and an integer k, return the k most frequent elements.
 *
 * Note: You can return the answer in any order.
 */
class TopKFrequentElements {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = topKFrequent(arr, k);
        System.out.print("Top " + k + " frequent elements: ");
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    /**
     * We can solve this problem using a combination of a hash map and a priority queue.
     * First, we create a hash map to store the frequency of each element in the input array.
     * Then, we create a priority queue that sorts elements by their frequency in descending order.
     * We add all elements from the hash map to the priority queue. Finally, we pop the k highest-frequency elements
     * from the priority queue and return them as an array.
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k) {
        // Create a hash map to store the frequency of each element
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Create a priority queue that sorts elements by their frequency
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));

        // Add all elements from the hash map to the priority queue
        for (int num : freqMap.keySet()) {
            pq.offer(num);
        }

        // Pop the k highest-frequency elements from the priority queue
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }
}
