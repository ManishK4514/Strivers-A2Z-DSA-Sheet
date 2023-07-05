/*
    Q. Unbounded Knapsack (DP-23)

    Practice : https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=knapsack-with-duplicate-items

    Given a set of N items, each with a weight and a value, represented by the array w[] and val[] respectively. Also, a knapsack with weight limit W.
    The task is to fill the knapsack in such a way that we can get the maximum profit. Return the maximum profit.
    Note: Each item can be taken any number of times.

    Example 1:
    
    Input: N = 2, W = 3
    val[] = {1, 1}
    wt[] = {2, 1}
    Output: 3
    Explanation: 
    1.Pick the 2nd element thrice.
    2.Total profit = 1 + 1 + 1 = 3. Also the total 
      weight = 1 + 1 + 1  = 3 which is <= W.
    
    Example 2:
    
    Input: N = 4, W = 8
    val[] = {1, 4, 5, 7}
    wt[] = {1, 3, 4, 5}
    Output: 11
    Explanation: The optimal choice is to 
    pick the 2nd and 4th element.
*/

// import java.util.Arrays;

public class Unbounded_Knapsack {
    /*
       // Recursion
       public static int helper(int i, int[] val, int[] wt, int W){
           // base case
           if(i == 0) return (W/(wt[0])) * val[0];
   
           // take
           int take = Integer.MIN_VALUE;
           if(wt[i] <= W) take = val[i] + helper(i, val, wt, W - wt[i]);
           
           // not take
           int notTake = helper(i - 1, val, wt, W);
           
           return Math.max(take, notTake);
       }
       
       public static int knapSack(int N, int W, int val[], int wt[]) {
           int ans = helper(N - 1, val, wt, W);
           return ans == Integer.MIN_VALUE ? 0 : ans;
       }
    */

    /*
       // Memoization
       public static int helper(int i, int[] val, int[] wt, int W, int[][] dp){
           // base case
           if(i == 0) return (W/(wt[0])) * val[0];
           
           if(dp[i][W] != -1) return dp[i][W];
           
           // take
           int take = Integer.MIN_VALUE;
           if(wt[i] <= W) take = val[i] + helper(i, val, wt, W - wt[i], dp);
           
           // not take
           int notTake = helper(i - 1, val, wt, W, dp);
           
           return dp[i][W] = Math.max(take, notTake);
       }
       
       public static int knapSack(int N, int W, int val[], int wt[]) {
           int[][] dp = new int[N][W + 1];
           for(int[] it : dp) Arrays.fill(it, -1);
           int ans = helper(N - 1, val, wt, W, dp);
           return ans == Integer.MIN_VALUE ? 0 : ans;
       }
    */

    /*
       // Tabulation
       public static int knapSack(int N, int W, int val[], int wt[]) {
           int[][] dp = new int[N][W + 1];
           
           for(int i = wt[0]; i <= W; i++){
               dp[0][i] = ((int) i/wt[0]) * val[0];
           }
           
           for(int i = 1; i < N; i++){
               for(int cap = 0; cap <= W; cap++){
                   // take
                   int take = Integer.MIN_VALUE;
                   if(wt[i] <= cap) take = val[i] + dp[i][cap - wt[i]];
                   
                   // not take
                   int notTake = dp[i - 1][cap];
                   
                   dp[i][cap] = Math.max(take, notTake);
               }
           }
           return dp[N - 1][W];
       }
    */

    // Space Optimization

    public static int knapSack(int N, int W, int val[], int wt[]) {
        int[] prev = new int[W + 1];
        int[] curr = new int[W + 1];
        
        for(int i = wt[0]; i <= W; i++){
            prev[i] = ((int) i/wt[0]) * val[0];
        }
        
        for(int i = 1; i < N; i++){
            for(int cap = 0; cap <= W; cap++){
                // take
                int take = Integer.MIN_VALUE;
                if(wt[i] <= cap) take = val[i] + curr[cap - wt[i]];
                
                // not take
                int notTake = prev[cap];
                
                curr[cap] = Math.max(take, notTake);
            }
            prev = curr.clone();
        }
        return prev[W];
    }

    public static void main(String[] args) {
        int N = 2, W = 3;
        int[] val = {1, 1};
        int[] wt = {2, 1};

        System.out.println(knapSack(N, W, val, wt));
    }
}
