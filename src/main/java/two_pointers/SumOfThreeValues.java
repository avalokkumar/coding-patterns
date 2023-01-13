package two_pointers;

import java.util.Arrays;

/**
 * Sum of Three Values
 * Given an array of integers, nums, and an integer value, target, determine if there are any three integers
 * in nums whose sum equals the target. Return TRUE if three such integers are found in the array. Otherwise, return FALSE.
 *
 *
 */

/**
 * Approach:
 *
 * Here's a brief explanation of how the solution works:
 *
 * First, we sort the input array using the built-in Arrays.sort() method. This is important because it allows us to efficiently iterate through the array while keeping track of the current, left, and right indices.
 * Next, we use a nested loop to iterate through the array. The outer loop keeps track of the current index, and the inner loop uses two pointers (one at the left and one at the right of the array) to iterate through the rest of the array.
 * Within the inner loop, we check if the sum of the integers at the current, left, and right indices equals the target value. If it does, we return true.
 * If the sum is less than the target, we increment the left pointer to try a larger sum. If the sum is greater than the target, we decrement the right pointer to try a smaller sum.
 * If the inner loop completes without finding any integers that sum to the target, the outer loop will also complete, and the function will return false.
 * This is a simple approach to solve this problem, you can also use other approaches like using HashSet or HashMap, but it will depend on the problem's constraints.
 *
 * You can test the solution using the sample code in the main method, which creates an array of integers and a target value, and then passes them to the sumOfThree() function. The output should be Found three integers that sum to target: true, because 1 + 2 + 6 = 9.
 */
public class SumOfThreeValues {

    public static boolean sumOfThree(int[] nums, int target) {
        // Sort the array
        Arrays.sort(nums);

        // Iterate through the array
        for (int i = 0; i < nums.length - 2; i++) {
            // Initialize two pointers, one at the current index and one at the end of the array
            int left = i + 1;
            int right = nums.length - 1;

            // Iterate through the array while the left pointer is less than the right pointer
            while (left < right) {
                // If the sum of the three integers at the current, left, and right indices equals the target, return true
                if (nums[i] + nums[left] + nums[right] == target) {
                    return true;
                }
                // If the sum is less than the target, increment the left pointer
                else if (nums[i] + nums[left] + nums[right] < target) {
                    left++;
                }
                // If the sum is greater than the target, decrement the right pointer
                else {
                    right--;
                }
            }
        }
        // If no three integers are found that sum to the target, return false
        return false;
    }

    public static void main(String[] args) {
        // Test Case 1: positive scenario
        int[] nums = {1, 2, 6};
        int target = 9;
        boolean found = sumOfThree(nums, target);
        System.out.println("Test Case 1: Found three integers that sum to target: " + found);

        // Test Case 2: negative scenario
        int[] nums2 = {1, 2, 3, 4, 5};
        int target2 = 8;
        boolean found2 = sumOfThree(nums2, target2);
        System.out.println("Test Case 2: Found three integers that sum to target: " + found2);

        // Test Case 3: negative scenario with array of length less than 3
        int[] nums3 = {1, 2};
        int target3 = 8;
        boolean found3 = sumOfThree(nums3, target3);
        System.out.println("Test Case 3: Found three integers that sum to target: " + found3);

        // Test Case 4: negative scenario with array of length 3 but no integers that sum to target
        int[] nums4 = {1, 2, 3};
        int target4 = 8;
        boolean found4 = sumOfThree(nums4, target4);
        System.out.println("Test Case 4: Found three integers that sum to target: " + found4);
    }

}

