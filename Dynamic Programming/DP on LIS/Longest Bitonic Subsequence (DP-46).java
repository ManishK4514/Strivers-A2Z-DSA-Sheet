/*
    Q. Longest Bitonic Subsequence | (DP-46)

    Practice : https://practice.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1

    Given an array of positive integers. Find the maximum length of Bitonic subsequence. 
    A subsequence of array is called Bitonic if it is first strictly increasing, then strictly decreasing.
     
    
    Example 1:
    
    Input: nums = [1, 2, 5, 3, 2]
    Output: 5
    Explanation: The sequence {1, 2, 5} is
    increasing and the sequence {3, 2} is 
    decreasing so merging both we will get 
    length 5.
    Example 2:
    
    Input: nums = [1, 11, 2, 10, 4, 5, 2, 1]
    Output: 6
    Explanation: The bitonic sequence 
    {1, 2, 10, 4, 2, 1} has length 6.
*/

import java.util.Arrays;

public class Longest_Bitonic_Subsequence {
    /*
       // My Initial Solution
       public static int LongestBitonicSequence(int[] nums) {           
           int n = nums.length;
           int[] dp1 = new int[n];
           Arrays.fill(dp1, 1);
   
           for(int i = 0; i < n; i++){
               for(int prevIdx = 0; prevIdx < i; prevIdx++){
                   
                   if(nums[i] > nums[prevIdx] && dp1[i] < dp1[prevIdx] + 1){
                       dp1[i] = dp1[prevIdx] + 1;
                   }
               }
           }
           
           int[] dp2 = new int[n];
           Arrays.fill(dp2, 1);
           
           for(int i = n - 1; i >= 0; i--){
               for(int prevIdx = n - 1; prevIdx > i; prevIdx--){
                   
                   if(nums[i] > nums[prevIdx] && dp2[i] < dp2[prevIdx] + 1){
                       dp2[i] = dp2[prevIdx] + 1;
                   }
               }
           }
           
           int max = 1;
           
           for(int i = 0; i < n - 1; i++){
               for(int j = i + 1; j < n; j++){
                   if(nums[i] > nums[j]){
                        max = Math.max(max, dp1[i] + dp2[j]);
                    }
               }
           }
           
           // take the max of dp1 or max of dp2
           max = Math.max(max, Math.max(dp1[n - 1], dp2[0]));
           
           return max;
       }
    */
    
    /*
       public static int LongestBitonicSequence(int[] nums) {
           int n = nums.length;
           int[] dp1 = new int[n];
           Arrays.fill(dp1, 1);
   
           for(int i = 0; i < n; i++){
               for(int prevIdx = 0; prevIdx < i; prevIdx++){
                   
                   if(nums[i] > nums[prevIdx] && dp1[i] < dp1[prevIdx] + 1){
                       dp1[i] = dp1[prevIdx] + 1;
                   }
               }
           }
           
           int[] dp2 = new int[n];
           Arrays.fill(dp2, 1);
           
           for(int i = n - 1; i >= 0; i--){
               for(int prevIdx = n - 1; prevIdx > i; prevIdx--){
                   
                   if(nums[i] > nums[prevIdx] && dp2[i] < dp2[prevIdx] + 1){
                       dp2[i] = dp2[prevIdx] + 1;
                   }
               }
           }
           
           int max = 1;
           
           for(int i = 0; i < n; i++){
               max = Math.max(max, dp1[i] + dp2[i] - 1);
           }
           
           return max;
       }
    */    

    // More Concise
    public static int LongestBitonicSequence(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n];
        Arrays.fill(dp1, 1);

        for(int i = 0; i < n; i++){
            for(int prevIdx = 0; prevIdx < i; prevIdx++){
                
                if(nums[i] > nums[prevIdx] && dp1[i] < dp1[prevIdx] + 1){
                    dp1[i] = dp1[prevIdx] + 1;
                }
            }
        }
        
        int[] dp2 = new int[n];
        Arrays.fill(dp2, 1);
        
        int max = 1;
        
        for(int i = n - 1; i >= 0; i--){
            for(int prevIdx = n - 1; prevIdx > i; prevIdx--){
                
                if(nums[i] > nums[prevIdx] && dp2[i] < dp2[prevIdx] + 1){
                    dp2[i] = dp2[prevIdx] + 1;
                }
            }
            max = Math.max(max, dp1[i] + dp2[i] - 1);
        }
        
        return max;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 11, 2, 10, 4, 5, 2, 1};
        System.out.println(LongestBitonicSequence(nums));
    }
}
