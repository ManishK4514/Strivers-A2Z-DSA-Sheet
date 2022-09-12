/*
 * Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, divide all the array by it, and sum the division's result. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.

   Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).
   
   The test cases are generated so that there will be an answer.
   
    
   
   Example 1:   
   Input: nums = [1,2,5,9], threshold = 6
   Output: 5
   Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1. 
   If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2). 

   Example 2:   
   Input: nums = [44,22,33,11,1], threshold = 5
   Output: 44
*/


public class Find_the_Smallest_Divisor_Given_a_Threshold {
    public static int smallestDivisor(int[] nums, int threshold) {
        /*
         * BruteForce Approach: Time complexity: O(N + MaxElementOfArray * N) & Space complexity: O(1).
           int max = Integer.MIN_VALUE;          
           for(int val: nums){
               max = Math.max(max, val);
           }
           int sum;
           for(int i = 1; i <= max; i++){
               sum = 0;
               for(int j = 0; j < nums.length; j++){
                   sum += (nums[j] % i == 0) ? (nums[j]/i):((nums[j]/i) + 1);
               }
               if(sum <= threshold){
                   return i;
               }
           }
           return -1;
        */
        
        // Optimized Approach: Time complexity: O(N + logN) & Space complexity: O(1).

        int max = Integer.MIN_VALUE;
        for(int val: nums){
            max = Math.max(max, val);
        }
        int start = 1;
        int end = max;
        int sum;
        while(start < end){
            int mid = start + (end - start)/2;
            sum = 0;
            for(int j = 0; j < nums.length; j++){
                sum += (nums[j] % mid == 0) ? (nums[j]/mid):((nums[j]/mid) + 1);
            }
            if(sum <= threshold){
                end = mid;
            }
            else{
                start = mid + 1;
            }
        }
        return start;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,5,9};
        int threshold = 6;
        System.out.println(smallestDivisor(nums, threshold));
    }
}
