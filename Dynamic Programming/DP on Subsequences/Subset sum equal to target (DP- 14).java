/*
    Q. Subset sum equal to target (DP- 14)
    Practice : https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=subset-sum-problem-1611555638

    Given an array of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum. 

    Example 1:
    
    Input:
    N = 6
    arr[] = {3, 34, 4, 12, 5, 2}
    sum = 9
    Output: 1 
    Explanation: Here there exists a subset with
    sum = 9, 4+3+2 = 9.
    Example 2:
    
    Input:
    N = 6
    arr[] = {3, 34, 4, 12, 5, 2}
    sum = 30
    Output: 0 
    Explanation: There is no subset with sum 30.
*/

public class Subset_sum_equal_to_target {
    /*
       // Recursion
       public static boolean helper(int idx, int[] arr, int target){
           if(target == 0) return true;
           if(idx == 0) return arr[0] == target;
           
           // take
           boolean take = false;
           if(arr[idx] <= target) take = helper(idx - 1, arr, target - arr[idx]);
           
           // not-take
           boolean notTake = helper(idx - 1, arr, target);
           
           return take || notTake;
       }
       public static Boolean isSubsetSum(int N, int arr[], int sum){
          return helper(N - 1, arr, sum);
       } 
    */

    /*
       // Memoization
       public static boolean helper(int idx, int[] arr, int target, Boolean[][] dp){
           if(target == 0) return true;
           if(idx == 0) return arr[0] == target;
           
           if(dp[idx][target] != null) return dp[idx][target];
           
           // take
           boolean take = false;
           if(arr[idx] <= target) take = helper(idx - 1, arr, target - arr[idx], dp);
           
           // not-take
           boolean notTake = helper(idx - 1, arr, target, dp);
           
           return dp[idx][target] = take || notTake;
       }
       public static Boolean isSubsetSum(int N, int arr[], int sum){
          Boolean[][] dp = new Boolean[N][sum + 1];
          return helper(N - 1, arr, sum, dp);
       } 
    */

    /*
       // Tabulation
       public static Boolean isSubsetSum(int n, int arr[], int sum){
           boolean[][] dp = new boolean[n][sum + 1];
           for(int i = 0; i < n; i++){
               dp[i][0] = true;
           }
           if(arr[0]<= sum){
               dp[0][arr[0]] = true;
           }
           
           for(int idx = 1; idx < n; idx++){
               for(int target = 1; target <= sum; target++){
                   // take
                   boolean take = false;
                   if(arr[idx] <= target) take = dp[idx - 1][target - arr[idx]];
                       
                   // not-take
                   boolean notTake = dp[idx - 1][target];
                   
                   dp[idx][target] = take || notTake;
               }
           }
           return dp[n - 1][sum];
       }
    */
    
    // Space Optimization
    public static Boolean isSubsetSum(int n, int arr[], int sum){
        boolean[] prev = new boolean[sum + 1];
        boolean[] curr = new boolean[sum + 1];
        
        prev[0] = curr[0] = true;
        
        if(arr[0]<= sum){
            prev[arr[0]] = true;
        }
        
        for(int idx = 1; idx < n; idx++){
            for(int target = 1; target <= sum; target++){
                // take
                boolean take = false;
                if(arr[idx] <= target) take = prev[target - arr[idx]];
                    
                // not-take
                boolean notTake = prev[target];
                
                curr[target] = take || notTake;
            }
            prev = curr.clone();
        }
        return prev[sum];
    }
    public static void main(String[] args) {
        int N = 6, sum = 9;
        int[] arr = {3, 34, 4, 12, 5, 2};
        System.out.println(isSubsetSum(N, arr, sum));
    }
}
