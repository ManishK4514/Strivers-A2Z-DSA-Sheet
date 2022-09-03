/*
 * Majority Elements(>N/3 times) | Find the elements that appears more than N/3 times in the array
   Problem Statement: Given an array of N integers. Find the elements that appear more than N/3 times in the array. If no such element exists, return an empty vector.
   
   Example 1:
   Input: N = 5, array[] = {1,2,2,3,2}
   Ouput: 2
   Explanation: Here we can see that the Count(1) = 1, Count(2) = 3 and Count(3) = 1.Therefore, the count of 2 is greater than N/3 times. Hence, 2 is the answer.

   Example 2:
   Input:  N = 6, array[] = {11,33,33,11,33,11}   
   Output: 11 33   
   Explanation: Here we can see that the Count(11) = 3 and Count(33) = 3. Therefore, the count of both 11 and 33 is greater than N/3 times. Hence, 11 and 33 is the answer.
 */

import java.util.List;
import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.HashSet;
// import java.util.Map; 

public class Majority_Element_II {
    public static List<Integer> majorityElement(int[] nums) {
        /*
         * // BruteForce Approach --> Time complexity: O(N^2) & Space complexity: O(1).
           List<Integer> ans = new ArrayList<>();
           for(int i = 0; i < nums.length; i++){
               int count = 1;
               for(int j = i + 1; j < nums.length; j++){
                   if(nums[i] == nums[j]){
                       count++;
                   }
               }
               if(count > nums.length/3){
                   ans.add(nums[i]);
               }
           }
           return ans;
        */
        
        /*
         * // Solution 2: Using HashMap --> Time compelxity: O(N) & Space complexity: O(N)
           List<Integer> ans = new ArrayList<>();
           HashMap<Integer, Integer> map = new HashMap<>();
           for(int i = 0; i < nums.length; i++){
               if(map.containsKey(nums[i])){
                   map.put(nums[i], map.get(nums[i]) + 1);
               }
               else{
                   map.put(nums[i], 1);
               }
           }
           for (Map.Entry<Integer, Integer> entry : map.entrySet()){
               if(entry.getValue() > nums.length/3){
                   ans.add(entry.getKey());
               }
           }
           return ans;
        */

        // Optimized Solution: Boyer Moore Voting Algorithms.
        // Time complexity: O(N) & Space complexity: O(1).
        List<Integer> ans = new ArrayList<>();
        int num1 = -1; int num2 = 0; int count1 = 0; int count2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(num1 == nums[i]){
                count1++;
            }
            else if(num2 == nums[i]){
                count2++;
            }
            else if (count1 == 0){
                num1 = nums[i];
                count1 = 1;
            }
            else if (count2 == 0){
                num2 = nums[i];
                count2 = 1;
            }
            else{
                count1--;
                count2--;
            }
        }
        int count01 = 0, count02 = 0;
        for(int i = 0; i < nums.length; i++){
            if(num1 == nums[i]){
                count01++;
            }
            if(num2 == nums[i]){
                count02++;
            }
        }
        if(count01 > nums.length/3){
            ans.add(num1);
        }
        if(count02 > nums.length/3){
            ans.add(num2);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {-1, -1, -1};
        System.out.println(majorityElement(nums));
        /*
         * for BruteForce Solution:
         * List<Integer> majority = majorityElement(nums);
           HashSet<Integer> set = new HashSet<>(majority);
           for(int it: set){
               System.out.print(it + " ");
           }
        */
    }
}
