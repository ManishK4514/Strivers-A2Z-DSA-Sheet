/*
   You are given an integer array nums. The range of a subarray of nums is the difference between the largest and smallest element in the subarray.

   Return the sum of all subarray ranges of nums.
   
   A subarray is a contiguous non-empty sequence of elements within an array.

   Example 1:
   
   Input: nums = [1,2,3]
   Output: 4
   Explanation: The 6 subarrays of nums are the following:
   [1], range = largest - smallest = 1 - 1 = 0 
   [2], range = 2 - 2 = 0
   [3], range = 3 - 3 = 0
   [1,2], range = 2 - 1 = 1
   [2,3], range = 3 - 2 = 1
   [1,2,3], range = 3 - 1 = 2
   So the sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4.

   Example 2:
   
   Input: nums = [1,3,3]
   Output: 4
   Explanation: The 6 subarrays of nums are the following:
   [1], range = largest - smallest = 1 - 1 = 0
   [3], range = 3 - 3 = 0
   [3], range = 3 - 3 = 0
   [1,3], range = 3 - 1 = 2
   [3,3], range = 3 - 3 = 0
   [1,3,3], range = 3 - 1 = 2
   So the sum of all ranges is 0 + 0 + 0 + 2 + 0 + 2 = 4.

   Example 3:   
   Input: nums = [4,-2,-3,4,1]
   Output: 59
   Explanation: The sum of all subarray ranges of nums is 59.
*/


public class Sum_of_subarray_ranges {
    public static long subArrayRanges(int[] nums) {
        // BruteForce Approach: Time complexity: O(N^2) & Space Complexity: O(1).
        long sum = 0;
        for(int i = 0; i < nums.length; i++){
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int j = i; j < nums.length; j++){
                min = Math.min(nums[j], min);
                max = Math.max(nums[j], max);
                sum += max-min;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subArrayRanges(nums));
    }
}
