/*
   Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 * Example 1:
   Input: nums = [3,0,1]
   Output: 2
   Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
 */

// import java.util.Arrays;
public class Find_Missing_Number {
    public static int missingNumber(int[] arr) {
        /*
         * Solution: 01 --> Time Complexity: O(NlogN) & Space complexity: O(1)
         * int N = arr.length;
           Arrays.sort(arr);
           for(int i = 0; i < N; i++){
               if(arr[i] != i){
                   return i;
               }
           }
           return N;
        */
        // Solution 2: Time Complexity: O(N) & Space Complexity: O(1)
        int sum = 0;
        int N = arr.length;
        // calculating sum of all elements of the array.
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        // calculation sum till 0 to N - 1
        int sum2 = (N * (N + 1))/2;
        // We will get our ans by subtracting
        int ans = sum2 - sum;
        return ans;
        
    }
    public static void main(String[] args) {
        int[] arr = {0, 3, 1};
        int ans = missingNumber(arr);
        System.out.println(ans);
    }
}
