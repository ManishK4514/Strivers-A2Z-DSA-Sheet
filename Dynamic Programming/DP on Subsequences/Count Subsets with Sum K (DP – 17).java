/*
    Q. Count Subsets with Sum K (DP – 17)
    Practice : https://practice.geeksforgeeks.org/problems/perfect-sum-problem5633/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=perfect-sum-problem

    Given an array arr[] of non-negative integers and an integer sum, the task is to count all subsets of the given array with a sum equal to a given sum.

    Note: Answer can be very large, so, output answer modulo 109+7
    
    Example 1:
    
    Input: N = 6, arr[] = {2, 3, 5, 6, 8, 10}
           sum = 10
    Output: 3
    Explanation: {2, 3, 5}, {2, 8}, {10}
    Example 2:
    Input: N = 5, arr[] = {1, 2, 3, 4, 5}
           sum = 10
    Output: 3
    Explanation: {1, 2, 3, 4}, {1, 4, 5}, 
                 {2, 3, 5}
*/

// import java.util.Arrays;

public class Count_Subsets_with_Sum_K {
    /*
       // Recursion
       static int mod = (int)(1e9 + 7);
       public static int helper(int i, int[] arr, int target){
           if(i < 0) {
               if(target == 0) return 1;
               return 0;
           }
           
           // take 
           int take = 0;
           if(target >= arr[i]) take = helper(i - 1, arr, target - arr[i]);
           
           // notTake
           int notTake = helper(i - 1, arr, target);
           
           return ((take % mod) + (notTake % mod)) % mod;
       }
   
	   public static int perfectSum(int[] arr,int n, int sum) { 
	       return helper(n - 1, arr, sum) % mod;
	   } 
    */

    /*
       // Memoization
       static int mod = (int)(1e9 + 7);
        public static int helper(int i, int[] arr, int target, int[][] dp){
            if(i < 0) {
                if(target == 0) return 1;
                return 0;
            }
            
            if(dp[i][target] != -1) return dp[i][target];
            
            // take 
            int take = 0;
            if(target >= arr[i]) take = helper(i - 1, arr, target - arr[i], dp);
            
            // notTake
            int notTake = helper(i - 1, arr, target, dp);
            
            return dp[i][target] = ((take % mod) + (notTake % mod)) % mod;
        }
	    public static int perfectSum(int[] arr,int n, int sum) {
	        int[][] dp = new int[n][sum + 1];
	        for(int[] it : dp) Arrays.fill(it, -1);
	        return helper(n - 1, arr, sum, dp) % mod;
	    } 
    */

    /*
       // Tabulation
       public static void reverseArray(int[] arr, int start, int end) {
           while (start < end) {
               int temp = arr[start];
               arr[start] = arr[end];
               arr[end] = temp;
       
               start++;
               end--;
           }
       }
	   public static int perfectSum(int[] arr,int n, int target) {
           
           // for tabulation specific approach
           // for array: {0, 0, 0, 0, 0, 0, 0, 0, 1}
           // it will only count all subarrys because it's starting with 0
           // so we will reverse array if it is starting from 0
   
	       if(arr[0] == 0) reverseArray(arr, 0, arr.length - 1);
	       
	       int mod = (int)(1e9 + 7);
	       int[][] dp = new int[n][target + 1];
	       for(int i = 0; i < n; i++) dp[i][0] = 1;
	       
	       if(arr[0] <= target) dp[0][arr[0]] = 1;
	       
	       for(int i = 1; i < n; i++){
	           for(int sum = 0; sum <= target; sum++){
	               // take
	               int take = 0;
	               if(sum >= arr[i]) take = dp[i - 1][sum - arr[i]];
           
                   // notTake
                   int notTake = dp[i - 1][sum];
                   
                   dp[i][sum] = ((take % mod) + (notTake % mod)) % mod;
	           }
	       }
	       
	       return dp[n - 1][target] % mod;
	   } 
    */
    
    // Space Optimization
    public static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
    
            start++;
            end--;
        }
    }
	public static int perfectSum(int[] arr,int n, int target) {

        // for tabulation specific approach
        // for array: {0, 0, 0, 0, 0, 0, 0, 0, 1}
        // it will only count all subarrys because it's starting with 0
        // so we will reverse array if it is starting from 0

	    if(arr[0] == 0) reverseArray(arr, 0, arr.length - 1);
	    
	    int mod = (int)(1e9 + 7);
	    
	    int[] prev = new int [target + 1];
	    int[] curr = new int[target + 1];
	    
	    prev[0] = curr[0] = 1;
	    
	    if(arr[0] <= target) prev[arr[0]] = 1;
	    
	    for(int i = 1; i < n; i++){
	        for(int sum = 0; sum <= target; sum++){
	            // take
	            int take = 0;
	            if(sum >= arr[i]) take = prev[sum - arr[i]];
        
                // notTake
                int notTake = prev[sum];
                
                curr[sum] = ((take % mod) + (notTake % mod)) % mod;
	        }
	        prev = curr.clone();
	    }
	    
	    return prev[target] % mod;
	} 

    public static void main(String[] args) {
        int N = 9, sum = 1;
        int[] arr = {0, 0, 0, 0, 0, 0, 0, 0, 1};
        System.out.println(perfectSum(arr, N, sum));
    }
}
