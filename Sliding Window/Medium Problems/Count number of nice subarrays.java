/*
   1248. Count Number of Nice Subarrays
   Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
   
   Return the number of nice sub-arrays.
   
    
   
   Example 1:   
   Input: nums = [1,1,2,1,1], k = 3
   Output: 2
   Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].

   Example 2:   
   Input: nums = [2,4,6], k = 1
   Output: 0
   Explanation: There is no odd numbers in the array.

   Example 3:   
   Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
   Output: 16
 */


import java.util.HashMap;

public class Count_Number_of_Nice_Subarrays {
    public static int numberOfSubarrays(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                nums[i] = 0;
            }
            else{
                nums[i] = 1;
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);        
        int sum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1};
        int k = 3;
        System.out.println(numberOfSubarrays(nums, k));
    }
}
