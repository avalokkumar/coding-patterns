package modified_binary_search;

import java.util.*;

/**
 * The K Weakest Rows in a Matrix
 Try to solve The K Weakest Rows in a Matrix problem.

 Statement
 You are given an  m × n
 binary matrix of  1’s (representing soldiers) and  0’s (representing civilians). The soldiers are positioned in front of the civilians, i.e., all the
 1’s will appear to the left of all the 0’s in each row.

 A row i is weaker than a row j if any of the following is TRUE:

 The number of soldiers in row i is less than the number of soldiers in row j.
 Both rows have the same number of soldiers and i < j  .
 You have to return the indexes of the  k weakest rows in the matrix ordered from weakest to strongest.

 Constraints:
 m= matrix.length
 n= matrix[i].length

 2 ≤ n, m ≤100
 2≤n,m≤100
 1 ≤ k ≤ m
 1≤k≤m matrix[i][j] is either
 0 or 1

    Example 1:
    Input: mat = [[1,1,0,0,0],
                  [1,1,1,1,0],
                  [1,0,0,0,0],
                  [1,1,0,0,0],
                  [1,1,1,1,1]], k = 3
    Output: [2,0,3]

    Explanation: The number of soldiers in each row is:
    Row 0: 2
    Row 1: 4
    Row 2: 1
    Row 3: 2
    Row 4: 5
    Rows 2, 0, and 3 are the weakest, ordered from weakest to strongest.

    Example 2:
    Input: mat = [[1,0,0,0],
                  [1,1,1,1],
                  [1,0,0,0],
                  [1,0,0,0]], k = 2
    Output: [0,2]

    Explanation: The number of soldiers in each row is:
    Row 0: 1
    Row 1: 4
    Row 2: 1
    Row 3: 1
    Rows 0 and 2 are the weakest, ordered from weakest to strongest.
 */
public class KWeakestRowInMatrix {

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
        KWeakestRowInMatrix solver = new KWeakestRowInMatrix();
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
