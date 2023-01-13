package two_pointers;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        // Initialize two pointers, one at the start of the string and one at the end
        int i = 0;
        int j = s.length() - 1;
        // Loop through the string while the pointers have not met in the middle
        while (i < j) {
            // Compare the characters at the current pointer positions
            if (s.charAt(i) != s.charAt(j)) {
                // If they are not the same, return false (string is not a palindrome)
                return false;
            }
            // If they are the same, move the pointers towards the middle
            i++;
            j--;
        }
        // If the loop completes, the string must be a palindrome, so return true
        return true;
    }

    public static void main(String[] args) {
        String test1 = "racecar";
        String test2 = "hello";
        String test3 = "madam";
        String test4 = "a";
        System.out.println(test1 + ": " + isPalindrome(test1));
        System.out.println(test2 + ": " + isPalindrome(test2));
        System.out.println(test3 + ": " + isPalindrome(test3));
        System.out.println(test4 + ": " + isPalindrome(test4));
    }
}
