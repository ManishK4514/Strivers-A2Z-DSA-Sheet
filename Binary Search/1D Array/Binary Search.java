/*
 * Q. Write a program to Search an element from an array using binary Search.
 * Algorithm:

   Consider start index to be at 0 and last index to be n-1th index at starting      //n->length 
   Find middle index(mid) of the array
   If key is found to be less than mid index element then update last index of the array to mid -1
   Else if key is found to be greater than mid index element then update start index of the array to mid +1
   Else check for mid index element with key if not match repeat the above steps till start index is less than end index

   Example:

   Example 1:
   Input: nums = [-1,0,3,5,9,12], target = 9
   Output: 4
   Explanation: 9 exists in nums and its index is 4
   
   Example 2:
   Input: nums = [-1,0,3,5,9,12], target = 2
   Output: -1
   Explanation: 2 does not exist in nums so return -1
 
*/


class Binary_Search{
    public static int search(int[] nums, int target) {
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
            }
        } 
        return -1;       
    }
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(nums, target));
    }
}
