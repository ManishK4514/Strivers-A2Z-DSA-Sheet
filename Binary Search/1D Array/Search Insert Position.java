/*
   Q. Write a program to Search Insert Position in an Array.
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
   Example 1:
   
   Input: nums = [1,3,5,6], target = 5
   Output: 2
   Example 2:
   
   Input: nums = [1,3,5,6], target = 2
   Output: 1
   Example 3:
   
   Input: nums = [1,3,5,6], target = 7
   Output: 4
 
*/


public class Search_Insert_Position_In_An_Array {
    public static int searchInsert(int[] nums, int target) {
        /*
            // BruteForce Approach: Time complexity: O(N) & Space complexity: O(1).
         *  if(nums[0] > target){
                return 0;
            }
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == target){
                    return i;
                }
                else if(nums[i] > target){
                    return i;
                }            
            }       
            return nums.length;
        */

        // Solution 2: Optimized --> Time complexity: O(logN) & Space complexity: O(1).
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while(low <= high){
            mid = (low + high)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(target > nums[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 2;
        System.out.println(searchInsert(nums, target));
    }
}
