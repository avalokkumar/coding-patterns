package merge_intervals;

import java.util.Arrays;

/**
 * Meeting Rooms
 * Given a list of meeting time intervals as input, find the minimum number of meeting rooms needed to hold these meetings.
 */
public class MeetingRooms {

    public static void main(String[] args) {
        Interval[] intervals = {
                new Interval(30, 75),
                new Interval(0, 50),
                new Interval(60, 150)
        };
        int minRooms = minMeetingRooms(intervals);
        System.out.println("Minimum number of meeting rooms needed: " + minRooms);
    }

    /**
     * First, we create two arrays, one for the start times of the intervals and one for the end times. We then sort these arrays in ascending order. Next, we initialize two variables, rooms and endIdx, to 0.
     *
     * We use a for loop to iterate through the intervals, and for each interval, we check if the current interval's start time is less than the end time of the interval at the endIdx index. If it is, we increment the rooms variable, indicating that we need an additional room for this interval. If not, we increment the endIdx variable, indicating that we no longer need a room for the interval at that index.
     *
     * @param intervals
     * @return
     */
    public static int minMeetingRooms(Interval[] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int rooms = 0;
        int endIdx = 0;
        for (int i = 0; i < n; i++) {
            if (start[i] < end[endIdx]) {
                rooms++;
            } else {
                endIdx++;
            }
        }
        return rooms;
    }


    /**
     * In this example, the input intervals are {[30, 75], [0, 50], [60, 150]}. The output will be Minimum number of meeting rooms needed: 2.
     *
     * This solution has O(nlogn) time complexity as we are sorting the intervals first and O(n) space complexity as we are using two arrays of size n.
     */

}
