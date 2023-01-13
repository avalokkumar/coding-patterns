package merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Merge Intervals
 * We’re given an array of closed intervals as input where each interval has a start and end timestamp. The input array is sorted by starting timestamps. Merge the overlapping intervals and return a new output array.
 */
public class MergeIntervals {


    public static void main(String[] args) {
        // Test Case 1:
        int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,18}};
        int[][] result = mergeIntervals(intervals);
        System.out.print("Test Case 1: The merged intervals of " + Arrays.deepToString(intervals) + " are: ");
        for (int[] interval : result) {
            System.out.print("[" + interval[0] + "," + interval[1] + "] ");
        }
        System.out.println();

        // Test Case 2:
        int[][] intervals2 = {{1,4}, {4,5}};
        int[][] result2 = mergeIntervals(intervals2);
        System.out.print("Test Case 2: The merged intervals of " + Arrays.deepToString(intervals2) + " are: ");
        for (int[] interval : result2) {
            System.out.print("[" + interval[0] + "," + interval[1] + "] ");
        }
        System.out.println();
    }


    /**
     * Here, we are first sorting the intervals based on their starting timestamps, so that we can iterate through them and merge them in order. We initialize a list to store the merged intervals, and add the first interval to it. For each subsequent interval, we check if its starting timestamp is less than or equal to the end timestamp of the current interval. If yes, we merge the two intervals by updating the end timestamp of the current interval to be the maximum of the current end timestamp and the end timestamp of the new interval. If not, we add the new interval as a new current interval.
     * @param intervals
     * @return
     */
    public static int[][] mergeIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];
        merged.add(current);

        for (int[] interval : intervals) {
            if (interval[0] <= current[1]) {
                current[1] = Math.max(current[1], interval[1]);
            } else {
                current = interval;
                merged.add(current);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    /**
     * In the above test case 1, the input array is [[1,3], [2,6], [8,10], [15,18]], the output will be `Test Case 1: The merged intervals of [[1, 3], [2, 6], [8, 10], [15, 18]] are: [1,6] [8,10] [15,18] `
     * In test case 2, the input array is [[1,4], [4,5]], the output will be `Test Case 2: The merged intervals of [[1, 4], [4, 5]] are: [1,5] `
     *
     * This solution has O(nlogn) time complexity and O(n) space complexity due to sorting and storing the merged intervals in a list.
     */
}
