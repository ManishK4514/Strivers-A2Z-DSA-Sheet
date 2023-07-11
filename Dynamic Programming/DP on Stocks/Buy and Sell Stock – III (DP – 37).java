/*
    Q. Buy and Sell Stock – III | (DP – 37)

    Practice : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/

    You are given an array prices where prices[i] is the price of a given stock on the ith day.

    Find the maximum profit you can achieve. You may complete at most two transactions.
    
    Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

    Example 1:
    
    Input: prices = [3,3,5,0,0,3,1,4]
    Output: 6
    Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
    Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
    Example 2:
    
    Input: prices = [1,2,3,4,5]
    Output: 4
    Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
    Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
    Example 3:
    
    Input: prices = [7,6,4,3,1]
    Output: 0
    Explanation: In this case, no transaction is done, i.e. max profit = 0.
*/

// import java.util.Arrays;

public class Buy_and_Sell_Stocks_III {
    /*
                                           Method 1
      ____________________________________________________________________________________________

    */


    /*
       // Recursion
       public static int helper(int[] prices, int i, boolean buy, int cap){
           if(i == prices.length || cap == 0) return 0;
   
           if(!buy) {
               // take the max of buy or move
               return Math.max(-prices[i] + helper(prices, i + 1, true, cap), helper(prices, i + 1, false, cap));
           }
           else {
               // take the max of sell or move
               return Math.max(prices[i] + helper(prices, i + 1, false, cap - 1), helper(prices, i + 1, true, cap));
           }
       }
   
       public static int maxProfit(int[] prices) {
           return helper(prices, 0, false, 2);
       }
    */
   
    /*
       // Memoization
       public static int helper(int[] prices, int i, boolean buy, int cap, int[][][] dp){
           if(i == prices.length || cap == 0) return 0;
   
           if(dp[i][buy ? 1 : 0][cap] != -1) return dp[i][buy ? 1 : 0][cap];
   
           if(!buy) {
               // take the max of buy or move
               return dp[i][0][cap] = Math.max(-prices[i] + helper(prices, i + 1, true, cap, dp), helper(prices, i + 1, false, cap, dp));
           }
           else {
               // take the max of sell or move
               return dp[i][1][cap] = Math.max(prices[i] + helper(prices, i + 1, false, cap - 1, dp), helper(prices, i + 1, true, cap, dp));
           }
       }
   
       public static int maxProfit(int[] prices) {
           int n = prices.length;
           int[][][] dp = new int[n][2][3];
           for(int[][] it : dp) for(int[] it2 : it) Arrays.fill(it2, -1);
           return helper(prices, 0, false, 2, dp);
       }
    */
   
    /*
       // Tabulation
       public static int maxProfit(int[] prices) {
            int n = prices.length;
            int[][][] dp = new int[n + 1][2][3];
    
            // As dp array is intialized to 0, we have already covered the base case
    
            for(int i = n - 1; i >= 0; i--){
                for(int buy = 0; buy <= 1; buy++){
                    for(int cap = 1; cap <= 2; cap++){
                        if(buy == 0) {
                            // take the max of buy or move
                            dp[i][0][cap] = Math.max(-prices[i] + dp[i + 1][1][cap], dp[i + 1][0][cap]);
                        }
                        if(buy == 1) {
                            // take the max of sell or move
                            dp[i][1][cap] = Math.max(prices[i] + dp[i + 1][0][cap - 1], dp[i + 1][1][cap]);
                        }
                    }
                }
            }
    
            return dp[0][0][2];
        }
    */

    /*
       // Space Optimization  
       public static int maxProfit(int[] prices) {
           int n = prices.length;
           int[][] ahead = new int[2][3];
           int[][] curr = new int[2][3];
   
           // As dp array is intialized to 0, we have already covered the base case
   
           for(int i = n - 1; i >= 0; i--){
               for(int buy = 0; buy <= 1; buy++){
                   for(int cap = 1; cap <= 2; cap++){
                       if(buy == 0) {
                           // take the max of buy or move
                           curr[0][cap] = Math.max(-prices[i] + ahead[1][cap], ahead[0][cap]);
                       }
                       if(buy == 1) {
                           // take the max of sell or move
                           curr[1][cap] = Math.max(prices[i] + ahead[0][cap - 1], ahead[1][cap]);
                       }
                   }
               }
               ahead = curr.clone();
           }
   
           return ahead[0][2];
       }
    */
    

    /*
                                           Method 2
      ____________________________________________________________________________________________
      
      int[][] ahead = new int[2][3];
      instead of using [2][3] matrix (2 * 3)
      we can use (4 size array for -> buy, sell, buy, sell)
                                       0     1    2     3
      because we have to perform two transaction that means
      buy then sell then again buy and sell so we can take
      array of size 4 and represent in index 0, 1, 2, 3    
      
      and on even index i.e 0 & 2 we have to buy
      and on odd index i.e 1 & 3 we have to sell

    */

    /*
       // Recursion
       public static int helper(int[] prices, int i, int transaction){
           if(i == prices.length || transaction == 4) return 0;
   
           if(transaction % 2 == 0) {
               // take the max of buy or move
               return Math.max(-prices[i] + helper(prices, i + 1, transaction + 1), helper(prices, i + 1, transaction));
           }
           else {
               // take the max of sell or move
               return Math.max(prices[i] + helper(prices, i + 1, transaction + 1), helper(prices, i + 1, transaction));
           }
       }
       
       public static int maxProfit(int[] prices) {
           return helper(prices, 0, 0);
       }
    */
   
    /*
       // Memoization
       public static int helper(int[] prices, int i, int transaction, int[][] dp){
           if(i == prices.length || transaction == 4) return 0;
   
           if(dp[i][transaction] != -1) return dp[i][transaction];
   
           if(transaction % 2 == 0) {
               // take the max of buy or move
               return dp[i][transaction] = Math.max(-prices[i] + helper(prices, i + 1, transaction + 1, dp), helper(prices, i + 1, transaction, dp));
           }
           else {
               // take the max of sell or move
               return dp[i][transaction] = Math.max(prices[i] + helper(prices, i + 1, transaction + 1, dp), helper(prices, i + 1, transaction, dp));
           }
       }
       
       public static int maxProfit(int[] prices) {
           int n = prices.length;
           int[][] dp = new int[n][4];
           for(int[] it : dp) Arrays.fill(it, -1);
           return helper(prices, 0, 0, dp);
       }
    */
   
    /*
       // Tabulation
       public static int maxProfit(int[] prices) {
           int n = prices.length;
           int[][] dp = new int[n + 1][5];

           // As dp array is intialized to 0, we have already covered the base case
      
           for(int i = n - 1; i >= 0; i--){
               for(int transaction = 0; transaction < 4; transaction++){
                   if(transaction % 2 == 0) {
                       // take the max of buy or move
                       dp[i][transaction] = Math.max(-prices[i] + dp[i + 1][transaction + 1], dp[i + 1][transaction]);
                   }
                   else {
                       // take the max of sell or move
                       dp[i][transaction] = Math.max(prices[i] + dp[i + 1][transaction + 1], dp[i + 1][transaction]);
                   }
               }
           }
           return dp[0][0];
       }
    */
    
    // Space Optimization  
    
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[] ahead = new int[5];
        int[] curr = new int[5];

        for(int i = n - 1; i >= 0; i--){
            for(int transaction = 0; transaction < 4; transaction++){
                if(transaction % 2 == 0) {
                    // take the max of buy or move
                    curr[transaction] = Math.max(-prices[i] + ahead[transaction + 1], ahead[transaction]);
                }
                else {
                    // take the max of sell or move
                    curr[transaction] = Math.max(prices[i] + ahead[transaction + 1], ahead[transaction]);
                }
            }
            ahead = curr.clone();
        }
        return ahead[0];
    }
    
    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(prices));
    }
}
