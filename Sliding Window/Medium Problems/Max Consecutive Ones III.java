/*
   1004. Max Consecutive Ones III
   Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
   
    
   
   Example 1:
   
   Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
   Output: 6
   Explanation: [1,1,1,0,0,1,1,1,1,1,1]
   Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
   
   Example 2:
   
   Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
   Output: 10
   Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
   Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 */


public class Max_Consecutive_Ones_III {
    public static int longestOnes(int[] nums, int k) {
        int i = 0, j = 0, zeroCount = 0, max = Integer.MIN_VALUE;
        while(j < nums.length){
            if(nums[j] == 0){
                zeroCount++;
            }
            while(zeroCount > k){
                if(nums[i] == 0){
                    zeroCount--;
                }
                i++;
            }
            max = Math.max(max, (j-i) + 1);
            j++;
        }
        return max;
    }
    public static void main(String[] args) {
        int nums[] = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(longestOnes(nums, 2));
    }
}
