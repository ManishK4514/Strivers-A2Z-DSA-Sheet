/*
    Q. Longest Increasing Subsequence | (DP-41)

    Practice: https://leetcode.com/problems/longest-increasing-subsequence/description/

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

public class Longest_Increasing_Subsequence {
    /*
       // Recursion
       public static int helper(int[] nums, int i, int prevIdx){
           if(i == nums.length) return 0;
           
           int take = 0;
           if(prevIdx == -1 || nums[i] > nums[prevIdx]){
               take = 1 + helper(nums, i + 1, i);
           }
           int notTake = helper(nums, i + 1, prevIdx);
           
           return Math.max(take, notTake);
       }
      
       public static int lengthOfLIS(int[] nums) {
           return helper(nums, 0, -1);
       }
    */
   
    /*
       // Memoization
       public static int helper(int[] nums, int i, int prevIdx, int[][] dp){
           if(i == nums.length) return 0;
   
           if(dp[i][prevIdx + 1] != -1) return dp[i][prevIdx + 1];
           
           int take = 0;
           if(prevIdx == -1 || nums[i] > nums[prevIdx]){
               take = 1 + helper(nums, i + 1, i, dp);
           }
           int notTake = helper(nums, i + 1, prevIdx, dp);
           
           return dp[i][prevIdx + 1] = Math.max(take, notTake);
       }
   
       public static int lengthOfLIS(int[] nums) {
           int n = nums.length;
           int[][] dp = new int[n][n + 1];
           for(int[] it : dp) Arrays.fill(it, -1);
           return helper(nums, 0, -1, dp);
       }
    */
   
    /*
       // Tabulation
       public static int lengthOfLIS(int[] nums) {
           int n = nums.length;
           int[][] dp = new int[n + 1][n + 1];
   
           // second index shifted by 1
   
           for(int i = n - 1; i >= 0; i--){
               for(int prevIdx = i - 1; prevIdx >= -1; prevIdx--){
                   int take = 0;
                   if(prevIdx == -1 || nums[i] > nums[prevIdx]){
                       take = 1 + dp[i + 1][i + 1];
                   }
                   int notTake = dp[i + 1][prevIdx + 1];
                   
                   dp[i][prevIdx + 1] = Math.max(take, notTake);
               }            
           }
   
           return dp[0][-1 + 1];
       }
    */
    
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] ahead = new int[n + 1];
        int[] curr = new int[n + 1];

        for(int i = n - 1; i >= 0; i--){
            for(int prevIdx = i - 1; prevIdx >= -1; prevIdx--){
                int take = 0;
                if(prevIdx == -1 || nums[i] > nums[prevIdx]){
                    take = 1 + ahead[i + 1];
                }
                int notTake = ahead[prevIdx + 1];
                
                curr[prevIdx + 1] = Math.max(take, notTake);
            }  
            ahead = curr.clone();          
        }

        return ahead[-1 + 1];
    }    

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
}
