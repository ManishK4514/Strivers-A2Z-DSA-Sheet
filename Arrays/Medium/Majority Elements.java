      ⊛ The most easiest Approach is sort the Array and return nums[nums.length/2] as given that majority element frequency more than N/2.
      ⊛  The most Optimized Solution is to use MOORE VOTING ALGORITHM.
      ⊛ Time Complexity: O(N ) & Space Complexity: O(1).



/*
 * Find the Majority Element that occurs more than N/2 times
   Problem Statement: Given an array of N integers, write a program to return an element that occurs more than N/2 times in the given array. You may consider that such an element always exists in the array.
   
   Example 1:
   
   Input Format: N = 3, nums[] = {3,2,3}
   
   Result: 3
   
   Explanation: When we just count the occurrences of each number and compare with half of the size of the array, you will get 3 for the above solution. 
   
 */

// import java.util.Arrays;
// import java.util.HashMap;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        /*
         * BruteForce Approach: Time Complexity: O(N^2) & Space Complexity: O(1)
         * # In this solution we will find the frequency of each element and whichever frequency is more than rest all and also more than n/2 that will be our answer.(where n is the length of the array.)
         
        int maxFreq = 0;
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            int count = 0;
            for(int j = 0; j < nums.length; j++){
                if(nums[i] == nums[j]){
                    count++;
                }
            }
            if(maxFreq < count){
                maxFreq = count;
                ans = nums[i];
            }
        }
        if(maxFreq > nums.length/2){
            return ans;
        }
        else{
            return -1;
        }

        */

        /*Solution 2: if assume that the majority element always exists in the array, Then this could be our solution with
        Time Complexity: O(NlogN) & Space Complexity: O(1).

        Arrays.sort(nums);
        return nums[nums.length/2];
  
        */ 
        
        /*
         * Solution 3: Using HashMap Time Complexity: O(NlogN) & Space Complexity: O(1), Time Complexity NlogN because it is unordered map.
         
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else{
                map.put(nums[i], 1);
            }
        }
        int maxFreq = 0, ans = 0;
        for(int value: map.keySet()){
            if(maxFreq < map.get(value)){
                maxFreq = map.get(value);
                ans = value;
            }
        }
        if(maxFreq > nums.length/2){
            return ans;
        }
        else{
            return -1;
        }

        */

        // Solution 4: By Moore Voting Algorithm // this will only work if majority element exists.
        // Time Complexity: O(N) & Space Complexity: O(1)

        int count = 0, element = 0;
        for(int i = 0; i < nums.length; i++){
            if(count == 0){
                element = nums[i];
                count++;
            }
            else if(nums[i] != element){
                count--;
            }
            else{
                count++;
            }
        }
        return element;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 1, 3, 1, 1};
        System.out.println(majorityElement(nums));
    }
}
