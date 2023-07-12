/*
    Q. Buy and Sell Stocks With Cooldown | (DP – 39)

    Practice : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/

    You are given an array prices where prices[i] is the price of a given stock on the ith day.

    Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
    
    After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
    Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

    Example 1:
    
    Input: prices = [1,2,3,0,2]
    Output: 3
    Explanation: transactions = [buy, sell, cooldown, buy, sell]
    Example 2:
    
    Input: prices = [1]
    Output: 0
*/

// import java.util.Arrays;

public class Buy_and_Sell_Stocks_With_Cooldown {
    /*
       // Recursion
       public static int helper(int[] prices, int i, boolean buy){
           if(i >= prices.length) return 0;
   
           if(!buy) {
               return Math.max(-prices[i] + helper(prices, i + 1, true), helper(prices, i + 1, buy)); 
           }
           else {
               return Math.max(prices[i] + helper(prices, i + 2, false), helper(prices, i + 1, buy)); 
           }
       }
   
       public static int maxProfit(int[] prices) {
           return helper(prices, 0, false);
       }
    */
   
    /*
       // Memoization
       public static int helper(int[] prices, int i, boolean buy, int[][] dp){
           if(i >= prices.length) return 0;
   
           if(dp[i][buy ? 1 : 0] != -1) return dp[i][buy ? 1 : 0];
   
           if(!buy) {
               return dp[i][0] = Math.max(-prices[i] + helper(prices, i + 1, true, dp), helper(prices, i + 1, buy, dp)); 
           }
           else {
               return dp[i][1] = Math.max(prices[i] + helper(prices, i + 2, false, dp), helper(prices, i + 1, buy, dp)); 
           }
       }
   
       public static int maxProfit(int[] prices) {
           int n = prices.length;
           int[][] dp = new int[n][2];
           for(int[] it : dp) Arrays.fill(it, -1);
           return helper(prices, 0, false, dp);
       }
    */
   
    /*
       // Tabulation
       public static int maxProfit(int[] prices) {
           int n = prices.length;
           int[][] dp = new int[n + 2][2];
   
           // As dp array is intialized to 0, we have already covered the base case
   
           for(int i = n - 1; i >= 0; i--){
               for(int buy = 0; buy <= 1; buy++){
                   if(buy == 0) {
                       dp[i][0] = Math.max(-prices[i] + dp[i + 1][1], dp[i + 1][0]); 
                   }
                   else {
                       dp[i][1] = Math.max(prices[i] + dp[i + 2][0], dp[i + 1][1]); 
                   }
               }
           }
   
           return dp[0][0];
       }

       // we can also remove inner buy loop as it is running two times only
       public static int maxProfit(int[] prices) {
           int n = prices.length;
           int[][] dp = new int[n + 2][2];
   
           // As dp array is intialized to 0, we have already covered the base case
   
           for(int i = n - 1; i >= 0; i--){
               // buy
               dp[i][0] = Math.max(-prices[i] + dp[i + 1][1], dp[i + 1][0]); 
               // sell
               dp[i][1] = Math.max(prices[i] + dp[i + 2][0], dp[i + 1][1]); 
           }
   
           return dp[0][0];
       }
    */

    // Space Optimization  
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[] front1 = new int[2];
        int[] front2 = new int[2];
        int[] curr = new int[2];

        // As dp array is intialized to 0, we have already covered the base case

        for(int i = n - 1; i >= 0; i--){
            for(int buy = 0; buy <= 1; buy++){
                if(buy == 0) {
                    curr[0] = Math.max(-prices[i] + front1[1], front1[0]); 
                }
                else {
                    curr[1] = Math.max(prices[i] + front2[0], front1[1]); 
                }
            }
            front2 = front1.clone();
            front1 = curr.clone();
        }

        return curr[0];
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        System.out.println(maxProfit(prices));
    }
}
