/*
 * 4 Sum | Find Quads that add up to a target value Problem Statement: 
 * Given an array of N integers, your task is to find unique quads that add up to give a target value. In short, you need to return an array of all the unique quadruplets [arr[a], arr[b], arr[c], arr[d]] such that their sum is equal to a given target.
 * 
   Note:
   0 <= a, b, c, d < n
   a, b, c, and d are distinct.
   arr[a] + arr[b] + arr[c] + arr[d] == target
   Example 1:
   
   Input Format: arr[] = [1,0,-1,0,-2,2], target = 0
   
   Result: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
   
   Explanation: We have to find unique quadruplets from 
   the array such that the sum of those elements is 
   equal to the target sum given that is 0. 
   
   The result obtained is such that the sum of the 
   quadruplets yields 0.
*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum_IV {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        /*
         * // BruteForce Appraoch: Time complexity: O(N^4 * logK) & Space complexity: O(1).
         * // It will only insert uniques quad.
         * List<List<Integer>> ans = new ArrayList<>();
           for(int a = 0; a < nums.length - 3; a++){
               for(int b = a + 1; b < nums.length - 2; b++){
                   for(int c = b + 1; c < nums.length - 1; c++){
                       for(int d = c + 1; d < nums.length; d++){
                           ArrayList<Integer> temp = new ArrayList<>();
                           if(nums[a] + nums[b] + nums[c] + nums[d] == target){
                               temp.add(nums[a]);
                               temp.add(nums[b]);
                               temp.add(nums[c]);
                               temp.add(nums[d]);
                           }
                           if(ans.contains(temp)){
                               // System.out.println("Hello World");
                           }
                           else if(temp.size() != 0){
                               ans.add(temp);
                           }
                       }                    
                   }
               }
           }
           return ans;
        */
        
        /*
         * // Solution 2: Using three pointer & binary search.
         * // Time complexity: O(N log N + N³ logN) & Space complexity: O(1).
         * // It also contains duplicate quad.
         * 
         * List<List<Integer>> ans = new ArrayList<>();
           Arrays.sort(nums);
           for(int i = 0; i < nums.length - 3; i++){
               for(int j = i + 1; j < nums.length - 2; j++){
                   for(int k = j + 1; k < nums.length - 1; k++){
                       int sum = nums[i] + nums[j] + nums[k];
                       int item = target - sum;
                       int start = k + 1;
                       int end = nums.length;
                       int mid = 0;
                       while(start <= end){
                           mid = start + (end - start)/2;
                           if(nums[mid] == item){
                               ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[mid]));
                               break;
                           }
                           else if(nums[mid] > target){
                               end = mid - 1;
                           }
                           else{
                               start = mid + 1;
                           }
                       }
                   }
               }
           }
           return ans;
        */

        // Optimized Solution: Time complexity: O(N^3) & Space complexity: O(1).
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                int target2 = target - nums[j] - nums[i];
                int front = j + 1;
                int back = nums.length - 1;
                while(front < back){
                    int twoSum = nums[front] + nums[back];
                    if(twoSum < target2){
                        front++;
                    }
                    else if(twoSum > target2){
                        back--;
                    }
                    else{
                        List<Integer> quad = new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[front]);
                        quad.add(nums[back]);
                        ans.add(quad);
                        while(front < back && nums[front] == quad.get(2)){
                            front++;
                        }
                        while(front < back && nums[back] == quad.get(3)){
                            back--;
                        }
                    }
                }
                while(j + 1 < nums.length && nums[j + 1] == nums[j]) ++j;
            }
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) ++i;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        System.out.println(fourSum(nums, target));
    }
}
