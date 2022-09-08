/*
 * Count Occurrences in Sorted Array
   Problem Statement: You are given a sorted array containing N integers and a number X, you have to find the occurrences of X in the given array.
   
   Examples:
   
   Example 1:
   Input: N = 7,  X = 3 , array[] = {2, 2 , 3 , 3 , 3 , 3 , 4}
   Output: 4
   Explanation: 3 is occurring 4 times in 
   the given array so it is our answer.
   
   Example 2:
   Input: N = 8,  X = 2 , array[] = {1, 1, 2, 2, 2, 2, 2, 3}
   Output: 5
   Explanation: 2 is occurring 5 times in the given array so it is our answer.
*/


public class Count_Occurrences_in_Sorted_Array {
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
    public static int countOccurence(int[] arr, int target){
        /*
         * BruteForce Solution: Time complexity: O(N) & Space complexity: O(1)
         * int occurence = 0;
           for(int i = 0; i < arr.length; i++){
               if(arr[i] == x){
                   occurence++;
               }
           }
           return occurence;
        */

        // Optimized Solution: Using Binary Search: 
        // Time complexity: O(logN) & Space complexity: O(1)

        int start = -1;
        int end = -1;

        // finding first occurence.
        start = search(arr, target, true); 

        // finding last occurence.
        end = search(arr, target, false);
        
        // checking target is present or not.
        if(start == -1 && end == -1){
            return 0;
        }

        // Occurence = last Occurence - first Occurence + 1
        return (end - start) + 1;
    }
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 2, 3};
        int target = 2;
        System.out.println(countOccurence(arr, target));
    }
}
