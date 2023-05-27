/*
    Q. Partition Equal Subset Sum (DP- 15)
    Practice : https://leetcode.com/problems/partition-equal-subset-sum/description/

    Given an integer numsay nums, return true if you can partition the numsay into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

    Example 1:
    
    Input: nums = [1,5,11,5]
    Output: true
    Explanation: The numsay can be partitioned as [1, 5, 5] and [11].
    Example 2:
    
    Input: nums = [1,2,3,5]
    Output: false
    Explanation: The numsay cannot be partitioned into equal sum subsets.
*/

public class Partition_Equal_Subset_Sum {
    /*
       // Recursion
       public static boolean possible(int idx, int[] nums, int target){
           if(idx < 0){
               if(target == 0) return true;
               return false;
           }
   
           // take
           boolean take = possible(idx - 1, nums, target - nums[idx]);
   
           // not take 
           boolean notTake = possible(idx - 1, nums, target);
   
           return take || notTake;
       }
       public static boolean canPartition(int[] nums) {
           int totalSum = 0, n = nums.length;
           for(int i = 0; i < n; i++) totalSum += nums[i];
           if(totalSum % 2 != 0) return false;
           return possible(n - 1, nums, totalSum/2);
       }
    */

    /*
       // Memoization
       public static boolean possible(int idx, int[] nums, int target, Boolean[][] dp){
           if(target == 0) return true;
           if(idx < 0 || target < 0) return false;
   
           if(dp[idx][target] != null) return dp[idx][target];
   
           // take
           boolean take = possible(idx - 1, nums, target - nums[idx], dp);
   
           // not take 
           boolean notTake = possible(idx - 1, nums, target, dp);
   
           return dp[idx][target] = take || notTake;
       }
       public static boolean canPartition(int[] nums) {
           int totalSum = 0, n = nums.length;
           for(int i = 0; i < n; i++) totalSum += nums[i];
           if(totalSum % 2 != 0) return false;
           Boolean[][] dp = new Boolean[n + 1][(totalSum/2) + 1];
           return possible(n - 1, nums, totalSum/2, dp);
       }
    */

    /*
       // Tabulation
       public static boolean canPartition(int[] nums) {
          int toalSum = 0, n = nums.length;
          for(int i = 0; i < n; i++) totalSum += nums[i];
          if(totalSum % 2 != 0) return false;
          boolean[][] dp = new boolean[n][totalSum + 1];
          for(int i = 0; i < n; i++){
              dp[i][0] = true;
          }
          if(nums[0]<= sum){
              dp[0][nums[0]] = true;
          }
          
          for(int idx = 1; idx < n; idx++){
              for(int target = 1; target <= totalSum/2; target++){
                  // take
                  boolean take = false;
                  if(nums[idx] <= target) take = dp[idx - 1][target - nums[idx]];
                      
                  // not-take
                  boolean notTake = dp[idx - 1][target];
                  
                  dp[idx][target] = take || notTake;
              }
          }
          return dp[n - 1][totalSum/2];
       }
    */
    
    // Space Optimization
    public static boolean canPartition(int[] nums) {
        int totalSum = 0, n = nums.length;
        for(int i = 0; i < n; i++) totalSum += nums[i];
        if(totalSum % 2 != 0) return false;
        boolean[] prev = new boolean[totalSum + 1];
        boolean[] curr = new boolean[totalSum + 1];
        
        prev[0] = curr[0] = true;
        
        if(nums[0]<= totalSum){
            prev[nums[0]] = true;
        }
        
        for(int idx = 1; idx < n; idx++){
            for(int target = 1; target <= totalSum/2; target++){
                // take
                boolean take = false;
                if(nums[idx] <= target) take = prev[target - nums[idx]];
                    
                // not-take
                boolean notTake = prev[target];
                
                curr[target] = take || notTake;
            }
            prev = curr.clone();
        }
        return prev[totalSum/2];
    }
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println(canPartition(nums));
    }
}
