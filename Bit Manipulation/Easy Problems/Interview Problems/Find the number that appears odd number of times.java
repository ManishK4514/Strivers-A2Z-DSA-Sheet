/*
   Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

   You must implement a solution with a linear runtime complexity and use only constant extra space.
   
   Example 1:
   Input: nums = [2,2,1]
   Output: 1
   
   Example 2:
   Input: nums = [4,1,2,1,2]
   Output: 4
   
   Example 3:
   Input: nums = [1]
   Output: 1
*/


// import java.util.HashMap;
// import java.util.Map;

public class Find_the_number_that_appears_odd_number_of_times {
    public static int singleNumber(int[] nums) {
        /* 
            // BruteForce Approach: Time Complexity: O(N^2) & Space Complexity: O(1).
            int count = 0;
            for(int i = 0; i < nums.length; i++){
                count = 0;
                for(int j = 0; j < nums.length; j++){
                    if(nums[i] == nums[j]){
                        count++;
                    }
                }
                if(count % 2 != 0){
                    return nums[i];
                }
            }
            return -1;
        */
        
        /* 
            // Solution 2: Time Complexity: O(N) & Space Complexity: O(N).
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < nums.length; i++){
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            for(Map.Entry<Integer, Integer> entry: map.entrySet()){
                if(entry.getValue() == 1){
                    return entry.getKey();
                }
            }
            return -1;
        */
        
        // Optimized Approach: Time Complexity: O(N) & Space Complexity: O(1)
        int xor = 0;
        for(int i = 0; i < nums.length; i++){
            xor ^= nums[i];
        }
        return xor;
    }
    public static void main(String[] args) {
        int[] nums = {2, 4, 2, 3, 4, 3, 5, 6, 6};
        System.out.println(singleNumber(nums));
    }
}
