/*
    Q. Longest Divisible Subset | (DP-44)

    Practice : https://leetcode.com/problems/largest-divisible-subset/

    Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:

    answer[i] % answer[j] == 0, or
    answer[j] % answer[i] == 0
    If there are multiple solutions, return any of them.
    
    Example 1:
    
    Input: nums = [1,2,3]
    Output: [1,2]
    Explanation: [1,3] is also accepted.
    Example 2:
    
    Input: nums = [1,2,4,8]
    Output: [1,2,4,8]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Longest_Divisible_Subset {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] hash = new int[n];
        int lastIdx = 0, size = 0;

        for(int i = 0; i < n; i++){
            hash[i] = i;
            for(int prevIdx = 0; prevIdx < i; prevIdx++){
                if(nums[i] % nums[prevIdx] == 0 && dp[i] < (1 + dp[prevIdx])){
                    dp[i] = dp[prevIdx] + 1;
                    hash[i] = prevIdx;
                }
            }
            if(size < dp[i]){
                size = dp[i];
                lastIdx = i;
            }            
        }

        List<Integer> ans = new ArrayList<>();

        ans.add(nums[lastIdx]);

        while(hash[lastIdx] != lastIdx){
            lastIdx = hash[lastIdx];
            ans.add(nums[lastIdx]);
        }
        
        // we will get our LDS in reverse order so again we can reverse to get in increaing order
        Collections.reverse(ans);

        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {5,9,18,54,108,540,90,180,360,720};
        System.out.println(largestDivisibleSubset(nums));
    }
}
