package top_k_elements;

import java.util.*;

/**
 * K Closest Points to Origin
 * <p>
 * Statement
 * Given a list of points on a plane, where the plane is a 2-D array with (x, y) coordinates, find the k closest points to the origin (0,0)
 */
public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        KClosestPointsToOrigin obj = new KClosestPointsToOrigin();
        int[][] points = {{1, 3}, {-2, 2}};
        int k = 1;
        int[][] result = obj.kClosest(points, k);
        System.out.println(Arrays.deepToString(result)); // Output: [[-2, 2]]
    }


    /**
     * One approach to solve this problem is by using a min heap. We can create a max heap of size k to maintain the closest k points to the origin.
     * For each point, we can calculate its distance from the origin using the distance formula sqrt(x^2 + y^2) and insert it into the heap.
     * If the heap size exceeds k, we can remove the point with the largest distance from the origin. Finally, we can return the k closest points.
     *
     * @param points
     * @param k
     * @return
     */
    public int[][] kClosest(int[][] points, int k) {

        // Create a max heap of size k
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(k, (a, b) -> {
            // Compare the distances between two points
            // a and b are points in the form of {x,y}
            return Integer.compare(getDistance(b), getDistance(a));
            // By using compare() method, it sorts the points in descending order based on distance from origin
        });

        // Iterate through all points in the input array
        for (int[] point : points) {
            // Add the point to the max heap
            maxHeap.offer(point);

            // If the heap size exceeds k, remove the point with the largest distance from the origin
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Create a new array to store the k closest points
        int[][] result = new int[k][2];

        // Iterate through the max heap and add the points to the result array
        int index = 0;
        while (!maxHeap.isEmpty()) {
            result[index++] = maxHeap.poll();
        }

        return result;
    }

    // Helper method to calculate the distance between a point and the origin
    private int getDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

}
