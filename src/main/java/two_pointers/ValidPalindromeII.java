package two_pointers;

/**
 * Valid Palindrome II
 * Write a function that takes a string as input and checks whether it can be a valid palindrome by removing at most one character from it.
 *
 */

// It uses two pointers, one starting from the left and one from the right, and checks if each character at the corresponding indices is the same.
// If they are not the same, it checks if the substring after removing the left character or right character is
public class ValidPalindromeII {

    public static void main(String[] args) {
        // Test Case 1: positive scenario
        String s = "aba";
        boolean isValidPalindrome = validPalindrome(s);
        System.out.println("Test Case 1: String: " + s + " is valid palindrome: " + isValidPalindrome);

        // Test Case 2: negative scenario
        String s2 = "abca";
        boolean isValidPalindrome2 = validPalindrome(s2);
        System.out.println("Test Case 2: String: " + s2 + " is valid palindrome: " + isValidPalindrome2);
    }

    public static boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        // Initialize two pointers, one starting from the left and one from the right
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // If the characters at the corresponding indices are not the same,
                // check if the substring after removing the left character or right character is palindrome or not
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            // Increment left pointer and decrement right pointer
            left++;
            right--;
        }
        return true;
    }


    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }


    public static boolean validPalindromeBruteForce(String s) {
        // Iterate through the string
        for (int i = 0; i < s.length(); i++) {
            // Create a new string with the character at the current index removed
            String temp = s.substring(0, i) + s.substring(i + 1);
            // Check if the new string is a palindrome
            if (isPalindrome(temp)) {
                return true;
            }
        }
        // If none of the modified strings are palindromes, return false
        return false;
    }

    private static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
