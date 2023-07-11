/*
    Q. Buy and Sell Stock – IV | (DP – 38)

    Practice : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/

    You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

    Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.
    
    Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
        
    Example 1:
    
    Input: k = 2, prices = [2,4,1]
    Output: 2
    Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
    Example 2:
    
    Input: k = 2, prices = [3,2,6,5,0,3]
    Output: 7
    Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
*/

public class Buy_and_Stock_Sell_IV {
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
           return helper(prices, 0, false, k);
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
           int[][][] dp = new int[n][2][k + 1];
           for(int[][] it : dp) for(int[] it2 : it) Arrays.fill(it2, -1);
           return helper(prices, 0, false, k, dp);
       }
    */
   
    /*
       // Tabulation
       public static int maxProfit(int k, int[] prices) {
            int n = prices.length;
            int[][][] dp = new int[n + 1][2][k + 1];
    
            // As dp array is intialized to 0, we have already covered the base case
    
            for(int i = n - 1; i >= 0; i--){
                for(int buy = 0; buy <= 1; buy++){
                    for(int cap = 1; cap <= k; cap++){
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
    
            return dp[0][0][k];
        }
    */

    // Space Optimization  

    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] ahead = new int[2][k + 1];
        int[][] curr = new int[2][k + 1];
   
        // As dp array is intialized to 0, we have already covered the base case
   
        for(int i = n - 1; i >= 0; i--){
            for(int buy = 0; buy <= 1; buy++){
                for(int cap = 1; cap <= k; cap++){
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
   
        return ahead[0][k];
    }

    public static void main(String[] args) {
        int k = 2;
        int[] prices = {3,2,6,5,0,3};
        System.out.println(maxProfit(k, prices));
    }
}
