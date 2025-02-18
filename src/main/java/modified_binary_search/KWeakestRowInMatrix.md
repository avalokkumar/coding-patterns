### **Understanding the Problem**

We are given an `m x n` binary matrix where:
- Each row is sorted with all `1`s (soldiers) first, followed by `0`s (civilians).
- We need to find the indices of the `k` weakest rows.

**Weakness Criteria:**
1. A row with fewer soldiers is weaker.
2. If two rows have the same number of soldiers, the row with the smaller index is weaker.

**What we need to return:**
- The indices of the `k` weakest rows, sorted from weakest to strongest.

---

### **Key Insight**

- We need to count the number of soldiers (1’s) in each row.
- We then sort the rows by the number of soldiers, and if there is a tie, by the row index.
- Return the first `k` indices after sorting.

---

### **Constraints and Observations**
- `m, n ≤ 100` → Matrix is small, so even an O(m * n) solution is efficient.
- We can simply:
    1. Iterate through each row.
    2. Count the 1’s using `sum()` or `binary search` (since rows are sorted).
    3. Store `(soldier_count, row_index)` in a list.
    4. Sort the list by `soldier_count` and `row_index`.
    5. Return the first `k` indices.

---

### **Time Complexity Analysis**
- Counting soldiers for each row: O(m * n)
- Sorting the list of `m` rows: O(m log m)
- Overall complexity: **O(m * n + m log m)** which is efficient for `m, n ≤ 100`.

---

### **Space Complexity Analysis**
- We use extra space for a list of size `m`, so **O(m)**.

---

### **Edge Cases**
1. **All rows have the same number of soldiers:** In this case, sorting by row index ensures correctness.
2. **Rows with all soldiers (1’s):** Handle cases where a row has `n` soldiers.
3. **Rows with no soldiers (0’s):** Handle cases where a row has `0` soldiers.
4. **k equals `m`:** Return all rows sorted by weakness.

---

### **Example Walk-through**

**Input:**
```
matrix = [
  [1, 1, 0, 0, 0],
  [1, 1, 1, 1, 0],
  [1, 0, 0, 0, 0],
  [1, 1, 0, 0, 0],
  [1, 1, 1, 0, 0]
]
k = 3
```

**Step-by-step:**
- Row 0: 2 soldiers
- Row 1: 4 soldiers
- Row 2: 1 soldier
- Row 3: 2 soldiers
- Row 4: 3 soldiers

**Sorted by soldiers and index:**
- Row 2: 1 soldier
- Row 0: 2 soldiers
- Row 3: 2 soldiers
- Row 4: 3 soldiers
- Row 1: 4 soldiers

**Pick the first `k=3`:** `[2, 0, 3]`

---

### **Java Implementation**

```java
import java.util.*;

class KWeakestRows {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        // Create a list of pairs (soldierCount, rowIndex)
        List<int[]> rowStrength = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int count = countSoldiers(mat[i]);
            rowStrength.add(new int[]{count, i});
        }

        // Sort by soldier count, then by row index
        Collections.sort(rowStrength, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        // Extract the first k indices
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = rowStrength.get(i)[1];
        }

        return result;
    }

    private int countSoldiers(int[] row) {
        int count = 0;
        for (int val : row) {
            if (val == 1) count++;
            else break;  // Since the row is sorted
        }
        return count;
    }

    public static void main(String[] args) {
        KWeakestRows solver = new KWeakestRows();
        int[][] mat = {
            {1, 1, 0, 0, 0},
            {1, 1, 1, 1, 0},
            {1, 0, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {1, 1, 1, 0, 0}
        };
        int k = 3;
        System.out.println(Arrays.toString(solver.kWeakestRows(mat, k)));  // Output: [2, 0, 3]
    }
}
```

---

### **Alternative Optimization**

- Instead of linear counting, use **Binary Search** to find the last occurrence of `1` in each row, reducing the counting step to **O(log n)**.
- This would result in an overall time complexity of **O(m log n + m log m)**, which is still efficient for the given constraints.

---

### **Takeaways**
- Sorting rows based on their soldier count is key.
- Binary search or direct counting is possible since rows are sorted.
- This solution is both intuitive and efficient for the given constraints. 😊