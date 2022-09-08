import java.util.Arrays;

/*
 * Find the First and Last occurrence in a sorted array
   Given a sorted array of N integers, write a program to find the index of the first and last occurrence of the target key. If the target is not found then return -1.
   
   Note: Consider 0 based indexing
   
   Examples:
   
   Example 1:
   Input: N = 7, target=13, array[] = {3,4,13,13,13,20,40}
   Output: 2, 4
   Explanation: As the target value is 13 , it appears for the first time at index number 2, and last time at index number 4.
   
   Example 2:
   Input: N = 7, target=60, array[] = {3,4,13,13,13,20,40}
   Output: -1, -1
   Explanation: Target value 60 is not present in the array 
 */


public class Find_the_first_or_last_occurrence_of_a_given_number_in_a_sorted_array {
    public static int search(int[] arr, int target, boolean findStartIndex){
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target){
                ans = mid;
                if(findStartIndex == true){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            else if(arr[mid] > target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return ans;
    }
    public static int[] solve(int n, int target, int[] arr){
        /*
         * BruteForce Approach: Time complexity: O(N) & Space complexity: O(1).
         * int ans[] = new int[2];
           int start = -1;
           int end = -1;
           for(int i = 0; i < arr.length; i++){
               if(arr[i] == target){
                   if(start == -1){
                       start = i;
                   }
                   end = i;
               }
           }
           ans[0] = start;
           ans[1] = end;
           return ans;
         * 
        */

        // Solution 2: Optimized --> Time complexity: O(logN) & Space complexity: O(1)
        int start = -1;
        int end = -1;
        int[] ans = new int[2];
        start = search(arr, target, true);
        end = search(arr, target, false);
        ans[0] = start;
        ans[1] = end;
        return ans;
    }
    public static void main(String[] args) {
        int n = 7;
        int key = 13;
        int[] arr = {3,4,13,13,13,20,40};
    
        // returning the last occurrence index if the element is present otherwise -1
        int[] ans = solve(n, key, arr);
        System.out.println(Arrays.toString(ans));
    }
}
