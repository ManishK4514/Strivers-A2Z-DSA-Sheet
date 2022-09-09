/*
 * Q. You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
 * 
 * Example 1:
   Input: nums = [1,1,2,3,3,4,4,8,8]
   Output: 2
   
   Example 2:
   Input: nums = [3,3,7,7,10,11,11]
   Output: 10
*/

// import java.util.HashMap;
// import java.util.Map;

public class Single_element_in_a_Sorted_Array {
    public static int singleNonDuplicate(int[] nums) {
        /*
         * BruteForce Approach: Using Two pointer -> Time complexity: O(N^2) & Space complexity: O(1).
         * for(int i = 0; i < nums.length; i++){
                int count = 0;
                for(int j = 0; j < nums.length; j++){
                    if(nums[i] == nums[j]){
                        count++;
                    }
                }
                if(count == 1){
                    return nums[i];
                }
            }
            return -1;
        */

        /*
         * Solution 2: using Hashmap -> Time complexity: O(N) & Space complexity: O(N).
         * HashMap<Integer, Integer> map = new HashMap<>();
           for(int i = 0; i < nums.length; i++){
               if(map.containsKey(nums[i])){
                   map.put(nums[i], map.get(nums[i]) + 1);
               }
               else{
                   map.put(nums[i], 1);
               }
           }
           for (Map.Entry<Integer,Integer> entry : map.entrySet()){
               if(entry.getValue() == 1){
                   return entry.getKey();
               }
           }
           return -1;
        */

        /*
         * Solution 3: using xor: Time complexity: O(N) & Space complexity: O(1).
         * int xor = 0;
           for(int i = 0; i < nums.length; i++){
               xor = xor ^ nums[i];
           }
           return xor;
        */
        
        /*
         * Solution 4:Time complexity: O(N) & Space complexity: O(1).
         * for(int i = 0; i < nums.length - 1; i += 2){
                if(nums[i] != nums[i + 1]){
                    return nums[i];
                }
            }
            return nums[nums.length - 1];
        */

        // Optimized Appraoch:Using Binary search -> Time Complexity: O(logN) & Space complexity: O(1).
        
        int start = 0;
        int end = nums.length - 1;

        // Boundry cases:
        if(nums.length == 1){
            return nums[0];
        }
        else if(nums[start] != nums[start + 1]){
            return nums[start];
        }
        else if (nums[end] != nums[end - 1]){
            return nums[end];
        }
        while(start <= end){
            int mid = start + (end - start)/2;

            // unique element cases
            if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]){
                return nums[mid];
            }
            else if((nums[mid] == nums[mid - 1] && mid % 2 != 0) || (nums[mid] == nums[mid + 1] && mid % 2 == 0)){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(nums));
    }
}
