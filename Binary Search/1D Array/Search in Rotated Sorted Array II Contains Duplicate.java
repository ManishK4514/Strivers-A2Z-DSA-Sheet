/*
 * Search Element in a Rotated Sorted Array
   Problem Statement: There is an integer array nums sorted in ascending order (with distinct values). Given the array nums after the possible clockwise rotation and an integer target, return the true if element is in nums, or false if it is not in nums. We need to search a given element in a rotated sorted array which also contains duplicates.
   
   Example 1:
   
   Input: nums = [1, 0, 1, 1, 1, 1], target = 0
   
   Output: true
   
   Explanation: Here, the target is 0. We can see that 0 is present in the given rotated sorted array, nums. Thus, we get output as 4, which is the index at which 0 is present in the array.
   Example 2:
   
   Input: nums = [4,5,6,7,0,1,2], target = 3
   
   Output: false
   
   Explanation: Here, the target is 3. Since 3 is not present in the given rotated sorted array. Thus, we get output as -1.
*/


public class Search_in_Rotated_Sorted_Contains_Duplicate_Array_II {
    public static boolean search(int[] nums, int target) {
        /*
         * BruteForce Appraoch: Time complexity: O(N) & Space complexity: O(1).
         * int ans = -1;
           for(int i = 0; i < nums.length; i++){
               if(nums[i] == target){
                   ans = i;
                   return ans;
               }
           }
           return ans;
        */
        
        // Optimized Approach: Time compelxity: O(logN) & Space complexity: O(1).
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                return true;
            }
            // check for duplicate
            if((nums[mid] == nums[start]) && nums[mid] == nums[end]){
                start++; end--;
            }
            // check if left half is sorted
            else if(nums[mid] >= nums[start]){
                if(target >= nums[start] && target <= nums[mid]){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            // check if Right half is sorted
            else{
                if(target <= nums[end] && target >= nums[mid]){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[] = {3, 1, 2, 3, 3, 3, 3};
        int target = 1;
        System.out.println("The target Element is present in the Array: " + search(arr,target));
    }
}
