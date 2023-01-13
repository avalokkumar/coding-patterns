package sliding_window;

/**
 * Minimum Window Subsequence
 * Given strings str1 and str2, find the minimum (contiguous) substring subStr of str1, such that every character of str2 appears in subStr in the same order as it is present in str2.
 *
 * If there is no window in str1 that covers all characters in str2, return an empty string.
 *
 * If there are multiple minimum-length windows, return the one with the leftmost starting index.
 *
 */
public class MaxWindowSubsequence {

    public static void main(String[] args) {
        // Test Case 1:
        String str1 = "abcdefg";
        String str2 = "ab";
        String minWindow = minWindow(str1, str2);
        System.out.println("Test Case 1: Minimum window substring: " + minWindow);

        // Test Case 2:
        String str3 = "abcdefg";
        String str4 = "abx";
        String minWindow2 = minWindow(str3, str4);
        System.out.println("Test Case 2: Minimum window substring: " + minWindow2);
    }

    public static String minWindow(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        // initialize dp[0][i] as i+1
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i + 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // if str1[j-1] is equal to str2[i-1], then take the value of dp[i-1][j-1]
                if (str1.charAt(j - 1) == str2.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // if not equal, take the value of dp[i][j-1]
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        int start = 0, len = n + 1;
        // iterate through last row of the dp array and find the minimum window substring with leftmost starting index
        for (int i = 1; i <= n; i++) {
            if (dp[m][i] != 0) {
                if (i - dp[m][i] + 1 < len) {
                    start = dp[m][i] - 1;
                    len = i - dp[m][i] + 1;
                }
            }
        }

        return len == n + 1 ? "" : str1.substring(start, start + len);
    }

}
