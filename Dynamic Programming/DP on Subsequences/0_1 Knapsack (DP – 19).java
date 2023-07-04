/*
    Q. 0/1 Knapsack (DP – 19)
    Practice : https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1

    You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. Note that we have only one quantity of each item.
    In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item or dont pick it (0-1 property).
    
    Example 1:
    
    Input:
    N = 3
    W = 4
    values[] = {1,2,3}
    weight[] = {4,5,1}
    Output: 3
    Example 2:
    
    Input:
    N = 3
    W = 3
    values[] = {1,2,3}
    weight[] = {4,5,6}
    Output: 0
*/

// import java.util.Arrays;

public class _0_1_Knapsack {
    /*
       // Recursion
       public static int helper(int i, int[] val, int[] wt, int W){
           if(i == 0) {
               if(W >= wt[0]) return val[0];
               return 0; 
           }
           
           // take
           int take = Integer.MIN_VALUE;
           if(W >= wt[i]) take = val[i] + helper(i - 1, val, wt, W - wt[i]);
           
           // notTake
           int notTake = helper(i - 1, val, wt, W);
           
           return Math.max(take, notTake);
       }
   
       public static int knapSack(int W, int wt[], int val[], int n) { 
           return helper(n - 1, val, wt, W);
       } 
    */

    /*
       // Memoization
       public static int helper(int i, int[] val, int[] wt, int W, int[][] dp){
           if(i == 0) {
               if(W >= wt[0]) return val[0];
               return 0; 
           }
           
           if(dp[i][W] != -1) return dp[i][W];
           
           // take
           int take = Integer.MIN_VALUE;
           if(W >= wt[i]) take = val[i] + helper(i - 1, val, wt, W - wt[i], dp);
           
           // notTake
           int notTake = helper(i - 1, val, wt, W, dp);
           
           return dp[i][W] = Math.max(take, notTake);
       }
   
       public static int knapSack(int W, int wt[], int val[], int n) { 
           int[][] dp = new int[n][W + 1];
           for(int[] it : dp) Arrays.fill(it, -1);
           return helper(n - 1, val, wt, W, dp);
       } 
    */

    /*
       // Tabulation
       public static int knapSack(int W, int wt[], int val[], int n){ 
           int[][] dp = new int[n][W + 1];
           
           for(int i = wt[0]; i <= W; i++){
               dp[0][i] = val[0];
           }
       
           for(int i = 1; i < n; i++){
               for(int cap = 0; cap <= W; cap++){
                   // take
                   int take = Integer.MIN_VALUE;
                   if(cap >= wt[i]) take = val[i] + dp[i - 1][cap - wt[i]];
                   
                   // notTake
                   int notTake = dp[i - 1][cap];
                   
                   dp[i][cap] = Math.max(take, notTake);
               }
           }
           return dp[n - 1][W];
       } 
    */

    // Space Optimization

    public static int knapSack(int W, int wt[], int val[], int n){ 
        int[] prev = new int[W + 1];
        int[] curr = new int[W + 1];
        
        for(int i = wt[0]; i <= W; i++){
            prev[i] = val[0];
        }
    
        for(int i = 1; i < n; i++){
            for(int cap = 0; cap <= W; cap++){
                // take
                int take = Integer.MIN_VALUE;
                if(cap >= wt[i]) take = val[i] + prev[cap - wt[i]];
                
                // notTake
                int notTake = prev[cap];
                
                curr[cap] = Math.max(take, notTake);
            }
            prev = curr.clone();
        }
        return prev[W];
    }

    public static void main(String[] args) {
        int N = 3, W = 4;
        int[] values = {1,2,3};
        int[] weight = {4,5,1};

        System.out.println(knapSack(W, weight, values, N));
    }
}
