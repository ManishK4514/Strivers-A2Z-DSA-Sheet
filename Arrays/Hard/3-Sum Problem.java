/*
 * 3 Sum : Find triplets that add up to a zero
   Problem Statement: Given an array of N integers, your task is to find unique triplets that add up to give a sum of zero. In short, you need to return an array of all the unique triplets [arr[a], arr[b], arr[c]] such that i!=j, j!=k, k!=i, and their sum is equal to zero.
   
   Examples:
   
   Example 1: 
   Input: nums = [-1,0,1,2,-1,-4]
   Output: [[-1,-1,2],[-1,0,1]]
   Explanation: Out of all possible unique triplets possible, [-1,-1,2] and [-1,0,1] satisfy the condition of summing up to zero with i!=j!=k
   
   Example 2:
   Input: nums=[-1,0,1,0]
   Output: Output: [[-1,0,1],[-1,1,0]]
   Explanation: Out of all possible unique triplets possible, [-1,0,1] and [-1,1,0] satisfy the condition of summing up to zero with i!=j!=k
 */


import java.util.ArrayList;
import java.util.Arrays;
// import java.util.HashMap;
import java.util.List;
public class Sum_III {
    public static List<List<Integer>> tripletSum(int[] nums) {
        /*
         * BruteForce Approach: Time complexity: O(N^3*logk) & Space complexity: O(3*k)
         * List<List<Integer>> ans = new ArrayList<>();
           for(int i = 0; i < nums.length - 2; i++){
               for(int j = i + 1; j < nums.length - 1; j++){
                   for(int k = j + 1; k < nums.length; k++){
                       ArrayList<Integer> temp = new ArrayList<>();
                       if(i != j && i != k && j != k && nums[i] + nums[j] + nums[k] == 0){
                           temp.add(nums[i]);
                           temp.add(nums[j]);
                           temp.add(nums[k]);
                       }
                       if(temp.size() != 0){
                           ans.add(temp);
                       }
                   }
               }
           }
           return ans;
        */

        // Optimized Approach: Time complexity: O(N^3) & Space complexity: O(1).
        
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1])){
                int low = i + 1, high = nums.length - 1, sum = 0 - nums[i];
                while(low < high){
                    if(nums[low] + nums[high] == sum){
                        ans.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while(low < high && nums[low] == nums[low + 1]){
                            low++;
                        }
                        while(low < high && nums[high] == nums[high - 1]){
                            high--;
                        }
                        low++;
                        high--;
                    }
                    else if(nums[low] + nums[high] < sum){
                        low++;
                    }
                    else{
                        high--;
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(tripletSum(nums));
    }
}
