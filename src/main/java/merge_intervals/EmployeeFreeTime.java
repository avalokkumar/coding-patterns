package merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Employee Free Time
 *
 * You’re given a list containing the schedules of multiple people. Each person’s schedule is a list of non-overlapping intervals in sorted order. An interval is specified with the start time and the end time, both being positive integers. Your task is to find the list of intervals representing the free time for all the people. We’re not interested in the interval from negative infinity to zero or from the end of the last scheduled interval in the input to positive infinity.
 */
public class EmployeeFreeTime {

    public static void main(String[] args) {
        List<Interval> schedule1 = Arrays.asList(new Interval(1, 3), new Interval(6, 7));
        List<Interval> schedule2 = Arrays.asList(new Interval(2, 4));
        List<Interval> schedule3 = Arrays.asList(new Interval(2, 3), new Interval(9, 12));
        List<List<Interval>> schedules = Arrays.asList(schedule1, schedule2, schedule3);
        List<Interval> freeTime = employeeFreeTime(schedules);
        System.out.println("Free Time: " + freeTime);
    }


    /**
     * First, we flatten the list of schedules by using a stream to concatenate the schedules and then sorting the intervals by start time. We then use a for loop to iterate through the sorted list of intervals. At each iteration, we check if the current interval's start time is greater than the previous interval's end time, if so, we add a new Interval object representing the free time between the end of the previous interval and the start of the current interval to our freeTime list. We also update the end variable with the maximum of the previous end and the current interval's end time.
     * @param schedule
     * @return
     */
    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        // flatten the list of schedules
        List<Interval> intervals = schedule.stream()
                .flatMap(List::stream)
                .sorted(Comparator.comparingInt(a -> a.start))
                .collect(Collectors.toList());

        // find the free time
        List<Interval> freeTime = new ArrayList<>();
        int end = intervals.get(0).end;
        for (Interval interval : intervals) {
            if (interval.start > end) {
                freeTime.add(new Interval(end, interval.start));
            }
            end = Math.max(end, interval.end);
        }
        return freeTime;
    }

    /**
     * In this example, the input schedules are [[1,3], [6,7]], [[2,4]], [[2,3], [9,12]]. The output will be Free Time: [[4, 6], [7, 9]].
     *
     * This solution has O(n log n) time complexity where n is the total number of intervals as we are sorting the intervals first and O(n) space complexity as we are
     */
}

