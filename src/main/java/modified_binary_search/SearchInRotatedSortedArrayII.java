package modified_binary_search;

/**
 * Search in Rotated Sorted Array II
 * Statement
 * You are required to find an integer t in an array arr of non-distinct integers. Prior to being passed as input to your search function, arr has been processed as follows:
 *
 * It has been sorted in non-descending order.
 * It has been rotated around some pivot k, such that, after rotation, it looks like this: [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]. For example, [10, 30, 40, 42, 42, 47, 78, 90, 901], rotated around pivot k=5
 *  becomes [47, 78, 90, 901, 10, 30, 40, 42, 42].
 * Return TRUE if t exists in the rotated, sorted array arr, and FALSE otherwise, while minimizing the number of operations in the search.
 *
 * Note: In this problem, the value of k is not passed to your search function.
 */
public class SearchInRotatedSortedArrayII {
    public static boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) { // found target element
                return true;
            }

            if (nums[left] == nums[mid] && nums[mid] == nums[right]) { // can't determine which side is sorted, decrease search space
                left++;
                right--;
            } else if (nums[left] <= nums[mid]) { // left side is sorted
                if (nums[left] <= target && target < nums[mid]) { // target lies within left sorted half
                    right = mid - 1;
                } else { // target lies within right unsorted half
                    left = mid + 1;
                }
            } else { // right side is sorted
                if (nums[mid] < target && target <= nums[right]) { // target lies within right sorted half
                    left = mid + 1;
                } else { // target lies within left unsorted half
                    right = mid - 1;
                }
            }
        }

        return false; // target not found
    }

    public static void main(String[] args) {
        int[] nums = {47, 78, 90, 901, 10, 30, 40, 42, 42};
        int target = 42;

        boolean found = search(nums, target);
        System.out.println(found); // expected output: true
    }
}
