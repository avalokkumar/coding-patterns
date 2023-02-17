package k_way_merge;

import java.util.*;

public class KthSmallestPairs {

    public static void main(String[] args) {
        int[] list1 = {1, 7, 11};
        int[] list2 = {2, 4, 6};
        int k = 3;
        List<List<Integer>> result = kSmallestPairs(list1, list2, k);
        System.out.println("The k smallest pairs are: " + result);
    }

    public static List<List<Integer>> kSmallestPairs(int[] list1, int[] list2, int target) {
        List<List<Integer>> result = new ArrayList<>();

        // Check if either list1 or list2 is empty
        if (list1.length == 0 || list2.length == 0) {
            return result;
        }

        // Create a priority queue to store the pairs
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator
                <int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return (list1[a[0]] + list2[a[1]]) - (list1[b[0]] + list2[b[1]]);
            }
        });

        // Add the first pair (0, list2.length - 1) to the priority queue
        pq.offer(new int[] {0, list2.length - 1});

        // Keep track of how many pairs have been added to the result
        int count = 0;

        // Continue until either the priority queue is empty or count equals target
        while (!pq.isEmpty() && count < target) {
            // Remove the pair with the smallest sum from the priority queue
            int[] pair = pq.poll();
            result.add(Arrays.asList(list1[pair[0]], list2[pair[1]]));

            // Move the pointers to the next pairs
            if (pair[1] > 0) {
                // If j > 0, add the pair (i, j - 1) to the priority queue
                pq.offer(new int[] {pair[0], pair[1] - 1});
            }
            if (pair[0] < list1.length - 1) {
                // If i < list1.length - 1, add the pair (i + 1, j2) to the priority queue
                pq.offer(new int[] {pair[0] + 1, pair[1]});
            }

            count++;
        }

        return result;
    }

}
