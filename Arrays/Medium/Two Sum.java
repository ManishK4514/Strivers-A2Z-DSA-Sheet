      ⊛ we will take a hashmap and we will check in each iteration that hashmap contains (target - nums[i]) if contains then 
      ⊛  we will store our current index in ans[1] and in ans[0] we will store the index of that element which is the (target - nums[i]).
      ⊛ Time Complexity: O(N ) & Space Complexity: O(N).


/*
 * wo Sum : Check if a pair with given sum exists in Array
   Problem Statement: Given an array of integers nums[] and an integer target, return indices of the two numbers such that their sum is equal to the target.
   
   Note: Assume that there is exactly one solution, and you are not allowed to use the same element twice. Example: If target is equal to 6 and num[1] = 3, then nums[1] + nums[1] = target is not a solution.
   
   Example 1:
   
   Input: nums = [2,7,11,15], target = 9
   
   Output: [0,1]
   
   Explanation: Because nums[0] + nums[1] == 9, 
   which is the required target, we return 
   indexes [0,1]. (0-based indexing)
   Example 2:
   
   Input Format: nums = [3,2,4,6], target = 6
   
   Output: [1,2]
   
   Explanation: Because nums[1] + nums[2] == 6, 
   which is the required target, we return 
   indexes [1,2].

 */


import java.util.Arrays;
import java.util.HashMap;

public class TwoSum{
    public static int[] findTwoSum(int[] nums, int target){
        /*
         * BruteForce Approach: Time Complexity: O(N^2) & Space complexity: O(1)
         * int[] ans = new int[2];
           for(int i = 0; i < nums.length; i++){
               for(int j = i + 1; j < nums.length; j++){
                   if(nums[i] + nums[j] == target){
                       ans[0] = i;
                       ans[1] = j;
                   }
               }
           }
           return ans;

        */
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                ans[1] = i;
                ans[0] = map.get(target - nums[i]);
                return ans;
            }
            map.put(nums[i], i);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] ans = findTwoSum(nums, target);
        System.out.println(Arrays.toString(ans));
    }
}
