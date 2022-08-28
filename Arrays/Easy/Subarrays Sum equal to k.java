/*
 * Longest Subarray with given Sum K
   Problem Statement: Given an array and a sum k, we need to print the length of the longest subarray that sums to k.
   
   Examples:
   
   Example 1:
   Input:
   arr = {7,1,6,0}, k = 7
   
   Output: Length of the longest subarray with sum K is 3
   Explanation:
    1 + 6 + 0 = 7, it is the longest subarray with sum 7 and length 3.
   
   Example 2:
   Input: 
   arr = {2,3,5,1,9}, k = 10
   Output: Length of the longest subarray with sum K is 3
   Explanation: 2 + 3 + 5 = 10, it is the longest subarray with sum 10 and length 3
*/
public class SubArray_Sum_Equal_To_K {
    public static int subarraySum(int[] arr, int target){
        /*
         * BruteForce Approach: Time Complexity: O(N^2^K) & Space Complexity: O(1)
         * int count = 0;
           for(int i = 0; i < arr.length; i++){
               for(int j = i; j < arr.length; j++){
                   int sum = 0;
                   for(int k = i; k <= j; k++){
                       sum += arr[k];
                   }
                   if(sum == target){
                       count = Math.max(count, (j - i + 1));
                   }
               }
           }
           return count;
        */
        /*
         * Solution 2: Time Complexity: O(N^2) & Space complexity: O(1)
         * int count = 0;
           for(int i = 0; i < arr.length; i++){
               int sum = 0;
               for(int j = i; j < arr.length; j++){
                   sum += arr[j];
                   if(sum == target){
                       count = Math.max(count, (j - i + 1));
                   }
               }
           }
           return count;
        */
        // Solution: 03 --> Time Complexity: O(2N) ~ O(N)
        
        int start = 0, end = -1, sum = 0, maxLength = 0;
        while (start < arr.length) {
          while ((end + 1 < arr.length) && (sum + arr[end + 1] <= target))
            sum += arr[++end];
    
          if (sum == target)
            maxLength = Math.max(maxLength, (end - start + 1));
    
          sum -= arr[start];
          start++;
        }
        return maxLength;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int k = 3;
        System.out.println(subarraySum(nums, k));
    }
}
