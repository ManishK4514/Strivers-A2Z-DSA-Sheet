/*
    Q. Rod Cutting Problem | (DP – 24)

    Practice : https://practice.geeksforgeeks.org/problems/rod-cutting0840/1

    Given a rod of length N inches and an array of prices, price[]. price[i] denotes the value of a piece of length i. Determine the maximum value obtainable by cutting up the rod and selling the pieces.

    Note: Consider 1-based indexing.
    
    Example 1:
    
    Input:
    N = 8
    Price[] = {1, 5, 8, 9, 10, 17, 17, 20}
    Output:
    22
    Explanation:
    The maximum obtainable value is 22 by 
    cutting in two pieces of lengths 2 and 
    6, i.e., 5+17=22.
    Example 2:
    
    Input:
    N=8
    Price[] = {3, 5, 8, 9, 10, 17, 17, 20}
    Output: 
    24
    Explanation: 
    The maximum obtainable value is 
    24 by cutting the rod into 8 pieces 
    of length 3, i.e, 8*3=24.
*/

// import java.util.Arrays;

public class Rod_Cutting_Problem {
    /*
       // Recursion
       public static int helper(int[] price, int i, int n){
           // base case
           if(i == 0) return n * price[0];
           
           // take
           int take = Integer.MIN_VALUE;
           if(i + 1 <= n) take = price[i] + helper(price, i, n - (i + 1));
           
           // not take
           int notTake = helper(price, i - 1, n);
           
           return Math.max(take, notTake);
       }
       
       public static int cutRod(int price[], int n) {
           return helper(price, n - 1, n);
       } 
    */

    /*
       // Memoization
       public static int helper(int[] price, int i, int n, int[][] dp){
           // base case
           if(i == 0) return n * price[0];
           
           if(dp[i][n] != -1) return dp[i][n];
           
           // take
           int take = Integer.MIN_VALUE;
           if(i + 1 <= n) take = price[i] + helper(price, i, n - (i + 1), dp);
           
           // not take
           int notTake = helper(price, i - 1, n, dp);
           
           return dp[i][n] = Math.max(take, notTake);
       }
       
       public static int cutRod(int price[], int n) {
           int[][] dp = new int[n][n + 1];
           for(int[] it : dp) Arrays.fill(it, -1);
           return helper(price, n - 1, n, dp);
       } 
    */

    /*
       // Tabulation
       public static int cutRod(int price[], int n) {
           int[][] dp = new int[n][n + 1];
           
           for(int i = 0; i <= n; i++){
               dp[0][i] = i * price[0];
           }
           
           for(int i = 1; i < n; i++){
               for(int length = 0; length <= n; length++){
                   // take
                   int take = Integer.MIN_VALUE;
                   if(i + 1 <= length) take = price[i] + dp[i][length - (i + 1)];
                   
                   // not take
                   int notTake = dp[i - 1][length];
                   
                   dp[i][length] = Math.max(take, notTake);
               }
           }
           
           return dp[n - 1][n];
       } 
    */
    
    /*
       // Space Optimization (using 2 Array)

       public static int cutRod(int price[], int n) {
           int[] prev = new int[n + 1];
           int[] curr = new int[n + 1];
           
           for(int i = 0; i <= n; i++){
               prev[i] = i * price[0];
           }
           
           for(int i = 1; i < n; i++){
               for(int length = 0; length <= n; length++){
                   // take
                   int take = Integer.MIN_VALUE;
                   if(i + 1 <= length) take = price[i] + curr[length - (i + 1)];
                   
                   // not take
                   int notTake = prev[length];
                   
                   curr[length] = Math.max(take, notTake);
               }
               prev = curr.clone();
           }
           
           return prev[n];
       } 
    */

    // Space Optimization (using 1 Array)    
    
    public static int cutRod(int price[], int n) {
        int[] curr = new int[n + 1];
        
        for(int i = 0; i <= n; i++){
            curr[i] = i * price[0];
        }
        
        for(int i = 1; i < n; i++){
            for(int length = 0; length <= n; length++){
                // take
                int take = Integer.MIN_VALUE;
                if(i + 1 <= length) take = price[i] + curr[length - (i + 1)];
                
                // not take
                int notTake = curr[length];
                
                curr[length] = Math.max(take, notTake);
            }
        }
        
        return curr[n];
    } 

    public static void main(String[] args) {
        int N = 8;
        int[] Price = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(cutRod(Price, N));
    }
}
