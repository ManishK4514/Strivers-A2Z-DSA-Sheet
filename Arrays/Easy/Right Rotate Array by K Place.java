/*
 * Given an array, rotate the array to the right by k steps, where k is non-negative.

   Example 1:
   Input: nums = [1,2,3,4,5,6,7], k = 3
   Output: [5,6,7,1,2,3,4]
   Explanation:
   rotate 1 steps to the right: [7,1,2,3,4,5,6]
   rotate 2 steps to the right: [6,7,1,2,3,4,5]
   rotate 3 steps to the right: [5,6,7,1,2,3,4]

 */


public class Right_rotate_an_array_by_K_places {
    public static void rotate(int[] nums, int k) {
        /*
         * BruteForce Solution: Time complexity: O(N^2) & Space complexity: O(N)
         * int n = nums.length;
           for(int i = 0; i < k; i++){
               int lastIndex = nums[n - 1];
               for(int j = n - 1; j >= 1; j--){
                   nums[j] = nums[j - 1];
               }
               nums[0] = lastIndex;
           }
        */
        
        // Solution 2: Time Complexity: O(N) & Space Complexity: O(N)

        // By doing rotation more than size of array cause index out of bound 
        // k %= nums.length will resolve that

        k = k % nums.length;
        int n = nums.length;
        // creating temp Array
        int[] temp = new int[n];
        // copying oringinal Array item into the temp Array.
        for(int i = 0; i < n; i++){
            temp[i] = nums[i];
        }
        // Copying from temp array by leaving K Elements.
        for(int i = n - k - 1; i >= 0; i--){
            nums[i + k] = temp[i];
        }
        // Now Adding those K elements into the Original Array.
        for(int i = 0; i < k; i++){
            nums[i] = temp[(n + i) - k];
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 26;
        rotate(nums, k);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
}
