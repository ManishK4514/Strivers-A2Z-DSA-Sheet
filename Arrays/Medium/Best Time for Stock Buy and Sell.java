/*
 * Stock Buy And Sell
   Problem Statement: You are given an array of prices where prices[i] is the price of a given stock on an ith day.
   
   You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock. Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
   
   Examples:
   
   Example 1:
   Input: prices = [7,1,5,3,6,4]
   Output: 5
   Explanation: Buy on day 2 (price = 1) and 
   sell on day 5 (price = 6), profit = 6-1 = 5.
   
   Note: That buying on day 2 and selling on day 1 
   is not allowed because you must buy before 
   you sell.
   
   Example 2:
   Input: prices = [7,6,4,3,1]
   Output: 0
   Explanation: In this case, no transactions are 
   done and the max profit = 0.
*/


public class Best_Time_to_Buy_and_Sell_Stock {
    public static int maxProfit(int[] prices) {
        /*
         * BruteForce Approach: Find every possible profit and compare with the maxprofit and then set the maximum profit among them into maxprofit.
         * Time complexity: O(N^2) & Space complexity: O(1).
         * int maxProfit = 0;
           for(int i = 0; i < prices.length; i++){
               for(int j = i + 1; j < prices.length; j++){
                   if(prices[i] < prices[j]){
                       maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
                   }
               }
           }
           return maxProfit;
        */

        // Optimized Solution: Time Complexity: O(N) & Space complexity: O(1)
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;
        for(int i = 0; i < prices.length; i++){
            minPrice = Math.min(minPrice, prices[i]);
            profit = Math.max(profit, prices[i] - minPrice);
        }
        return profit;
    }
    public static void main(String[] args) {
        int[] prices = {0, 1};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }
}
