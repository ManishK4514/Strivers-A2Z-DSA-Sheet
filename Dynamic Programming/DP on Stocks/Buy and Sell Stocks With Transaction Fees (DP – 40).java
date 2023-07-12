/*
    Q. Buy and Sell Stocks With Transaction Fees | (DP – 40)

    Practice : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/

    Given an integer array nums, return the length of the longest strictly increasing 
    subsequence.
    
    Example 1:
    
    Input: nums = [10,9,2,5,3,7,101,18]
    Output: 4
    Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
    Example 2:
    
    Input: nums = [0,1,0,3,2,3]
    Output: 4
    Example 3:
    
    Input: nums = [7,7,7,7,7,7,7]
    Output: 1
*/

// import java.util.Arrays;

public class Buy_and_Sell_Stocks_With_Transaction_Fees {
    /*
       // Recursion
       public static int helper(int[] prices, int i, boolean buy, int fee){
           if(i == prices.length) return 0;
   
           if(!buy) {
               return Math.max(-prices[i] - fee + helper(prices, i + 1, true, fee), helper(prices, i + 1, false, fee)); 
           }
           else {
               return Math.max(prices[i] + helper(prices, i + 1, false, fee), helper(prices, i + 1, true, fee)); 
           }
       }
   
       public static int maxProfit(int[] prices, int fee) {
           return helper(prices, 0, false, fee);
       }
    */
   
    /*
       // Memoization
       public static int helper(int[] prices, int i, boolean buy, int fee, int[][] dp){
           if(i == prices.length) return 0;
   
           if(dp[i][buy ? 1 : 0] != -1) return dp[i][buy ? 1 : 0];
   
           if(!buy) {
               return dp[i][0] = Math.max(-prices[i] - fee + helper(prices, i + 1, true, fee, dp), helper(prices, i + 1, false, fee, dp)); 
           }
           else {
               return dp[i][1] = Math.max(prices[i] + helper(prices, i + 1, false, fee, dp), helper(prices, i + 1, true, fee, dp)); 
           }
       }
   
       public static int maxProfit(int[] prices, int fee) {
           int n = prices.length;
           int[][] dp = new int[n][2];
           for(int[] it : dp) Arrays.fill(it, -1);
           return helper(prices, 0, false, fee, dp);
       }
    */
   
    /*
       // Tabulation
       public static int maxProfit(int[] prices, int fee) {
           int n = prices.length;
           int[][] dp = new int[n + 1][2];
   
           // As dp array is intialized to 0, we have already covered the base case
      
           for(int i = n - 1; i >= 0; i--){
               for(int buy = 0; buy <= 1; buy++){
                   if(buy == 0) {
                       dp[i][0] = Math.max(-prices[i] - fee + dp[i + 1][1], dp[i + 1][0]); 
                   }
                   else {
                       dp[i][1] = Math.max(prices[i] + dp[i + 1][0], dp[i + 1][1]); 
                   }
               }
           }
           
           return dp[0][0];
       }

       // we can also remove inner buy loop as it is running two times only

       public int maxProfit(int[] prices, int fee) {
           int n = prices.length;
           int[][] dp = new int[n + 1][2];
   
           // As dp array is intialized to 0, we have already covered the base case
      
           for(int i = n - 1; i >= 0; i--){
               // buy
               dp[i][0] = Math.max(-prices[i] - fee + dp[i + 1][1], dp[i + 1][0]); 
   
               // sell
               dp[i][1] = Math.max(prices[i] + dp[i + 1][0], dp[i + 1][1]); 
           }
           
           return dp[0][0];
       }
       
    */

    /*
       // Space Optimization  
       public static int maxProfit(int[] prices, int fee) {
           int n = prices.length;
           int[] ahead = new int[2];
           int[] curr = new int[2];
   
           // As dp array is intialized to 0, we have already covered the base case
      
           for(int i = n - 1; i >= 0; i--){
               // buy
               curr[0] = Math.max(-prices[i] - fee + ahead[1], ahead[0]); 
   
               // sell
               curr[1] = Math.max(prices[i] + ahead[0], ahead[1]); 
   
               ahead = curr.clone();
           }
           
           return ahead[0];
       }
    */

    // using 4 variables
    
    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int aheadBuy, aheadNotBuy, currBuy, currNotBuy;
        
        aheadNotBuy = aheadBuy = 0;

        for(int i = n - 1; i >= 0; i--){
            currNotBuy = Math.max(-prices[i] - fee + aheadBuy, aheadNotBuy);
            currBuy = Math.max(prices[i] + aheadNotBuy, aheadBuy);
            aheadNotBuy = currNotBuy;
            aheadBuy = currBuy;
        }

        return aheadNotBuy;
    }

    
    public static void main(String[] args) {
        int[] prices = {1,3,2,8,4,9};
        int fee = 2;
        System.out.println(maxProfit(prices, fee));
    }
}
