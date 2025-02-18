### **Understanding the Problem**

We are given:
- An integer array `nums` of length `n`.
- An integer `target`.

We need to find the number of pairs `(i, j)` where:
- `0 ≤ i < j < n` (i comes before j).
- The sum `nums[i] + nums[j] < target`.

---

### **Constraints and Observations**

- `n` can be at most `50` → Brute force solution is efficient enough.
- We need to consider all pairs, but only distinct pairs `(i, j)`.
- The values in `nums` and `target` range from `-50` to `50`, so negative numbers are also involved.

---

### **Approach**

**1. Brute Force (O(n²))**:
- Iterate over all pairs `(i, j)` with `i < j`.
- Check if `nums[i] + nums[j] < target`.
- Increment the count if the condition is met.
- Return the count at the end.

This solution is acceptable because `n ≤ 50` and `O(n²)` is `O(2500)`, which is efficient enough.

---

### **Time Complexity Analysis**
- Nested loops lead to `O(n²)` time complexity.
- With `n = 50`, this is manageable.

### **Space Complexity Analysis**
- No additional data structures are used, so space complexity is `O(1)`.

---

### **Edge Cases**
- All positive numbers with a high target.
- All negative numbers with a low target.
- Mixed positive and negative numbers.
- The smallest array with `n = 1` (no pairs).
- `target` being larger than all possible sums.
- `target` being smaller than all possible sums (result is 0).

---

### **Example Walk-through**

**Example:**
```
nums = [1, 2, 3, 4, 5], target = 7
```
**Step-by-step:**
- (1, 2) sum = 3 < 7 ✅
- (1, 3) sum = 4 < 7 ✅
- (1, 4) sum = 5 < 7 ✅
- (1, 5) sum = 6 < 7 ✅
- (2, 3) sum = 5 < 7 ✅
- (2, 4) sum = 6 < 7 ✅
- (2, 5) sum = 7 == 7 ❌
- (3, 4) sum = 7 == 7 ❌
- (3, 5) sum = 8 > 7 ❌
- (4, 5) sum = 9 > 7 ❌

**Total count:** 6

---

### **Java Implementation**

```java
class CountPairsLessThanTarget {
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
        CountPairsLessThanTarget solution = new CountPairsLessThanTarget();
        int[] nums = {1, 2, 3, 4, 5};
        int target = 7;
        System.out.println(solution.countPairs(nums, target));  // Output: 6
    }
}
```

---

### **Potential Optimizations**

- Since the constraints are small, brute force is enough.
- If `n` were larger, we could:
    1. Sort the array.
    2. Use two pointers from start and end.
    3. Move the pointers based on the sum comparisons.
- But for `n ≤ 50`, the two-pointer approach is not required.

---

### **Final Thoughts**
- Simple brute force works perfectly here.
- Make sure to cover edge cases, including negative numbers.
- This problem is straightforward, but it helps in understanding pair-based problems. 😊