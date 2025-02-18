package subsets;

import java.util.ArrayList;
import java.util.List;

/**
 Statement
 Given an input string, word, return all possible permutations of the string.
 Note: The order of permutations does not matter.
 Constraints:
 All characters in word are unique.
 1 ≤ word.length ≤ 6
 All characters in word are lowercase English letters.

 Example 1:
 Input: word = "abc"
 Output: ["abc","acb","bac","bca","cab","cba"]
 Explanation: The possible permutations of the string "abc" are "abc", "acb", "bac", "bca", "cab", and "cba".

 Example 2:
 Input: word = "a"
 Output: ["a"]
 Explanation: The possible permutation of the string "a" is "a".
 */
public class Permutations {

    public List<String> permutations(String word) {
        List<String> result = new ArrayList<>();    // create a list to store the result
        char[] chars = word.toCharArray();   // convert the string to a character array

        generatePermutations(chars, 0, result);  // call the helper function to generate the permutations

        return result;  // return the result
    }

    private void generatePermutations(char[] chars, int index, List<String> result) {
        if (index == chars.length) {    // if the index is equal to the length of the array, then add the string to the result
            result.add(new String(chars));
            return;
        }

        for (int i = index; i < chars.length; i++) {  // iterate through the array
            swap(chars, index, i);  // swap the characters
            generatePermutations(chars, index + 1, result);    // generate the permutations recursively
            swap(chars, index, i);  // swap the characters back
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];   // store the character at index i in a temporary variable
        chars[i] = chars[j];    // swap the characters
        chars[j] = temp;    // swap the characters
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();

        // Example 1
        String word = "abc";
        System.out.println(permutations.permutations(word));    // Output: ["abc","acb","bac","bca","cab","cba"]

        // Example 2
        word = "a";
        System.out.println(permutations.permutations(word));    // Output: ["a"]
    }
}
