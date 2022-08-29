      ⊛ The brute force approach is find the all possible subarrays and calculate the sum which is equal to K. (Time complexity: O(N^3)
      ⊛  We only need to calculate the maximum sum so we can avoid our third loop and when ever previous sum is less than curr sum we will updated our sum until sum != K. (O(N^2))
      ⊛ Now there is another optimized way for this.
      ⊛ Time Complexity: O(N ) & Space Complexity: O(1).


/*
 * Subarray with Given Sum
   Problem Statement: Subarray with Given Sum
   
   Given an array and a sum k, generate the subarray whose elements sum to k.
   
   Examples:
   
   Example 1:
   Input:
    arr = {1, 7, 3, 9}, k = 10
   
   Output: 7 3
   Explanation:
    Of all the subarrays, 7 and 3 sums to 10.
   
   Example 2:
   Input: arr = {2,1,3,4,5,6}, k = 10
   Output: 2 1 3 4
   Explanation: Of all the subarrays, 2, 1, 3 and 4 sums to 10

 */

public class Subarray_Sum_Equal_to_K {
    public static void subArrWithSumK(int nums[], int k)
    {
        /*Bruteforce Approach: Time complexity: O(N^2) & Space Complexity: O(1).
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                if(sum == k){
                    for(int m = i; m <= j; m++){
                        System.out.print(nums[m] + " ");
                    }
                    System.out.println();
                }
            }
        }
        */ 

        // Optimized Solution: Time Complexity: O(N) to find subarray and O(N) to print subarray & Space complexity: O(1)
        int start = 0, end = -1, sum = 0;
        while (start < nums.length) {
          while ((end + 1 < nums.length) && (sum + nums[end + 1] <= k)){
            sum += nums[++end];
          }
          if (sum == k) {
            for (int p = start; p <= end; p++)
              System.out.print(nums[p] + " ");
            System.out.println();
          }
    
          sum -= nums[start];
          start++;
        }  
    }

    public static void main(String[] args) {
        int[] nums = { 1, 9, 3, 7 };
        int k = 10;
        subArrWithSumK(nums, k);
    }
}
