package greedy_technique.greedy_technique;

// Jump Game

/**
 * Statement
 In a single-player jump game, the player starts at one end of a series of squares, with the goal of reaching the last square.
 At each turn, the player can take up to s steps towards the last square, where s is the value of the current square.

 For example, if the value of the current square is 3, the player can take either 3 steps, or 2 steps, or 1
 step in the direction of the last square. The player cannot move in the opposite direction, that is, away from the last square.
 You have been tasked with writing a function to validate whether a player can win a given game or not.
 You’ve been provided with the nums integer array, representing the series of squares. The player starts at the first index and, following the rules of the game, tries to reach the last index.
 If the player can reach the last index, your function returns TRUE; otherwise, it returns FALSE.

 Constraints:
 1 ≤ nums.length ≤10^3
 0≤ nums[i] ≤10^3

 Example 1:
 Input: nums = [2,3,1,1,4]
 Output: true
 Explanation: The player can reach the last index by moving from index 0 to index 1, and then to the last index.

 Example 2:
 Input: nums = [3,2,1,0,4]
 Output: false
 Explanation: The player cannot reach the last index.
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int n = nums.length;    // get the length of the array
        int max = 0;    // initialize max to 0. max is used to store the maximum index

        for (int i = 0; i < n; i++) {   // iterate through the array
            if (i > max) {  // if the index is greater than max, then return false
                return false;
            }

            max = Math.max(max, i + nums[i]);   // update the max value with the maximum of max and i + nums[i]
        }

        return true;    // return true
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump(new int[]{2, 3, 1, 1, 4}));    // true
        System.out.println(jumpGame.canJump(new int[]{3, 2, 1, 0, 4}));    // false
    }
}

// Time Complexity: O(n) - n is the length of the array
// Space Complexity: O(1) - no extra space used
