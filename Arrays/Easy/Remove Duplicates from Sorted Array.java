/*
   Q. Write a program to remove duplicates from Sorted Array and Return K where K is the Last position of distinct element.
 * Example 1: 

   Input: arr[1,1,2,2,2,3,3]
   
   Output: arr[1,2,3,_,_,_,_]
   
   Explanation: Total number of unique elements are 3, i.e[1,2,3] and Therefore return 3 after assigning [1,2,3] in the beginning of the array.
   
   Example 2: 
   
   Input: arr[1,1,1,2,2,3,3,3,3,4,4]
   
   Output: arr[1,2,3,4,_,_,_,_,_,_,_]
   
   Explanation: Total number of unique elements are 4, i.e[1,2,3,4] and Therefore return 4 after assigning [1,2,3,4] in the beginning of the array.

 */

// import java.util.HashSet;
public class Remove_duplicates_from_Sorted_array {
    public static int removeDuplicates(int[] nums) {
        /*
         * BruteForce Appraoch:
         * Time complexity: O(N) & Space complexity: O(N)
         * HashSet<Integer> set = new HashSet<>();
         * for(int i = 0; i < nums.length; i++){
         * set.add(nums[i]);
         * }
         * int k = set.size();
         * int i = 0;
         * for(int value: set){
         * nums[i++] = value;
         * }
         * return k;
         */
        
        // Solution 2: Time Complexity: O(N) & Space Complexity: O(1)
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int k = removeDuplicates(nums);
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
