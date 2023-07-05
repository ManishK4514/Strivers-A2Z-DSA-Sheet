/*
    Q. Minimum Coins (DP – 20)

    Practice : https://leetcode.com/problems/coin-change/description/

    You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

    Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
    
    You may assume that you have an infinite number of each kind of coin.
     
    Example 1:
    
    Input: coins = [1,2,5], amount = 11
    Output: 3
    Explanation: 11 = 5 + 5 + 1
    Example 2:
    
    Input: coins = [2], amount = 3
    Output: -1
    Example 3:
    
    Input: coins = [1], amount = 0
    Output: 0
*/

// import java.util.Arrays;

public class Minimum_Coins {
    /*
       // Recursion
       public static int helper(int[] coins, int amount, int idx){
           if(idx == 0) {
               if(amount % coins[0] == 0) return amount/coins[0];
               return (int)(1e9);
           }
           
           // take
           int take = (int)(1e9);
           if(amount >= coins[idx])take = 1 + helper(coins, amount - coins[idx], idx); 
           
           // not take
           int notTake = helper(coins, amount, idx - 1);
           
           return Math.min(take, notTake);
       }
   
       public static int coinChange(int[] coins, int amount) {
           int ans = helper(coins, amount, coins.length - 1);
           return ans == 1e9 ? -1 : ans;
       }
    */

    /*
       // Memoization
       public static int helper(int[] coins, int amount, int idx, int[][] dp){
           if(idx == 0) {
               if(amount % coins[0] == 0) return amount/coins[0];
               return (int)(1e9);
           }
   
           if(dp[idx][amount] != -1) return dp[idx][amount];
           
           // take
           int take = (int)(1e9);
           if(amount >= coins[idx])take = 1 + helper(coins, amount - coins[idx], idx, dp); 
           
           // not take
           int notTake = helper(coins, amount, idx - 1, dp);
           
           return dp[idx][amount] = Math.min(take, notTake);
       }
   
       public static int coinChange(int[] coins, int amount) {
           int[][] dp = new int[coins.length][amount + 1];
           for(int[] it : dp) Arrays.fill(it, -1);
           int ans = helper(coins, amount, coins.length - 1, dp);
           return ans == 1e9 ? -1 : ans;
       }
    */

    /*
       // Tabulation
       public static int coinChange(int[] coins, int amount) {
           int n = coins.length;
           int[][] dp = new int[n][amount + 1];
   
           for(int amt = 0; amt <= amount; amt++){
               if(amt % coins[0] == 0) dp[0][amt] = amt/coins[0];
               else dp[0][amt] = (int)(1e9);
           }
   
           for(int i = 1; i < n; i++){
               for(int amt = 0; amt <= amount; amt++){
                   // take
                   int take = (int)(1e9);
                   if(amt >= coins[i]) take = 1 + dp[i][amt - coins[i]];         
                   
                   // not take
                   int notTake = dp[i - 1][amt];
                   
                   dp[i][amt] = Math.min(take, notTake);
               }
           }
   
           return dp[n - 1][amount] >= 1e9 ? -1 : dp[n - 1][amount];
       }
    */

    // Space Optimization

    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] prev = new int[amount + 1];
        int[] curr = new int[amount + 1];

        for(int amt = 0; amt <= amount; amt++){
            if(amt % coins[0] == 0) prev[amt] = amt/coins[0];
            else prev[amt] = (int)(1e9);
        }

        for(int i = 1; i < n; i++){
            for(int amt = 0; amt <= amount; amt++){
                // take
                int take = (int)(1e9);
                if(amt >= coins[i]) take = 1 + curr[amt - coins[i]];         
                
                // not take
                int notTake = prev[amt];
                
                curr[amt] = Math.min(take, notTake);
            }
            prev = curr.clone();
        }

        return prev[amount] >= 1e9 ? -1 : prev[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }
}
