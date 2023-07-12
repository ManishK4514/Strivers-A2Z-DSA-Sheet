/*
    Q. Printing Longest Increasing Subsequence | (DP-42)

    Practice : https://leetcode.com/problems/longest-increasing-subsequence/description/

    Given an integer array nums, print the longest strictly increasing subsequence.
    
    Example 1:
    
    Input: nums = [10,9,2,5,3,7,101,18]
    Output: 2 5 7 18
    Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
    Example 2:
    
    Input: nums = [0,1,0,3,2,3]
    Output: 0 1 2 3
    Example 3:
    
    Input: nums = [7,7,7,7,7,7,7]
    Output: 7
*/

// import java.util.Arrays;

import java.util.Arrays;

public class Printing_Longest_Increasing_Subsequence {
    public static void lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.fill(dp, 1);

        int size = 0, lastIdx = 0;

        for(int i = 0; i < n; i++){
            hash[i] = i;
            for(int prevIdx = 0; prevIdx < i; prevIdx++){
               if(nums[i] > nums[prevIdx] && dp[i] < 1 + dp[prevIdx]){
                   dp[i] = dp[prevIdx] + 1;
                   hash[i] = prevIdx;
               }
            }  
            if(size < dp[i]){
                size = dp[i];
                lastIdx = i;
            }       
        }

        int[] LIS = new int[size];

        // filling LIS array from last because we will get values in reverse order

        LIS[size - 1] = nums[lastIdx];

        int idx = size - 2;

        while(hash[lastIdx] != lastIdx){
            lastIdx = hash[lastIdx];
            LIS[idx--] = nums[lastIdx];
        }
    
        System.out.println(Arrays.toString(LIS));
    }

    public static void main(String[] args) {
        int[] nums = {7,7,7,7,7,7,7};
        lengthOfLIS(nums);
    }
}
