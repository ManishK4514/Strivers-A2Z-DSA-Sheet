/*
 * Peak element in Array
   Problem Statement: Given an array, find a peak element(print anyone, if many are found). A peak element is one such that it is either greater than or equal to its neighbours. For the first and last element, it is enough to look at its only one neighbour.
   
   Examples:
   
   Example 1:
   Input:
    arr = {3, 5, 4, 1, 1}
   
   Output: Peak Element is 5
   Explanation:
    3 and 4 are lesser than 5, therefore 5 is a peak element (1 is also a peak element).
   
   Example 2:
   Input: arr = {2,6,3,7,8,9}
   Output: Peak element is 6
   Explanation: 2 and 3 are lesser than 6, therefore 6 is a peak element (9 is also a peak element)
*/


public class Peak_element_in_Array {
    public static int findPeakElement(int[] nums, int n) {
        /*
         * Solution 1: BruteForce Approach: Time complexity: O(N) & Space complexity: O(1).
         * for(int i = 0; i < nums.length - 1; i++){
               if(nums[i] > nums[i + 1]){
                   return nums[i];
               }
           }
           return nums[nums.length - 1];
        */
        
        // Solution 2: Optimized -> Time complexity: O(logN) & Space complexity: O(1).
        if(nums.length == 1){
            return nums[0];
        }
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(mid > 0 && mid < nums.length - 1){
                if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
                    return nums[mid];
                }
                else if(nums[mid - 1] > nums[mid]){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            else if(mid == 0){
                if(nums[mid] > nums[mid + 1]){
                    return nums[mid];
                }
                else{
                    return nums[mid + 1];
                }
            }
            else if(mid == nums.length - 1){
                if(nums[mid] > nums[mid - 1]){
                    return nums[mid];
                }
                else{
                    return nums[mid - 1];
                }
            }
        }
        return nums[nums.length - 1];
    }
    public static void main(String[] args) {
        int[] arr = {5, 10, 20, 15};
        int n = arr.length;
        System.out.println("Peak Element is " + findPeakElement(arr, n));
    }
}
