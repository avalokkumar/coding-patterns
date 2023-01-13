package sliding_window;

import java.util.Arrays;

/**
 * Minimum Size Subarray Sum
 * Given an array of positive integers nums and a positive integer target, find the window size of the shortest contiguous subarray whose sum is greater than or equal to the target value. If no subarray is found, 0 is returned.
 */
public class MinSizeSubArraySum {

    public static void main(String[] args) {
        // Test Case 1:
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        int result = minSizeSubarraySum(nums, target);
        System.out.println("Test Case 1: The window size of the shortest contiguous subarray whose sum is greater than or equal to " + target + " in " + Arrays.toString(nums) + " is: " + result);

        // Test Case 2:
        int[] nums2 = {1,1,1,1};
        int target2 = 4;
        int result2 = minSizeSubarraySum(nums2, target2);
        System.out.println("Test Case 2: The window size of the shortest contiguous subarray whose sum is greater than or equal to " + target2 + " in " + Arrays.toString(nums2) + " is: " + result2);
    }


    public static int minSizeSubarraySum(int[] nums, int target) {
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int currentSum = 0;
        while (right < nums.length) {
            currentSum += nums[right];
            while (currentSum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                currentSum -= nums[left];
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

}
