package modified_binary_search;

/**
 * Single Element in a Sorted Array
 * Statement
 * In this problem, you’re given an array of sorted integers in which all of the integers,
 * except one, appears twice. Your task is to find the single integer that appears only once.
 *
 * The solution should have a time complexity of O(logn)
 *  or better and a space complexity of O(1)
 */
public class SingleElementInSortedArray {

    public static int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // check if the middle element is the single element
            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid + 1]) {
                    left = mid + 2; // single element is in the right subarray
                } else {
                    right = mid; // single element is in the left subarray
                }
            } else {
                if (nums[mid] == nums[mid - 1]) {
                    left = mid + 1; // single element is in the right subarray
                } else {
                    right = mid - 1; // single element is in the left subarray
                }
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int[] nums2 = {3, 3, 7, 7, 10, 11, 11};
        int[] nums3 = {1, 2, 2};
        
        System.out.println(singleNonDuplicate(nums1)); // expected output: 2
        System.out.println(singleNonDuplicate(nums2)); // expected output: 10
        System.out.println(singleNonDuplicate(nums3)); // expected output: 1
    }
}
