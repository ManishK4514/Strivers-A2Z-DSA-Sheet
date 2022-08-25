/*
 * Given an array arr[] of size N and an integer K, the task is to left rotate the array K indexes

   Example 1:
   Input: N = 7, K = 2
   arr[] = {1, 2, 3, 4, 5, 6, 7}
   Output: 3 4 5 6 7 1 2
   Explanation: Rotation of the above 
   array by 2 will make the output array .

 */

public class Left_Rotate_an_array_by_K_place {
    public static void rotate(int[] nums, int k) {
        /*
         * BruteForce Solution: Time complexity: O(N^2) & Space complexity: O(N)
         * int n = nums.length;
           for(int i = 0; i < k; i++){
               int firstIndex = nums[0];
               for(int j = 0; j < n - 1; j++){
                   nums[j] = nums[j + 1];
               }
               nums[n - 1] = firstIndex;
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
        // Copying from temp array by leaving k Elements.
        for(int i = 0; i < n - k; i++){
            nums[i] = temp[i + k];
        }
        // Now Adding those K elements into the Original Array.
        for(int i = 0; i < k; i++){
            nums[(n - k) + i] = temp[i];
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 2;
        rotate(nums, k);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
}
