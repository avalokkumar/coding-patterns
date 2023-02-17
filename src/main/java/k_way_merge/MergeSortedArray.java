package k_way_merge;

import java.util.Arrays;

/**
 * Merge Sorted Array
 *
 * Given two sorted integer arrays,num1
 * nums1 and nums2
 * , and the number of data elements in each array,
 * m and n
 * , implement a function that merges the second array into the first one. You have to modify num1
 * nums1
 *  in place.
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = new int[] {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[] {2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;  // Index for nums1
        int j = n - 1;  // Index for nums2
        int k = m + n - 1;  // Index for merged nums1

        // Compare elements from end of nums1 and nums2, place the largest one in merged nums1
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {  // If the element in nums1 is larger
                nums1[k--] = nums1[i--];  // Place it in merged nums1 and decrement the index for nums1
            } else {
                nums1[k--] = nums2[j--];  // If the element in nums2 is larger, place it in merged nums1 and decrement the index for nums2
            }
        }

        // If there are still elements in nums2, add them to the end of merged nums1
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }


    /**
     * explanation:
     *
     * i is the index for nums1 array and is initialized to m - 1.
     * j is the index for nums2 array and is initialized to n - 1.
     * k is the index for the resulting nums1 array and is initialized to m + n - 1.
     * The first while loop compares the elements of the two arrays and places the largest element in the rightmost position of the resulting nums1 array.
     *
     * The second while loop takes care of the case when there are still elements left in the nums2 array and there are no elements left in the nums1 array.
     * In this case, we simply copy the remaining elements from nums2 to the resulting nums1 array.
     */
}
