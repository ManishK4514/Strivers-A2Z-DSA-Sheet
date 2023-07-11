/*
    Q. Buy and Sell Stock – II | (DP -36)

    Practice : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/

    You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

    On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
    
    Find and return the maximum profit you can achieve.

    Example 1:
    
    Input: prices = [7,1,5,3,6,4]
    Output: 7
    Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
    Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
    Total profit is 4 + 3 = 7.
    Example 2:
    
    Input: prices = [1,2,3,4,5]
    Output: 4
    Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
    Total profit is 4.
    Example 3:
    
    Input: prices = [7,6,4,3,1]
    Output: 0
    Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
*/

// import java.util.Arrays;

public class Buy_and_Sell_Stock_II {
    /* 
       // My First Solution
       public static int helper(int[] prices, int i, boolean taken,  int[][] dp){
           if(i == prices.length) return 0;
   
           if(dp[i][taken ? 1 : 0] != -1) return dp[i][taken ? 1 : 0];
           
           int buy = 0, sell = 0;
   
           // buy
           if(!taken) {
               buy = helper(prices, i + 1, true, dp) - prices[i];
           }
   
           // sell
           if(taken) {
               sell = helper(prices, i + 1, false, dp) + prices[i];
           }
   
           // move
           int move = helper(prices, i + 1, taken, dp);
   
           return dp[i][taken ? 1 : 0] = Math.max(buy, Math.max(sell, move));
       }
   
       public static int maxProfit(int[] prices) {
           int n = prices.length;
           int[][] dp = new int[n][2];
           for(int[] it : dp) Arrays.fill(it, -1);
           return helper(prices, 0, false, dp);
       }
    */
   
    /*
       // Recursion
       public static int helper(int[] prices, int i, boolean buy){
           if(i == prices.length) return 0;
           
           if(!buy){
               // take the max of buy or move
               return Math.max(-prices[i] + helper(prices, i + 1, true), helper(prices, i + 1, false));
           }
           else{
               // take the max of sell or move
               return Math.max(prices[i] + helper(prices, i + 1, false), helper(prices, i + 1, true));
           }
       }
   
       public static int maxProfit(int[] prices) {
           int n = prices.length;
           return helper(prices, 0, false);
       }
    */
   
    /*
       // Memoization
       public static int helper(int[] prices, int i, boolean buy,  int[][] dp){
           if(i == prices.length) return 0;
   
           if(dp[i][buy ? 1 : 0] != -1) return dp[i][buy ? 1 : 0];
   
           if(!buy){
               // take the max of buy or move
               return dp[i][0] = Math.max(-prices[i] + helper(prices, i + 1, true, dp), helper(prices, i + 1, false, dp));
           }
           else{
               // take the max of sell or move
               return dp[i][1] = Math.max(prices[i] + helper(prices, i + 1, false, dp), helper(prices, i + 1, true, dp));
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
           int[][] dp = new int[n + 1][2];
           
           // we can also skip base case, because it's already filled with zeros
           dp[n][0] = dp[n][1] = 0;
   
           for(int i = n - 1; i >= 0; i--){
               for(int buy = 0; buy <= 1; buy++){
                   if(buy == 0){
                       // take the max of buy or move
                       dp[i][0] = Math.max(-prices[i] + dp[i + 1][1], dp[i + 1][0]);
                   }
                   else{
                       // take the max of sell or move
                       dp[i][1] = Math.max(prices[i] + dp[i + 1][0], dp[i + 1][1]);
                   }
               }
           }
   
           return dp[0][0];
       }
    */

    /*
       // Space Optimization  
       public static int maxProfit(int[] prices) {
           int n = prices.length;
           int[] ahead = new int[2];
           int[] curr = new int[2];
           
           // we can also skip base case, because it's already filled with zeros
           ahead[0] = ahead[1] = 0;
   
           for(int i = n - 1; i >= 0; i--){
               for(int buy = 0; buy <= 1; buy++){
                   if(buy == 0){
                       // take the max of buy or move
                       curr[0] = Math.max(-prices[i] + ahead[1], ahead[0]);
                   }
                   else{
                       // take the max of sell or move
                       curr[1] = Math.max(prices[i] + ahead[0], ahead[1]);
                   }
               }
               ahead = curr.clone();
           }
   
           return ahead[0];
       }
    */

    // using 4 variables
    
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int aheadBuy, aheadNotBuy, currBuy, currNotBuy;
        
        aheadNotBuy = aheadBuy = 0;

        for(int i = n - 1; i >= 0; i--){
            currNotBuy = Math.max(-prices[i] + aheadBuy, aheadNotBuy);
            currBuy = Math.max(prices[i] + aheadNotBuy, aheadBuy);
            aheadNotBuy = currNotBuy;
            aheadBuy = currBuy;
        }

        return aheadNotBuy;
    }
    
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
