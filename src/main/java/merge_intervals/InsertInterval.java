package merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Insert Interval
 * You’re given a list of non-overlapping intervals, and you need to insert another interval into the list. Each interval is a pair of non-negative numbers, the first being the start time and the second being the end time of the interval. The input list of intervals is sorted in ascending order of start time.
 *
 * The intervals in the output must also be sorted by the start time, and none of them should overlap. This may require merging those intervals that now overlap as a result of the addition of the new interval.
 */
public class InsertInterval {

    public static void main(String[] args) {
        // Test Case 1:
        int[][] intervals = {{1,3}, {6,9}};
        int[] newInterval = {2,5};
        int[][] result = insertInterval(intervals, newInterval);
        System.out.print("Test Case 1: The new list of intervals after inserting " + Arrays.toString(newInterval) + " into " + Arrays.deepToString(intervals) + " is: ");
        for (int[] interval : result) {
            System.out.print("[" + interval[0] + "," + interval[1] + "] ");
        }
        System.out.println();
        // Test Case 2:
        int[][] intervals2 = {{1,2}, {3,5}, {6,7}, {8,10}, {12,16}};
        int[] newInterval2 = {4,8};
        int[][] result2 = insertInterval(intervals2, newInterval2);
        System.out.print("Test Case 2: The new list of intervals after inserting " + Arrays.toString(newInterval2) + " into " + Arrays.deepToString(intervals2) + " is: ");
        for (int[] interval : result2) {
            System.out.print("[" + interval[0] + "," + interval[1] + "] ");
        }
        System.out.println();
    }

    /**
     * We start by initializing an empty list to store the new list of intervals after inserting the new interval. We iterate through the given list of intervals, and check if the end time of each interval is less than the start time of the new interval. If yes, we add that interval to the new list, as it does not overlap with the new interval. Then, we iterate through the remaining intervals, and check if their start time is less than or equal to the end time of the new interval. If yes, we merge the current interval with the new interval by updating the start and end times of the new interval to be the minimum and maximum of the current and new intervals' start and end times respectively. Finally, we add the new interval to the new list and add the remaining intervals to the new list.
     * @param intervals
     * @param newInterval
     * @return
     */
    public static int[][] insertInterval(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i++]);
        }
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);
        while (i < intervals.length) {
            result.add(intervals[i++]);
        }
        return result.toArray(new int[result.size()][]);
    }

    /**
     *
     In the above test case 1, the input intervals are [[1,3], [6,9]], and newInterval is [2,5]. The output will be `Test Case 1: The new list of intervals after inserting [2, 5] in [[1, 3], [6, 9]] is: [1,5] [6,9]`
     In test case 2, the input intervals are [[1,2], [3,5], [6,7], [8,10], [12,16]], and newInterval is [4,9]. The output will be `Test Case 2: The new list of intervals after inserting [4, 9] in [[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]] is: [1,2] [3,10] [12,16]`

     This solution has O(n) time complexity and O(n) space complexity as we are iterating through the given list of intervals once and adding the new list of intervals to an arraylist.
     */
}
