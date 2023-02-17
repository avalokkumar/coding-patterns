package k_way_merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestInMSortedList {

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(1, 11, 20, 35, 300));
        lists.add(Arrays.asList(1, 2, 300));
        lists.add(Arrays.asList(4, 6, 7));
        int k = 5;
        System.out.println(kthSmallest(lists, k));
    }

    public static int kthSmallest(List<List<Integer>> lists, int k) {
        // Return 0 if the input lists are null or empty
        if (lists == null || lists.size() == 0) {
            return 0;
        }

        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the first element of each list to the min heap
        for (int i = 0; i < lists.size(); i++) {
            // Skip lists that are null or empty
            if (lists.get(i) == null || lists.get(i).size() == 0) {
                continue;
            }
            minHeap.offer(new Node(i, 0, lists.get(i).get(0)));
        }

        // Poll the smallest element from the min heap k - 1 times
        for (int i = 0; i < k - 1; i++) {
            Node node = minHeap.poll();
            if (node.col + 1 < lists.get(node.row).size()) {
                minHeap.offer(new Node(node.row, node.col + 1, lists.get(node.row).get(node.col + 1)));
            }
        }

        // The kth smallest element will be at the top of the min heap
        return minHeap.poll().val;
    }

    private static class Node {
        int row;
        int col;
        int val;

        public Node(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

}
