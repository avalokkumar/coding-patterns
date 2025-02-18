package subsets;

// Generate Parentheses

import java.util.ArrayList;
import java.util.List;

/**
 * For a given number, n, generate all combinations of balanced parentheses.

 Constraints:
 1 ≤ n ≤ 10

 Example 1:
 Input: n = 3
 Output: ["((()))","(()())","(())()","()(())","()()()"]
 Explanation: The possible combinations of balanced parentheses for n = 3 are "((()))", "(()())", "(())()", "()(())", and "()()()".

 Example 2:
 Input: n = 1
 Output: ["()"]
 Explanation: The possible combinations of balanced parentheses for n = 1 is "()".
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();    // create a list to store the result

        generateParentheses(n, 0, 0, "", result);    // call the helper function to generate the parentheses

        return result;  // return the result
    }

    private void generateParentheses(int n, int open, int close, String current, List<String> result) {
        if (current.length() == 2 * n) {    // if the length of the string is equal to 2 * n, then add the current string to the result
            result.add(current);
            return;
        }

        if (open < n) {     // if the number of open parentheses is less than n, then add an open parenthesis
            generateParentheses(n, open + 1, close, current + "(", result);
        }

        if (close < open) {     // if the number of close parentheses is less than open parentheses, then add a close parenthesis
            generateParentheses(n, open, close + 1, current + ")", result);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();

        System.out.println(generateParenthesis.generateParenthesis(3));    // [((())), (()()), (())(), ()(()), ()()()]
        System.out.println(generateParenthesis.generateParenthesis(1));    // [()]
    }
}
