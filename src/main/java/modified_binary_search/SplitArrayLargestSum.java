package modified_binary_search;

/**
 * Split Array Largest Sum
 Let’s solve the Split Array Largest Sum problem using the Modified Binary Search pattern.

 Statement
 Given an integer list nums and an integer k, split nums into k non-empty subarrays such that the largest sum among these subarrays is minimized. The task is to find the minimized largest sum by choosing the split such that the largest sum of every split of subarrays is the minimum among the sum of other splits.

 Constraints:
 1 ≤ nums.length≤103
 0≤ nums[i] ≤ 104
 1 ≤ k ≤ nums.length

 Example 1:
 Input: nums = [7,2,5,10,8], k = 2
 Output: 18
 Explanation: The optimal split is [7,2,5] and [10,8] with the largest sum being 18. Here, the sum of the first split is 14 and the sum of the second split is 18. The maximum sum is 18.

 Example 2:
 Input: nums = [1,2,3,4,5], k = 2
 Output: 9
 Explanation: The optimal split is [1,2,3,4] and [5] with the largest sum being 9.
 */
public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int k) {
        int left = 0;   // initialize left to 0. left is used to store the minimum value
        int right = 0;  // initialize right to 0. right is used to store the maximum value

        for (int num : nums) {  // iterate through the array
            left = Math.max(left, num);     // update the left value with the maximum of left and the current element
            right += num;   // update the right value by adding the current element
        }

        while (left < right) {  // iterate through the array
            int mid = left + (right - left) / 2;     // calculate the mid value

            if (isValid(nums, k, mid)) {    // if the mid value is valid, then update the right value
                right = mid;
            } else {    // if the mid value is not valid, then update the left value
                left = mid + 1;
            }
        }

        return left;    // return the minimum value
    }

    private boolean isValid(int[] nums, int k, int mid) {
        int count = 1;  // initialize count to 1. count is used to store the number of subarrays
        int sum = 0;    // initialize sum to 0. sum is used to store the sum of the subarray

        for (int num : nums) {  // iterate through the array
            sum += num;     // add the current element to the sum

            if (sum > mid) {    // if the sum is greater than the mid value, then update the sum and increment the count
                sum = num;
                count++;
            }
        }

        return count <= k;  // return true if the count is less than or equal to k
    }

    public static void main(String[] args) {
        SplitArrayLargestSum splitArrayLargestSum = new SplitArrayLargestSum();
        System.out.println(splitArrayLargestSum.splitArray(new int[]{7, 2, 5, 10, 8}, 2));    // 18
        System.out.println(splitArrayLargestSum.splitArray(new int[]{1, 2, 3, 4, 5}, 2));    // 9
    }
}
