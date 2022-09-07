/*
 * Q. Write a program to find the Ceil Value in an Array.
 * 
 * Input:
 * int[] nums = {1,2,8,10,11,12,19};
   int target = 5;
   Output: 2 (which is the index of 8 i.e ceil value).

*/


public class Implement_Upper_Bound_In_Sorted_Array {
    public static int findCeil(int[] nums, int target){
        /*
         * BruteForce Approach: Time complexity: O(N) & Space complexity: O(1).
         * int ceil = Integer.MAX_VALUE;
           for(int i = 0; i < nums.length; i++){
               if(ceil > nums[i] && nums[i] >= target){
                   ceil = nums[i];
               }
           }
           if(ceil == Integer.MAX_VALUE){
               ceil = -1;
           }
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
                if(nums[mid] > target){
                    result = mid;
                }
            }
            else{
                start = mid + 1;                
            }
        } 
        return result;  
    }
    public static void main(String[] args) {
        int[] nums = {1,2,8,10,11,12,19};
        int target = 5;
        System.out.println(findCeil(nums, target));
    }
}
