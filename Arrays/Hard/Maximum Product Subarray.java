/*
 * Maximum Product Subarray in an Array
   Problem Statement: Given an array that contains both negative and positive integers, find the maximum product subarray.
   
   Examples:
   
   Example 1:
   Input:
    Nums = [1,2,3,4,5,0]
   Output:
    120
   Explanation:
    In the given array, we can see 1×2×3×4×5 gives maximum product value.
   
   
   Example 2:
   Input:
    Nums = [1,2,-3,0,-4,-5]
   Output:
    20
   Explanation:
   In the given array, we can see (-4)×(-5) gives maximum product value.
*/


public class Maximum_Product_Subarrays {
    public static int maxProductSubArray(int[] nums){
        /*
         * //BruteForce Approach: Time complexity: O(N^2) & Space complexity: O(1).
         * int ans = Integer.MIN_VALUE;
           for(int i = 0; i < nums.length; i++){
               int product = 1;
               for(int j = i; j < nums.length; j++){
                   product *= nums[j];
                   ans = Math.max(ans, product);
               }
           }
           return ans;
        */

        // Solution 2:  Time complexity: O(N) & Space complexity: O(1)
        int ans = nums[0];
        int max = ans;
        int min = ans;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < 0){
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(nums[i], max*nums[i]);
            min = Math.min(nums[i], min*nums[i]);
            ans = Math.max(ans, max);
        }
        return ans;
    }
    public static void main(String[] args) {
        int nums[] = {2, 3, -2, 4};
		int answer = maxProductSubArray(nums);
		System.out.print("The maximum product subarray is: "+answer);
    }
}
