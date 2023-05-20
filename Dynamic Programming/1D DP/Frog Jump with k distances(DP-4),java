/*
    Q. Dynamic Programming: Frog Jump with k Distances (DP 4)
    Practice : https://practice.geeksforgeeks.org/problems/minimal-cost/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimal-cost
    There are n stones and an array of heights and Geek is standing at stone 1 and can jump to one of the following: Stone i+1, i+2, ... i+k stone and cost will be [hi-hj] is incurred, where j is the stone to land on. Find the minimum possible total cost incurred before the Geek reaches Stone N.

    Example 1:
    Input:
    n = 5, k = 3
    heights = {10, 30, 40, 50, 20}
    Output:
    30
    Explanation:
    Geek will follow the path 1->2->5, the total cost 
    would be | 10-30| + |30-20| = 30, which is minimum
    Example 2:
    
    Input:
    n = 3, k = 1
    heights = {10,20,10}
    Output:
    20
    Explanation:
    Geek will follow the path 1->2->3, the total cost
    would be |10 - 20| + |20 - 10| = 20.
*/

// import java.util.Arrays;

public class Frog_Jump_with_k_distances {
    /*
       // Recursion
       public static int helper(int[] arr, int idx, int k){
           if(idx == 0) return 0;
           int minCost = Integer.MAX_VALUE;
           for(int i = 1; i <= k; i++){
               int currCost = (idx > i - 1) ? Math.abs(arr[idx] - arr[idx - i]) + helper(arr, idx - i, k) : Integer.MAX_VALUE;
               minCost = Math.min(currCost, minCost);
           }
           return minCost;
       }
       public static int minimizeCost(int arr[],int N,int K){
           return helper(arr, N - 1, K);
       }
    */

    /*
       // Memoization
       public static int helper(int[] arr, int idx, int k, int[] dp){
           if(idx == 0) return 0;
           if(dp[idx] != -1) return dp[idx];
           
           int minCost = Integer.MAX_VALUE;
           for(int i = 1; i <= k; i++){
               int currCost = (idx > i - 1) ? Math.abs(arr[idx] - arr[idx - i]) + helper(arr, idx - i, k, dp) : Integer.MAX_VALUE;
               minCost = Math.min(currCost, minCost);
           }
           return dp[idx] = minCost;
       }
       public static int minimizeCost(int arr[],int N,int K){
           int[] dp = new int[N + 1];
           Arrays.fill(dp, -1);
           return helper(arr, N - 1, K, dp);
       }
    */

    // Tabulation

    public static int minimizeCost(int arr[],int N,int K){
        int[] dp = new int[N + 1];
        for(int i = 1; i < N; i++){
            int minCost = Integer.MAX_VALUE;
            for(int j = 1; j <= K; j++){
                int currCost = (i > j - 1) ? Math.abs(arr[i] - arr[i - j]) + dp[i - j] : Integer.MAX_VALUE;
                 minCost = Math.min(currCost, minCost);
            }
            dp[i] = minCost;
        }
        return dp[N - 1];
    }

    public static void main(String[] args) {
        int n = 5, k = 3;
        int[] heights = {10, 30, 40, 50, 20};
        System.out.println(minimizeCost(heights, n, k));
    }
}
