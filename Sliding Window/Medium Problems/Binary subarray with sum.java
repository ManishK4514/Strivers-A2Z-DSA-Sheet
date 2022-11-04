/*
    930. Binary Subarrays With Sum

    Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
    
    A subarray is a contiguous part of the array.
    
    Example 1:    
    Input: nums = [1,0,1,0,1], goal = 2
    Output: 4
    Explanation: The 4 subarrays are bolded and underlined below:
    [1,0,1,0,1]
    [1,0,1,0,1]
    [1,0,1,0,1]
    [1,0,1,0,1]

    Example 2:    
    Input: nums = [0,0,0,0,0], goal = 0
    Output: 15
*/


import java.util.HashMap;

public class Binary_Subarrays_With_Sum {
    public static int numSubarraysWithSum(int[] nums, int goal) {
        /* 
            // BruteForce Approach: Time Complexity: O(N^2) & Space Complexity: O(1)
            int sum, count = 0;
            for(int i = 0; i < nums.length; i++){
                sum = 0;
                for(int j = i; j < nums.length; j++){
                    sum += nums[j];
                    if(sum == goal){
                        count++;
                    }
                }
            }
            return count;
        */

        // Solution 2: (Using HashMap) Time Complexity: O(N) & Space Complexity: O(N)
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - goal)) {
                count += map.get(sum - goal);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        int goal = 2;
        System.out.println(numSubarraysWithSum(nums, goal));
    }
}
