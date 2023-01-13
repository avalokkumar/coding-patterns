package sliding_window;

import java.util.Arrays;

/**
 * Best Time to Buy and Sell Stock
 * Given an array where the element at the index i represents the price of a stock on day i, find the maximum profit that you can gain by buying the stock once and then selling it.
 *
 * Note: Stock can only be purchased on a single day and sold on a different day. If no profit can be achieved, we return zero.
 */
public class BuyAndSellStocks {

    public static void main(String[] args) {
        // Test Case 1:
        int[] prices = {7,1,5,3,6,4};
        int result = maxProfit(prices);
        System.out.println("Test Case 1: The maximum profit that can be gained by buying and selling stock in " + Arrays.toString(prices) + " is: " + result);

        // Test Case 2:
        int[] prices2 = {7,6,4,3,1};
        int result2 = maxProfit(prices2);
        System.out.println("Test Case 2: The maximum profit that can be gained by buying and selling stock in " + Arrays.toString(prices2) + " is: " + result2);
    }

    /**
     * In the above test case 1, the input array is [7,1,5,3,6,4], the output will be Test Case 1: The maximum profit that can be gained by buying and selling stock in [7, 1, 5, 3, 6, 4] is: 5
     * In test case 2, the input array is [7,6,4,3,1], the output will be Test Case 2: The maximum profit that can be gained by buying and selling stock in [7, 6, 4, 3, 1] is: 0
     *
     * This solution has O(n) time complexity and O(1) space
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

}
