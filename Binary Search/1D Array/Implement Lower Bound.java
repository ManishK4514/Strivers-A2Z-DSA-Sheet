/*
 * Given a sorted array arr[] of size N without duplicates, and given a value x. Floor of x is defined as the largest element K in arr[] such that K is smaller than or equal to x. Find the index of K(0-based indexing).

   Example 1:
   Input:
   N = 7, x = 0 
   arr[] = {1,2,8,10,11,12,19}
   Output: -1
   Explanation: No element less than 0 is found. So output is "-1".
   
   Example 2:
   Input:
   N = 7, x = 5 
   arr[] = {1,2,8,10,11,12,19}
   Output: 1
   Explanation: Largest Number less than 5 is 2 (i.e K = 2), whose index is 1(0-based indexing).
*/


public class Implement_Lower_Bound_in_Sorted_Array {
    public static int findFloor(int[] nums, int target){
        /*
         * BruteForce Approach: Time complexity: O(N) & Space complexity: O(1).
         * if(nums[0] > target){
               return -1;
           }
           int result = -1;
           for(int i = 1; i < nums.length; i++){
               if(nums[i] == target){
                   return i;
               }
               else if(nums[i] > target){
                   result = i - 1;
                   break;
               }
               if(i == nums.length - 1 && nums[i] < target){
                   return i;
               }
           }
           return result;
        */
        
        // Solution 2: Optimized
        // Time complexity: O(logN) & Space complexity: O(1).
        
        int result = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
                if(nums[mid] < target){
                    result = mid;
                }
            }
        } 
        return result;  
    }
    public static void main(String[] args) {
        int[] nums = {1,2,8,10,11,12,19};
        int target = 5;
        System.out.println(findFloor(nums, target));
    }
}
