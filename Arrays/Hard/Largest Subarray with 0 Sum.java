import java.util.HashMap;

/*
 * Length of the longest subarray with zero Sum
   Problem Statement: Given an array containing both positive and negative integers, we have to find the length of the longest subarray with the sum of all elements equal to zero.
   
   Example 1:   
   Input Format: N = 6, array[] = {9, -3, 3, -1, 6, -5}   
   Result: 5   
   Explanation: The following subarrays sum to zero:
   {-3, 3} , {-1, 6, -5}, {-3, 3, -1, 6, -5}
   Since we require the length of the longest subarray, our answer is 5!

   Example 2:   
   Input Format: N = 8, array[] = {6, -2, 2, -8, 1, 7, 4, -10}   
   Result: 8
   
   Subarrays with sum 0 : {-2, 2}, {-8, 1, 7}, {-2, 2, -8, 1, 7}, {6, -2, 2, -8, 1, 7, 4, -10}
   Length of longest subarray = 8

   Example 3:   
   Input Format: N = 3, array[] = {1, 0, -5}   
   Result: 1
   
   Subarray : {0}
   Length of longest subarray = 1
   Example 4:
   
   Input Format: N = 5, array[] = {1, 3, -5, 6, -2}   
   Result: 0   
   Subarray: There is no subarray that sums to zero
*/


public class Largest_Subarray_with_0_Sum {
    public static int LargestSubarray(int[] nums){
        /*
         * BruteForce Approach: Time complexity: O(N^2) & Space complexity: O(1).
         * int ans = 0, temp = 0;
           for(int i = 0; i < nums.length; i++){
               int sum = 0;
               for(int j = i; j < nums.length; j++){
                   sum += nums[j];
                   if(sum == 0){
                       temp = (j - i) + 1;
                   }
                   ans = Math.max(ans, temp);
               }
           }
           return ans;
        */

        // Optimized Approach: Time complexity: O(NlogN) & Space complexity: O(N).
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxi = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sum == 0){
                maxi = i + 1;
            }
            else{
                if(map.get(sum) != null){
                    maxi = Math.max(maxi, i - map.get(sum));
                }
                else{
                    map.put(sum, i);
                }
            }
        }
        return maxi;
    }
    public static void main(String[] args) {
       int[] nums = {15,-2,2,-8,1,7,10,23};
       System.out.println(LargestSubarray(nums));
    }
}
