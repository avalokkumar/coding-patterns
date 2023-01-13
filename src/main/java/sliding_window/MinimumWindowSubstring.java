package sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * Minimum Window Substring
 * Given two strings—s and t, find the smallest window substring of t. The smallest window substring is the shortest sequence of characters in s that includes all of the characters present in t. The frequency of each character in this sequence should be greater than or equal to the frequency of each character in t. The order of the characters doesn’t matter here.
 *
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) {
        // Test Case 1:
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = minWindow(s, t);
        System.out.println("Test Case 1: Minimum window substring of " + t + " in " + s + " is: " + result);

        // Test Case 2:
        String s2 = "aabdcef";
        String t2 = "abc";
        String result2 = minWindow(s2, t2);
        System.out.println("Test Case 2: Minimum window substring of " + t2 + " in " + s2 + " is: " + result2);
    }

    /**
     * In the above test case 1, the input string is "ADOBECODEBANC" and t = "ABC", the output will be `Test Case 1: Minimum window substring of ABC in ADOBECODEBANC is: BANC`
     * In test case 2, the input string is "aabdcef" and t = "abc", the output will be `Test Case 2: Minimum window substring of abc in aabdcef is: `
     *
     * This solution has O(n) time complexity and O(n) space complexity as it uses a HashMap to store the count of each character in t and in the current window, and it iterates over the string s once.
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {
        // create a map to store the count of each character in t
        Map<Character, Integer> tCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        String res = "";
        // create a map to store the count of each character in the current window
        Map<Character, Integer> windowCount = new HashMap<>();
        int match = 0;
        // iterate over the string s
        while (right < s.length()) {
            char c = s.charAt(right);
            // add the character to the window count map
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);
            // if the count of the character in the window is greater than or equal to the count in t
            if (tCount.containsKey(c) && windowCount.get(c) >= tCount.get(c)) {
                match++;
            }

            // if all characters in t are present in the current window
            while (match == tCount.size()) {
                // update the result if the current window is smaller
                if (minLength > right - left + 1) {
                    minLength = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                // remove the leftmost character from the window
                char leftChar = s.charAt(left);
                windowCount.put(leftChar, windowCount.get(leftChar) - 1);
                if (tCount.containsKey(leftChar) && windowCount.get(leftChar) < tCount.get(leftChar)) {
                    match--;
                }
                left++;
            }
            right++;
        }
        return res;
    }

}
