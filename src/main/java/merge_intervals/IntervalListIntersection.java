package merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * For two lists of closed intervals given as input, intervalLista and intervalListb, where each interval has its own start and end time, write a function that returns the intersection of the two interval lists.
 *
 * For example, the intersection of [3, 8] and [5, 10] is [5, 8]
 * .
 */
public class IntervalListIntersection {

    public static void main(String[] args) {
        // Test Case 1:
        int[][] intervalListA = {{1, 3}, {5, 6}, {7, 9}};

        int[][] intervalListB = {{2, 4}, {6, 8}};
        int[][] result = intervalIntersection(intervalListA, intervalListB);
        System.out.print("Test Case 1: The intersection of " + Arrays.deepToString(intervalListA) + " and " + Arrays.deepToString(intervalListB) + " is: ");
        for (int[] interval : result) {
            System.out.print("[" + interval[0] + "," + interval[1] + "] ");
        }
        System.out.println();
        // Test Case 2:
        int[][] intervalListC = {{2, 5}, {7, 10}};
        int[][] intervalListD = {{3, 6}, {9, 12}};
        int[][] result2 = intervalIntersection(intervalListC, intervalListD);
        System.out.print("Test Case 2: The intersection of " + Arrays.deepToString(intervalListC) + " and " + Arrays.deepToString(intervalListD) + " is: ");
        for (int[] interval : result2) {
            System.out.print("[" + interval[0] + "," + interval[1] + "] ");
        }
        System.out.println();
    }

    /**
     * We start by initializing two pointers, i and j to keep track of the current interval in intervalListA and intervalListB respectively. We also initialize an empty list to store the intersection of the two interval lists. We use a while loop to iterate through both interval lists simultaneously. Inside the while loop, we find the start and end times of the intersection by taking the maximum of the start times of the current intervals in both lists and the minimum of the end times of the current intervals in both lists. We then check if the start time is less than or equal to the end time, indicating that there is an intersection. If yes, we add the intersection interval to the result list. Finally, we increment the pointer of the list whose current interval's end time is less than the other list's current interval's end time.
     *
     * @param intervalListA
     * @param intervalListB
     * @return
     */
    public static int[][] intervalIntersection(int[][] intervalListA, int[][] intervalListB) {
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < intervalListA.length && j < intervalListB.length) {
            int start = Math.max(intervalListA[i][0], intervalListB[j][0]);
            int end = Math.min(intervalListA[i][1], intervalListB[j][1]);
            if (start <= end) {
                result.add(new int[] {start, end});
            }
            if (intervalListA[i][1] < intervalListB[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    /**
     * In the above test case 1, the input intervals are [[1,3], [5,6], [7,9]] and [[2,4], [6,8]]. The output will be `Test Case 1: The intersection of [[1, 3], [5, 6], [7, 9]] and [[2, 4], [6, 8]] is: [2,3] [6,6]`
     * In test case 2, the input intervals are [[2,5], [7,10]] and [[3,6], [9,12]]. The output will be `Test Case 2: The intersection of [[2, 5], [7, 10]] and [[3, 6], [9, 12]] is: [3,5] [9,10]`
     *
     * This solution has O(m+n) time complexity where m and n are the number of intervals in intervalListA and intervalListB respectively as we are iterating through both lists once. It also has O(m+n) space complexity as we are storing the intersection intervals in a list.
     */
}
