package subsets;

import java.util.ArrayList;
import java.util.List;

// Letter Combinations of a Phone Number
/*
Given a string containing digits from 2 to 9 inclusive, with the possibility of each digit appearing multiple times, return all possible letter combinations that the number could represent. Return the answer in any order.

The illustration below shows the mapping of digits to letters in a telephone dial pad.
Note: The number 1 on the telephone dial pad does not correspond to any letter, so the input string only contains digits from 2 to 9.
Ex: dial pad 1: [], dial pad 2: [a, b, c], dial pad 3: [d, e, f], dial pad 4: [g, h, i], dial pad 5: [j, k, l], dial pad 6: [m, n, o], dial pad 7: [p, q, r, s], dial pad 8: [t, u, v], dial pad 9: [w, x, y, z]

Constraints:
0 ≤ digits.length ≤4
digits[i] is a digit in the range [2,9]

Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Explanation: The possible letter combinations of the string "23" are "ad", "ae", "af", "bd", "be", "bf", "cd", "ce", and "cf".
*/
public class LetterCombinationPhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();    // create a list to store the result

        if (digits.isEmpty()) {     // if the length of the string is 0, then return the result
            return result;
        }

        String[] mapping = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};    // create a mapping array

        generateCombinations(digits, 0, "", mapping, result);    // call the helper function to generate the combinations

        return result;  // return the result
    }

    private void generateCombinations(String digits, int index, String current, String[] mapping, List<String> result) {
        if (index == digits.length()) {     // if the index is equal to the length of the string, then add the current string to the result
            result.add(current);
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];    // get the letters corresponding to the digit

        for (int i = 0; i < letters.length(); i++) {    // iterate through the letters
            generateCombinations(digits, index + 1, current + letters.charAt(i), mapping, result);    // generate the combinations recursively
        }
    }

    public static void main(String[] args) {
        LetterCombinationPhoneNumber lcpn = new LetterCombinationPhoneNumber();
        System.out.println(lcpn.letterCombinations("23"));    // Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
    }
}
