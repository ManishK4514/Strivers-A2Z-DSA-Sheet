/*
 * Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.

   Write an algorithm to minimize the largest sum among these m subarrays.
   
    
   
   Example 1:
   
   Input: nums = [7,2,5,10,8], m = 2
   Output: 18
   Explanation:
   There are four ways to split nums into two subarrays.
   The best way is to split it into [7,2,5] and [10,8],
   where the largest sum among the two subarrays is only 18.
   
   Example 2:
   
   Input: nums = [1,2,3,4,5], m = 2
   Output: 9
   
   Example 3:
   
   Input: nums = [1,4,4], m = 3
   Output: 4
*/


public class Split_Array_Largest_Sum {
    public static boolean check(int[] arr, int m, int mid){
        if(arr.length < m){
            return false;
        }
        int allocatedSubArr = 1;
        int elements = 0;
        for (int j = 0; j < arr.length; j++) {
          if (elements + arr[j] > mid) {
            allocatedSubArr++;
            elements = arr[j];
            if (elements > mid) return false;
          } else {
            elements += arr[j];
          }
        }
        if (allocatedSubArr <= m) return true;
        return false;
    }
    public static int splitArray(int[] nums, int m) {

        /*
         * BruteForce Approach: Time complexity: O(N^2) & Space complexity: O(1).
         * int sum = 0;
           for(int i = 0; i < nums.length; i++){
               sum += nums[i];
           }
           int start = nums[0];
           int end = sum;
           for(int i = start; i <= end; i++){
               boolean possible = check(nums, m, i);
               if(possible){
                   return i;
               }
           }
           return -1;
        */
        
        // Optimized Approach: Using binary Search
        // Time complexity: O(N * logN) & Space Complexity: O(1).

        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        int start = nums[0];
        int end = sum;
        int ans = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            boolean possible = check(nums, m, mid);
            if(possible){
                ans = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int m = 2;
        System.out.println(splitArray(nums, m));
    }
}
