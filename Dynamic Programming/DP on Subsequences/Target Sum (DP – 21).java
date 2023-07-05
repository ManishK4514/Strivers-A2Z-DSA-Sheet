/*
    Q. Target Sum (DP – 21)

    Practice : https://leetcode.com/problems/target-sum/description/

    You are given an integer array nums and an integer target.

    You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
    
    For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
    Return the number of different expressions that you can build, which evaluates to target.
    
     
    
    Example 1:
    
    Input: nums = [1,1,1,1,1], target = 3
    Output: 5
    Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
    -1 + 1 + 1 + 1 + 1 = 3
    +1 - 1 + 1 + 1 + 1 = 3
    +1 + 1 - 1 + 1 + 1 = 3
    +1 + 1 + 1 - 1 + 1 = 3
    +1 + 1 + 1 + 1 - 1 = 3
    Example 2:
    
    Input: nums = [1], target = 1
    Output: 1
*/

// import java.util.Arrays;

public class Target_Sum {
    /*
       // Recursion
       public static int helper(int i, int targetSum, int[] nums){
           // base case
           if(i == 0){
               if(targetSum == 0 && nums[0] == 0) return 2;
               if(targetSum == nums[i] || targetSum == 0) return 1;
               return 0;
           }
           
           // take
           int take = 0;
           if(targetSum >= nums[i]) take = helper(i - 1, targetSum - nums[i], nums);
           
           // not take
           int notTake = helper(i - 1, targetSum, nums);
           
           return (take + notTake);
       }
   
       public static int findTargetSumWays(int[] nums, int target) {
           int totalSum = 0, n = nums.length;
           for(int i = 0; i < n; i++) totalSum += nums[i];
           
           if(totalSum - target < 0 || ((totalSum - target) % 2) != 0) return 0;
   
           int targetSum = (totalSum - target)/2;
   
           return helper(n - 1, targetSum, nums);
       }
    */

    /*
       // Memoization
       public static int helper(int i, int targetSum, int[] nums, int[][] dp){
           // base case
           if(i == 0){
               if(targetSum == 0 && nums[0] == 0) return 2;
               if(targetSum == nums[i] || targetSum == 0) return 1;
               return 0;
           }
           
           if(dp[i][targetSum] != -1) return dp[i][targetSum];
           
           // take
           int take = 0;
           if(targetSum >= nums[i]) take = helper(i - 1, targetSum - nums[i], nums, dp);
           
           // not take
           int notTake = helper(i - 1, targetSum, nums, dp);
           
           return dp[i][targetSum] =  (take + notTake);
       }
   
       public static int findTargetSumWays(int[] nums, int target) {
           int totalSum = 0, n = nums.length;
           for(int i = 0; i < n; i++) totalSum += nums[i];
           
           if(totalSum - target < 0 || ((totalSum - target) % 2) != 0) return 0;
   
           int targetSum = (totalSum - target)/2;
           
           int[][] dp = new int[n + 1][targetSum + 1];
           for(int[] it : dp) Arrays.fill(it, -1);
           return helper(n - 1, targetSum, nums, dp);
       }
    */

    /*
       // Tabulation
       public static int findTargetSumWays(int[] nums, int target) {
           int totalSum = 0, n = nums.length;
           for(int i = 0; i < n; i++) totalSum += nums[i];
           
           if(totalSum - target < 0 || ((totalSum - target) % 2) != 0) return 0;
   
           int targetSum = (totalSum - target)/2;
              
           int[][] dp = new int[n][targetSum + 1];
           
           if(nums[0] == 0) dp[0][0] = 2;
           else dp[0][0] = 1;
           
           if(nums[0] != 0 && nums[0] <= targetSum) dp[0][nums[0]] = 1;
           
           for(int i = 1; i < n; i++){
               for(int sum = 0; sum <= targetSum; sum++){
                   // take
                   int take = 0;
                   if(sum >= nums[i]) take = dp[i - 1][sum - nums[i]];
                   
                   // not take
                   int notTake = dp[i - 1][sum];
                   
                   dp[i][sum] =  (take + notTake);
               }
           }
           return dp[n - 1][targetSum];
       }
    */

    // Space Optimization

    public static int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0, n = nums.length;
        for(int i = 0; i < n; i++) totalSum += nums[i];
        
        if(totalSum - target < 0 || ((totalSum - target) % 2) != 0) return 0;

        int targetSum = (totalSum - target)/2;
           
        int[] prev = new int[targetSum + 1];
        int[] curr = new int[targetSum + 1];
        
        if(nums[0] == 0) prev[0] = 2;
        else prev[0] = 1;
        
        if(nums[0] != 0 && nums[0] <= targetSum) prev[nums[0]] = 1;
        
        for(int i = 1; i < n; i++){
            for(int sum = 0; sum <= targetSum; sum++){
                // take
                int take = 0;
                if(sum >= nums[i]) take = prev[sum - nums[i]];
                
                // not take
                int notTake = prev[sum];
                
                curr[sum] =  (take + notTake);
            }
            prev = curr.clone();
        }
        return prev[targetSum];
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;
        System.out.println(findTargetSumWays(nums, target));
    }
}
