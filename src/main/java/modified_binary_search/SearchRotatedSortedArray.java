package modified_binary_search;


/**
 * Search in Rotated Sorted Array
 * Statement
 * Given a sorted integer array, nums, and an integer value, target, the array is rotated by some arbitrary number.
 * Search and return the index of target in this array. If the target does not exist, return -1.
 *
 * Constraints
 *
 * All values in nums are unique.
 * The values in nums are in sorted in ascending order. The array may have been rotated by some arbitrary number.
 */
public class SearchRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(search(nums, target)); // Expected output: 4

        target = 3;
        System.out.println(search(nums, target)); // Expected output: -1
    }

    /**
     * One way to solve this problem is to use binary search. Since the array is sorted, we can perform binary search to find the target element.
     * However, since the array is rotated, we cannot use the standard binary search algorithm directly.
     * We need to modify the binary search algorithm to handle the rotated array.
     *
     * Here is the modified binary search algorithm:
     *
     * Find the pivot element in the array. The pivot element is the element at which the array is rotated.
     * Determine which side of the pivot the target element is on.
     * Perform binary search on the appropriate side of the pivot.
     * We can find the pivot element using binary search as well. The pivot element is the element at which the array is rotated.
     * We can compare the middle element with the first and last elements of the array to determine whether the array is rotated on the
     * left or right side of the middle element. Based on this, we can update our search range.
     */

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                // Left side is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // Right side is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

}
