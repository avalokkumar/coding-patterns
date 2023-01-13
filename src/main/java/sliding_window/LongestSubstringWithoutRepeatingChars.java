package sliding_window;


import java.util.HashSet;
import java.util.Set;

/**
 * Longest Substring without Repeating Characters
 * Given a string, inputString find the longest substring without repeating characters, and return the length of that longest substring.
 *
 */
public class LongestSubstringWithoutRepeatingChars {

    public static void main(String[] args) {
        // Test Case 1:
        String inputString = "abcabcbb";
        int result = longestSubstringWithoutRepeatingCharacters(inputString);
        System.out.println("Test Case 1: The length of the longest substring without repeating characters in " + inputString + " is: " + result);

        // Test Case 2:
        String inputString2 = "bbbbb";
        int result2 = longestSubstringWithoutRepeatingCharacters(inputString2);
        System.out.println("Test Case 2: The length of the longest substring without repeating characters in " + inputString2 + " is: " + result2);
    }

    /**
     * In the above test case 1, the input string is "abcabcbb", the output will be `Test Case 1: The length of the longest substring without repeating characters in abcabcbb is: 3`
     * In test case 2, the input string is "bbbbb", the output will be `Test Case 2: The length of the longest substring without repeating characters in bbbbb is: 1`
     *
     * This solution has O(n) time complexity and O(n) space complexity as it uses a HashSet to store the characters in the current substring, and it iterates over the string once.
     * @param inputString
     * @return
     */
    public static int longestSubstringWithoutRepeatingCharacters(String inputString) {
        int maxLength = 0;
        int start = 0;
        // create a set to store the characters in the current substring
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            // if the current character is not in the set
            if (!set.contains(c)) {
                set.add(c);
                maxLength = Math.max(maxLength, i - start + 1);
            } else {
                // remove characters from the start of the substring until the current character is removed
                while (set.contains(c)) {
                    set.remove(inputString.charAt(start));
                    start++;
                }
                set.add(c);
            }
        }
        return maxLength;
    }

}
