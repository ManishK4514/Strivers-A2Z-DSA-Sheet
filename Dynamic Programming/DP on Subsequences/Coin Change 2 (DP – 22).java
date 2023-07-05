/*
    Q. Coin Change 2 (DP – 22)

    Practice : https://leetcode.com/problems/coin-change-ii/description/

    You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

    Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
    
    You may assume that you have an infinite number of each kind of coin.
    
    The answer is guaranteed to fit into a signed 32-bit integer.
    
    Example 1:
    
    Input: amount = 5, coins = [1,2,5]
    Output: 4
    Explanation: there are four ways to make up the amount:
    5=5
    5=2+2+1
    5=2+1+1+1
    5=1+1+1+1+1
    Example 2:
    
    Input: amount = 3, coins = [2]
    Output: 0
    Explanation: the amount of 3 cannot be made up just with coins of 2.
    Example 3:
    
    Input: amount = 10, coins = [10]
    Output: 1
*/

// import java.util.Arrays;

public class Coin_Change_2 {
    /*
       // Recursion
       public static int helper(int[] coins, int i, int amt){
           if(i == 0) {
               if(amt % coins[0] == 0) return 1;
               return 0;
           }
           
           // take
           int take = 0;
           if(amt >= coins[i]) take = helper(coins, i, amt - coins[i]); 
           
           // not take
           int notTake = helper(coins, i - 1, amt);
           
           return take + notTake;
       }
   
       public static int change(int amount, int[] coins) {
           int n = coins.length;
           return helper(coins, n - 1, amount);
       }
    */

    /*
       // Memoization
       public static int helper(int[] coins, int i, int amt, int[][] dp){
           if(i == 0) {
               if(amt % coins[0] == 0) return 1;
               return 0;
           }
   
           if(dp[i][amt] != -1) return dp[i][amt];
           
           // take
           int take = 0;
           if(amt >= coins[i]) take = helper(coins, i, amt - coins[i], dp); 
           
           // not take
           int notTake = helper(coins, i - 1, amt, dp);
           
           return dp[i][amt] = take + notTake;
       }
   
       public static int change(int amount, int[] coins) {
           int n = coins.length;
           int[][] dp = new int[n][amount + 1];
           for(int[] it : dp) Arrays.fill(it, -1);
           return helper(coins, n - 1, amount, dp);
       }
    */

    /*
       // Tabulation
       public static int change(int amount, int[] coins) {
           int n = coins.length;
           int[][] dp = new int[n][amount + 1];
   
           for(int amt = 0; amt <= amount; amt++){
               if(amt % coins[0] == 0) dp[0][amt] = 1;
           }
   
           for(int i = 1; i < n; i++){
               for(int amt = 0; amt <= amount; amt++){
                   // take
                   int take = 0;
                   if(amt >= coins[i]) take = dp[i][amt - coins[i]]; 
                   
                   // not take
                   int notTake = dp[i - 1][amt];
                   
                   dp[i][amt] = take + notTake;
               }
           }
   
           return dp[n - 1][amount];
       }
    */

    // Space Optimization

    public static int change(int amount, int[] coins) {
        int n = coins.length;
        int[] prev = new int[amount + 1];
        int[] curr = new int[amount + 1];

        for(int amt = 0; amt <= amount; amt++){
            if(amt % coins[0] == 0) prev[amt] = 1;
        }

        for(int i = 1; i < n; i++){
            for(int amt = 0; amt <= amount; amt++){
                // take
                int take = 0;
                if(amt >= coins[i]) take = curr[amt - coins[i]]; 
                
                // not take
                int notTake = prev[amt];
                
                curr[amt] = take + notTake;
            }
            prev = curr.clone();
        }

        return prev[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 5;
        System.out.println(change(amount, coins));
    }
}
