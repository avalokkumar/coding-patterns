package k_way_merge;

import java.util.Arrays;

/**
 * Kth Smallest Element in a Sorted Matrix
 * Given an (n×n)
 *  matrix where each row and column is sorted in ascending order, find the k th smallest element in the matrix.
 *
 */
public class KthSmallestElementInMatrix {

    public static void main(String[] args) {
        int[][] matrix1 = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int k1 = 8;
        int result1 = kthSmallest(matrix1, k1);
        System.out.println("Matrix: " + Arrays.deepToString(matrix1));
        System.out.println("k: " + k1);
        System.out.println("Result: " + result1);

        int[][] matrix2 = {{-5}};
        int k2 = 1;
        int result2 = kthSmallest(matrix2, k2);
        System.out.println("Matrix: " + Arrays.deepToString(matrix2));
        System.out.println("k: " + k2);
        System.out.println("Result: " + result2);

        int[][] matrix3 = {{1, 2}, {1, 3}};
        int k3 = 2;
        int result3 = kthSmallest(matrix3, k3);
        System.out.println("Matrix: " + Arrays.deepToString(matrix3));
        System.out.println("k: " + k3);
        System.out.println("Result: " + result3);
    }


    /**
     * * We first initialize the left and right variables to the smallest and largest elements in the matrix, respectively.
     *  * We use a binary search to find the kth smallest element in the matrix. In each iteration of the binary search, we calculate the mid element as the average of left and right.
     *  * We then count the number of elements in the matrix that are less than or equal to mid. We start at the upper-right corner of the matrix and move down to the lower-left corner. For each row, we find the rightmost element that is less than or equal to mid and count the number of elements in that row that are less than or equal to mid. We then add this count to the overall count. At the end of this step, the variable count will contain the total number of elements in the matrix that are less than or equal to mid.
     *  * If count is less than k, we know that the kth smallest element must be greater than mid, so we update left to mid + 1. Otherwise, the kth smallest element must be less than or equal to mid, so we update right to mid.
     *  * We repeat the binary search until left and right are equal, at which point we have found the kth smallest element in the matrix.
     * @param matrix
     * @param k
     * @return
     */
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            int j = n - 1;
            for (int i = 0; i < n; i++) {
                while (j >= 0 && matrix[i][j] > mid) {
                    j--;
                }
                count += j + 1; // count the number of elements less than or equal to mid in the ith row
            }
            if (count < k) {
                left = mid + 1; // if there are less than k elements less than or equal to mid, increase mid
            } else {
                right = mid; // if there are k or more elements less than or equal to mid, decrease mid
            }
        }
        return left; // when left == right, the kth smallest element has been found
    }

}
