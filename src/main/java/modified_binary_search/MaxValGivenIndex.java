package modified_binary_search;


/**
 * Maximum Value at a Given Index in a Bounded Array
 Try to solve the Maximum Value at a Given Index in a Bounded Array problem.

 Statement: Given three positive integers, n, index, and maxSum, output the nums[index] by constructing an array of nums with the length of n, which satisfies the following conditions:
 The length of the array nums is equal to n.
 Each element nums[i] is a positive integer, where
 1 ≤ i < n.
 The absolute difference between two consecutive elements, nums[i] and nums[i+1], is at most 1.
 The sum of all elements in nums does not exceed maxSum.
 The element at nums[index] contains the maximum value.

 Ex:
 Input: n = 4, index = 2, maxSum = 6
 Output: 2
 Explanation: The array nums is [1, 2, 2, 1] where the sum is 6 and nums[2] is the maximum value.

 Input: n = 6, index = 1, maxSum = 10
 Output: 3
 Explanation: The array nums is [2, 3, 2, 1, 1, 1] where the sum is 10 and nums[1] is the maximum value.
 */
public class MaxValGivenIndex {

    public int maxValue(int n, int index, int maxSum) {
        int left = 0;   // initialize left to 0. left is used to store the minimum value
        int right = maxSum;     // initialize right to maxSum. right is used to store the maximum value

        while (left < right) {  // iterate through the array
            int mid = left + (right - left) / 2;     // calculate the mid value

            if (isValid(n, index, maxSum, mid)) {    // if the mid value is valid, then update the left value
                left = mid + 1;
            } else {    // if the mid value is not valid, then update the right value
                right = mid;
            }
        }

        return left - 1;    // return the maximum value
    }

    private boolean isValid(int n, int index, int maxSum, int mid) {
        long sum = 0;   // initialize sum to 0. sum is used to store the sum of the array

        sum += Math.max(0, mid - index) + Math.max(0, mid - (n - index - 1));    // add the sum of the left and right side of the array

        long left = mid - 1;    // initialize left to mid - 1. left is used to store the left value
        long right = mid - 1;   // initialize right to mid - 1. right is used to store the right value

        if (left > 0) {     // if the left value is greater than 0, then add the sum of the left side of the array
            sum += (left + 1) * left / 2;
        }

        if (right > 0) {    // if the right value is greater than 0, then add the sum of the right side of the array
            sum += (right + 1) * right / 2;
        }

        return sum <= maxSum;    // return true if the sum is less than or equal to maxSum
    }

    public static void main(String[] args) {
        MaxValGivenIndex obj = new MaxValGivenIndex();
        System.out.println(obj.maxValue(4, 2, 6)); // 2
        System.out.println(obj.maxValue(6, 1, 10)); // 3
    }
}


/**
### **Understanding the Problem**
We need to build an array `nums` of length `n` such that:
        1. `nums[index]` is as large as possible.
2. Each element is at least 1.
        3. The absolute difference between adjacent elements is at most 1.
        4. The sum of all elements does not exceed `maxSum`.

We need to return the maximum value at `nums[index]`.

        ---

        ### **Key Insight**

        - The problem can be rephrased as:
        *"What is the highest possible integer `x` we can place at `nums[index]` while maintaining all the constraints?"*

        - Notice that if `nums[index] = x`, the array forms a "peak" at `index`. Values decrease by 1 as we move away from `index` until reaching 1.

        - To check if a given `x` is possible:
        - Calculate the sum required for this `x`.
        - If the sum is less than or equal to `maxSum`, it is a valid `x`.
        - Otherwise, we need to decrease `x`.

This leads us to a **Binary Search** approach.

---

        ### **Approach: Binary Search on `x`**

        - **Search space:** `low = 1` to `high = maxSum`.
        - **Mid:** `(low + high) / 2`.
        - Check if we can create an array with `nums[index] = mid` without exceeding `maxSum`.
        - Adjust the binary search boundaries based on the feasibility.

---

        ### **How to Calculate the Required Sum for a Given `x`?**

        **Case 1: Left side of the array (indices 0 to index-1):**
        - If `x > left_count` (where `left_count = index`), we form a decreasing sequence from `x-1` down to `x-left_count`.
        - If `x <= left_count`, the left side becomes `[x-1, x-2, ..., 1, 1, 1...]`.

        **Case 2: Right side of the array (indices index+1 to n-1):**
        - Similarly, apply the same logic for the right side.

**Formula for sum of decreasing sequence:**
        \[
        \text{Sum} = \frac{(x + 1) \times x}{2} - \text{sum of trimmed elements if any}
\]

        ---

        ### **Time Complexity:**
        - **O(log(maxSum))** due to binary search.
        - Each feasibility check is O(1).
        - Overall complexity: **O(log(maxSum))**.

        ---

        ### **Space Complexity:**
        - **O(1)** as we use constant extra space.

        ---

        ### **Java Code Implementation**

        ```java
class MaximumValueBoundedArray {
    public int maxValue(int n, int index, int maxSum) {
        int low = 1, high = maxSum;

        while (low < high) {
            int mid = (low + high + 1) / 2;  // Try a higher mid
            if (isValid(mid, n, index, maxSum)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private boolean isValid(int x, int n, int index, int maxSum) {
        long sum = x;  // The peak at index

        // Left side
        int leftCount = index;
        if (x > leftCount) {
            sum += sumOfSequence(x - 1, x - leftCount);
        } else {
            sum += sumOfSequence(x - 1, 1) + (leftCount - (x - 1));
        }

        // Right side
        int rightCount = n - index - 1;
        if (x > rightCount) {
            sum += sumOfSequence(x - 1, x - rightCount);
        } else {
            sum += sumOfSequence(x - 1, 1) + (rightCount - (x - 1));
        }

        return sum <= maxSum;
    }

    private long sumOfSequence(long start, long end) {
        // Sum of arithmetic sequence from start to end
        return (start + end) * (start - end + 1) / 2;
    }

    public static void main(String[] args) {
        MaximumValueBoundedArray solver = new MaximumValueBoundedArray();
        System.out.println(solver.maxValue(4, 2, 6));  // Output: 2
        System.out.println(solver.maxValue(6, 1, 10)); // Output: 3
    }
}
```

**/