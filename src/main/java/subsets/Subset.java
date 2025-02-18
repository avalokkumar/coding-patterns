package subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * // Subsets
 * Given an array of integers, nums, find all possible subsets of nums, including the empty set.
 *
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Explanation: The subsets of the array [1,2,3] are [], [1], [2], [1,2], [3], [1,3], [2,3], and [1,2,3].
 *
 * Example 2:
 * Input: nums = [0]
 * Output: [[],[0]]
 */
public class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();    // create a list to store the result
        List<Integer> subset = new ArrayList<>();  // create a list to store the subset

        generateSubsets(nums, 0, subset, result);    // call the helper function to generate the subsets

        return result;  // return the result
    }

    private void generateSubsets(int[] nums, int index, List<Integer> subset, List<List<Integer>> result) {
        result.add(new ArrayList<>(subset));     // add the subset to the result

        for (int i = index; i < nums.length; i++) {  // iterate through the array
            subset.add(nums[i]);    // add the element to the subset
            generateSubsets(nums, i + 1, subset, result);    // generate the subsets recursively
            subset.remove(subset.size() - 1);  // remove the element from the subset
        }
    }
}
