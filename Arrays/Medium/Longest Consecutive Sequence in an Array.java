
/*
 * Longest Consecutive Sequence in an Array
   Problem Statement: You are given an array of ‘N’ integers. You need to find the length of the longest sequence which contains the consecutive elements.
   
   Examples:
   
   Example 1:
   Input: [100, 200, 1, 3, 2, 4]
   Output: 4
   Explanation: The longest consecutive subsequence is 1, 2, 3, and 4.
   
   Example 2:
   Input: [3, 8, 5, 7, 6]
   Output: 4
   
   Explanation: The longest consecutive subsequence is 5, 6, 7, and 8.
 */


// import java.util.Arrays;
import java.util.HashSet;

public class Longest_Consecutive_Sequence_in_an_Array {
    public static int longestConsecutive(int[] arr){
        if(arr.length == 0 || arr == null){
            return 0;
        }
        /*
         * Solution 1: Time complexity: O(NlogN) & Space Complexity: O(1).
         * Arrays.sort(arr);
           int ans = 1;
           int prev = arr[0];
           int curr = 1;
           for(int i = 1; i < arr.length; i++){
               if(arr[i] == prev + 1){
                   curr++;
               }
               else if(arr[i] != prev){
                   curr = 1;
               }
               prev = arr[i];
               ans = Math.max(ans, curr);
           }
           return ans;
        */
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            set.add(arr[i]);
        }
        int longestStreak = 0;
        for(int i = 0; i < arr.length; i++){
            if(!set.contains(arr[i] - 1)){
                int currNum = arr[i];
                int currentStreak = 1;
                while(set.contains(currNum + 1)){
                    currNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
    public static void main(String[] args) {
        int[] arr = {100, 102, 101, 1, 3, 2, 4};
        System.out.println(longestConsecutive(arr));
    }
}
