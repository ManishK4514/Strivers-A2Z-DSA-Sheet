/*
    Q. Longest Bitonic Subsequence | (DP-46)

    Practice : https://leetcode.com/problems/number-of-longest-increasing-subsequence/

    Given an integer array nums, return the number of longest increasing subsequences.

    Notice that the sequence has to be strictly increasing.   
    
    Example 1:
    
    Input: nums = [1,3,5,4,7]
    Output: 2
    Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
    Example 2:
    
    Input: nums = [2,2,2,2,2]
    Output: 5
    Explanation: The length of the longest increasing subsequence is 1, and there are 5 increasing subsequences of length 1, so output 5.
*/

import java.util.Arrays;

public class Number_of_Longest_Increasing_Subsequences {
    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);

        int max = 1;

        for(int i = 0; i < n; i++){
            for(int prevIdx = 0; prevIdx < i; prevIdx++){
                if(nums[i] > nums[prevIdx] && dp[i] < dp[prevIdx] + 1){
                    dp[i] = dp[prevIdx] + 1;
                    cnt[i] = cnt[prevIdx];
                }
                else if(nums[i] > nums[prevIdx] && dp[i] == dp[prevIdx] + 1){
                    cnt[i] += cnt[prevIdx];
                }
            }
            max = Math.max(max, dp[i]);
        }

        int ans = 0;
    
        for(int i = 0; i <= n - 1; i++){
           if(dp[i] == max) ans += cnt[i];
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        System.out.println(findNumberOfLIS(nums));
    }
}
