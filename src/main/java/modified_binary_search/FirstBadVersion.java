package modified_binary_search;

/**
 * First Bad Version
 * Statement
 * The latest version of a software product fails the quality check. Since each version is developed upon the previous one,
 * all the versions created after a bad version are also considered bad.
 *
 * Suppose you have n versions with the IDs [1,2,...,n], and you have access to an API function that returns TRUE
 * if the argument is the ID of a bad version.
 *
 * Your task is to find the first bad version, which is causing all the later ones to be bad. You have to implement
 * a solution with the minimum number of API calls.
 */
public class FirstBadVersion {

    public static void main(String[] args) {
        int n = 10;
        int firstBadVersion = firstBadVersion(n);
        System.out.println("The first bad version is " + firstBadVersion);

    }

    /**
     * This problem can be solved using the binary search algorithm. We start by selecting the middle version, then check if it is a bad version.
     * If it is, then all the versions after it will be bad, and we should search for the first bad version in the left half. If it is not,
     * then all the versions before it will be good, and we should search for the first bad version in the right half.
     * We repeat this process until we find the first bad version.
     *
     * To implement this, we can use two pointers, left and right, representing the range of versions to search. We initialize left to 1 and
     * right to n. In each iteration, we compute the middle version as mid = left + (right - left) / 2 to avoid integer overflow.
     * We then check if mid is a bad version using the API call. If it is, we set right = mid and continue searching in the left half.
     * If it is not, we set left = mid + 1 and continue searching in the right half.
     * We repeat this process until left and right converge to the first bad version.
     */

    public static int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    static boolean isBadVersion(int version) {
        // assuming the first bad version is 4
        return version >= 4;
    }


}
