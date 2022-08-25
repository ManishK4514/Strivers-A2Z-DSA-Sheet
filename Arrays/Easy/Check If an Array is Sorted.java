/*
 * Check if an Array is Sorted
   Problem Statement: Given an array of size n, write a program to check if the given array is sorted in (ascending / Increasing / Non-decreasing) order or not. If the array is sorted then return True, Else return False.
   
   Note: Two consecutive equal values are considered to be sorted.
   
   Examples:
   
   Example 1:
   Input: N = 5, array[] = {1,2,3,4,5}
   Output: True.
   Explanation: The given array is sorted i.e Every element in the array is smaller than or equals to its next values, So the answer is True.
 */


public class Check_If_Sorted_Array {
    public static boolean checkSorted(int[] arr){
        /*
         * // In case of normal sorted Array
         * 
            for(int i = 0; i < arr.length; i++){
                if(arr[i] > arr[i + 1]){
                    return false;
                }
            }
            return true;
        */
        
        // In case of Rotated Array.
        int count = 0;
        int n = arr.length;
        for(int i = 0; i < arr.length; i++){
            // %n because whenever it goes at end index then 6 % 5 = 1 will start from index 1.
            // and will not throw Array Index out of bound
            if(arr[i] > arr[(i + 1) % n]){
                count++;
            }
            if(count > 1){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        System.out.println(checkSorted(arr));
    }
}
