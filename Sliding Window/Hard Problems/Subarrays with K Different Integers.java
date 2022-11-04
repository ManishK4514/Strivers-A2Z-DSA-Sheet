/*
   Given an integer array nums and an integer k, return the number of good subarrays of nums.

   A good array is an array where the number of different integers in that array is exactly k.
   
   For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
   A subarray is a contiguous part of an array.
   
   Example 1:   
   Input: nums = [1,2,1,2,3], k = 2
   Output: 7
   Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]

   Example 2:   
   Input: nums = [1,2,1,3,4], k = 3
   Output: 3
   Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
*/


// import java.util.HashSet;
import java.util.HashMap;

public class Subarrays_with_K_Different_Integers {
    /* 
        public static int subarraysWithKDistinct(int[] nums, int k) {
                // BruteForce Approach: Time Complexity: O(N^2) & Space Complexity: O(1)
                int count = 0;
                for(int i = 0; i < nums.length; i++){
                    HashSet<Integer> set = new HashSet<>();
                    for(int j = i; j < nums.length; j++){
                        set.add(nums[j]);
                        if(set.size() == k){
                            count++;
                        }
                    }
                }
                return count;      
        }
    */
    public static int atMost(int[] nums, int k){
        // Optimized Approach: Time Complexity: O(N) & Space Complxity: O(N)
        /* Intituion: First we will count all the subarray which contains at max K element and then we will count all the subarray which contains at max K - 1 element and we will substract both to get the count of all subarray with K different Integers. */
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0, sum = 0;
        for(int j = 0; j < nums.length; j++){
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while(map.size() > k){
                map.put(nums[i], map.get(nums[i]) - 1);
                if(map.get(nums[i]) == 0){
                    map.remove(nums[i]);
                }
                i++;
            }
            sum += ((j - i) + 1);
        }
        return sum;
    }
    public static int subarraysWithKDistinct(int[] nums, int k) {        
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        int k = 2;
        System.out.println(subarraysWithKDistinct(nums, k));
    }
}
