package subsets;

import java.util.ArrayList;
import java.util.List;

// Find K-Sum Subsets
/**
 * Statement
 Given a set of n positive integers, find all the possible subsets of integers that sum up to a number k.
 Constraints:
 1≤n≤10
 1 ≤ x ≤ 100 , where x is any member of the input set
 1 ≤ k ≤ 10^3

 Example 1:
 Input: nums = [1,2,3,4], k = 5
 Output: [[1,4],[2,3]]
 Explanation: The possible subsets of the array [1,2,3,4] that sum up to 5 are [1,4] and [2,3].

 Example 2:
 Input: nums = [1,2,3,4], k = 6
 Output: [[1,2,3]]
 Explanation: The possible subsets of the array [1,2,3,4] that sum up to 6 is [1,2,3].
 */
public class FindKSubsets {
    public List<List<Integer>> kSumSubsets(int[] nums, int k) {
        List<List<Integer>> result = new ArrayList<>();    // create a list to store the result

        generateSubsets(nums, 0, k, new ArrayList<>(), result);    // call the helper function to generate the subsets

        return result;  // return the result
    }

    private void generateSubsets(int[] nums, int index, int k, List<Integer> subset, List<List<Integer>> result) {
        if (k == 0) {   // if k is 0, then add the subset to the result
            result.add(new ArrayList<>(subset));
            return;
        }

        for (int i = index; i < nums.length; i++) {  // iterate through the array
            if (nums[i] <= k) {     // if the element is less than or equal to k, then add the element to the subset
                subset.add(nums[i]);
                generateSubsets(nums, i + 1, k - nums[i], subset, result);    // generate the subsets recursively
                subset.remove(subset.size() - 1);  // remove the element from the subset
            }
        }
    }

    public static void main(String[] args) {
        FindKSubsets findKSubsets = new FindKSubsets();
        System.out.println(findKSubsets.kSumSubsets(new int[]{1, 2, 3, 4}, 5));    // [[1, 4], [2, 3]]
        System.out.println(findKSubsets.kSumSubsets(new int[]{1, 2, 3, 4}, 6));    // [[1, 2, 3]]
        System.out.println(findKSubsets.kSumSubsets(new int[]{1, 3, 5, 21, 19, 7, 2}, 10)); //  {3, 7}, {3, 5, 2}, {1, 7, 2}

    }
}
