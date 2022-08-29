
      ⊛ The brute force approach is find the all possible subarrays and calculate the sum. (Time complexity: O(N^3)
      ⊛  We only need to calculate the maximum sum so we can avoid our third loop and when ever previous sum is less than curr sum we will updated our sum. (O(N^2))
      ⊛  The Best Optimized Approach is to use KADANE'S ALGORITHM
      ⊛ Time Complexity: O(N ) & Space Complexity: O(1).


/*
 * Kadane’s Algorithm : Maximum Subarray Sum in an Array
   Problem Statement: Given an integer array arr, find the contiguous subarray (containing at least one number) which
   has the largest sum and return its sum and print the subarray.
   
   Examples:
   
   Example 1:
   Input: arr = [-2,1,-3,4,-1,2,1,-5,4] 
   Output: 6 
   Explanation: [4,-1,2,1] has the largest sum = 6. 
   
   Examples 2: 
   Input: arr = [1] 
   Output: 1 
   Explanation: Array has only one element and which is giving positive sum of 1. 

 */

public class Maximum_Subarray_Sum {
    public static int maxSubArray(int[] nums) {
        /*
         * BruteForce Solution: --> Time Complexity: O(N^2) & Space Complexity: O(1):
         * In this we find all possible subarrays sum and then find the maximum among them.
         * int maxSum = Integer.MIN_VALUE;
           for(int i = 0; i < nums.length; i++){
               int sum = 0;
               for(int j = i; j < nums.length; j++){
                   sum += nums[j];
                   maxSum = Math.max(maxSum, sum);
               }
           }
           return maxSum;

        */
        
        // Optimized Solution: Using Kadane's algorithm
        // Time complexity: O(N) & Space Complexity: O(1).

        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i = 0; i < nums.length; i++){
            currSum += nums[i];
            if(maxSum < currSum){
                maxSum = currSum;
            }
            if(currSum < 0){
                currSum = 0;
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
