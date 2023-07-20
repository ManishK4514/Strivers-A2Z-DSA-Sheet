/*
    Q. Partition Array for Maximum Sum | Front Partition : DP 54

    Practice : https://leetcode.com/problems/partition-array-for-maximum-sum/description/

    Given an integer array arr, partition the array into (contiguous) subarrays of length at most k. After partitioning, each subarray has their values changed to become the maximum value of that subarray.

    Return the largest sum of the given array after partitioning. Test cases are generated so that the answer fits in a 32-bit integer.
    
    Example 1:
    
    Input: arr = [1,15,7,9,2,5,10], k = 3
    Output: 84
    Explanation: arr becomes [15,15,15,9,10,10,10]
    Example 2:
    
    Input: arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
    Output: 83
    Example 3:
    
    Input: arr = [1], k = 1
    Output: 1
*/

// import java.util.Arrays;

public class Partition_Array_for_Maximum_Sum {
    /*
       // Recursion

        public static int helper(int i, int k, int[] arr){
            if(i == arr.length) return 0;
            
            int maxValue = 0, ans = 0;
            for(int j = i; j < Math.min(i + k, arr.length); j++){
                maxValue = Math.max(maxValue, arr[j]);
                int currVal = (maxValue * (j - i + 1)) + helper(j + 1, k, arr);
                ans = Math.max(ans, currVal); 
            }
    
            return ans;
        }
        
        public static int maxSumAfterPartitioning(int[] arr, int k) {
            return helper(0, k, arr);
        }
    */

    /*
       // Memoization

        public static int helper(int i, int k, int[] arr, int[] dp){
            if(i == arr.length) return 0;
    
            if(dp[i] != -1) return dp[i];
            
            int maxValue = 0, ans = 0;
            for(int j = i; j < Math.min(i + k, arr.length); j++){
                maxValue = Math.max(maxValue, arr[j]);
                int currVal = (maxValue * (j - i + 1)) + helper(j + 1, k, arr, dp);
                ans = Math.max(ans, currVal); 
            }
    
            return dp[i] = ans;
        }
    
        public static int maxSumAfterPartitioning(int[] arr, int k) {
            int[] dp = new int[arr.length];
            Arrays.fill(dp, -1);
            return helper(0, k, arr, dp);
        }
    */

    // Tabulation
    
    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        
        for(int i = n - 1; i >= 0; i--){
            int maxValue = 0, ans = 0;
            for(int j = i; j < Math.min(i + k, arr.length); j++){
                maxValue = Math.max(maxValue, arr[j]);
                int currVal = (maxValue * (j - i + 1)) + dp[j + 1];
                ans = Math.max(ans, currVal); 
            }
    
            dp[i] = ans;
        }

        return dp[0];
    }

    public static void main(String[] args) {
        int[] arr = {1,15,7,9,2,5,10};
        int k = 3;
        
        System.out.println(maxSumAfterPartitioning(arr, k));
    }
}
