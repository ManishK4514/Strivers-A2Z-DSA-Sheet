/*
    Q. Longest Increasing Subsequence | (DP-41)

    Practice : https://leetcode.com/problems/longest-increasing-subsequence/description/

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
           if(i < 0) return 0;
           
           int take = 0;
           if(prevIdx == -1 || nums[prevIdx] > nums[i]){
               take = 1 + helper(nums, i - 1, i);
           }
           int notTake = helper(nums, i - 1, prevIdx);
           
           return Math.max(take, notTake);
       }
   
       public static int lengthOfLIS(int[] nums) {
           int n = nums.length;
           return helper(nums, n - 1, -1);
       }
    */

    // Memoization

    public static int helper(int[] nums, int i, int prevIdx){
        if(i < 0) return 0;
        
        int take = 0;
        if(prevIdx == -1 || nums[prevIdx] > nums[i]){
            take = 1 + helper(nums, i - 1, i);
        }
        int notTake = helper(nums, i - 1, prevIdx);
        
        return Math.max(take, notTake);
    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        return helper(nums, n - 1, -1);
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
}
