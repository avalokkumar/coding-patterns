package modified_binary_search;

/**
 * Count Pairs Whose Sum is Less than Target
 Try to solve the Count Pairs Whose Sum is Less than Target problem.

 Statement
 You are given a 0-indexed integer array, nums, of length n, and an integer target. Your task is to determine the number of distinct pairs of indexes (i,j)
 such that: 0≤i<j<n (i.e., i comes before j in the array)

 The sum of the elements of the indexes (i,j) , (i.e., nums[i]+nums[j] nums[i]+nums[j]), is strictly less than the target.

 Constraints:
 n= nums.length
 1≤n≤50
 50 ≤ −50 ≤ nums[i], target ≤ 50

 Example 1:
 Input: nums = [1,1,2,2,3,3], target = 5
 Output: 8
 Explanation: The pairs are (0,2), (0,3), (0,4), (0,5), (1,2), (1,3), (1,4), and (2,4).

 Example 2:
 Input: nums = [1,2,3,4,5], target = 5
 Output: 6
 Explanation: The pairs are (0,1), (0,2), (0,3), (0,4), (1,2), and (1,3).
 */
public class CountPairsSumLessThanTarget {

    public int countPairs(int[] nums, int target) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] < target) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountPairsSumLessThanTarget countPairsSumLessThanTarget = new CountPairsSumLessThanTarget();
        System.out.println(countPairsSumLessThanTarget.countPairs(new int[]{1, 1, 2, 2, 3, 3}, 5));    // 8
        System.out.println(countPairsSumLessThanTarget.countPairs(new int[]{1, 2, 3, 4, 5}, 5));

        int[] nums = {1, 2, 3, 4, 5};
        int target = 7;
        System.out.println(countPairsSumLessThanTarget.countPairs(nums, target));
    }
}
