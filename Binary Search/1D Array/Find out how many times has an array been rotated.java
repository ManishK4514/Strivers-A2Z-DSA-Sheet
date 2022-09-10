/*
 * Given an ascending sorted rotated array Arr of distinct integers of size N. The array is right rotated K times. Find the value of K.

   Example 1:
   
   Input:
   N = 5
   Arr[] = {5, 1, 2, 3, 4}
   Output: 1
   Explanation: The given array is 5 1 2 3 4. 
   The original sorted array is 1 2 3 4 5. 
   We can see that the array was rotated 
   1 times to the right.
*/


public class Find_out_how_many_times_has_an_array_been_rotated {
    static int findKRotation(int arr[], int n) {
        /*
         * BruteForce Approach: Time complexity: O(N) & Space complexity: O(1).
         * for(int i = 0; i < arr.length - 1; i++){
               if(arr[i] > arr[i + 1]){
                   return i + 1;
               }
           }
           return 0;
        */
        
        // Optimized Approach: using Binary Search -> Time complexity: O(logN) & Space Complexity: O(1).
        int start = 0;
        int end = n - 1;
        while(start <= end){
            if(arr[start] < arr[end]){
                return start;
            }
            int mid = start + (end - start)/2;
            int next = (mid + 1) % n;
            int pre = (mid - 1) % n;
            
            if(arr[mid] <= arr[next] && arr[mid] <= arr[pre]){
                return mid;
            }
            // check if left half is sorted
            if(arr[mid] >= arr[start]){
                start = mid + 1;
            }
            
            // check if right half is sorted
            else{
                end = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {5, 1, 2, 3, 4};
        int k = findKRotation(arr, arr.length);
        System.out.println(k);
    }
}
