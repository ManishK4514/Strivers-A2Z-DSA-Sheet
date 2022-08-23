/*
 * Q. Write a program to Reverse an Array using recursion.
 * Example:
 * Input: arr = {12, 43, 98, 23, 23, 11};
 * Output: [11, 23, 23, 98, 43, 12]
 */

import java.util.Arrays;

public class Reverse_An_Array {
    /*
     * BruteForce Approach: Auxillary space: O(N), Space complexity: O(N)
       public static void reverse(int[] arr, int n, int[] revArr, int i){
           if(n == -1){
               return;
           }
           revArr[n] = arr[i];
           reverse(arr, n - 1, revArr, i + 1);
       }
     * 
     */
      
    public static void reverseArray(int[] arr, int start, int end){
        if(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            reverseArray(arr, start + 1, end - 1);
        }
    }
    public static void main(String[] args) {
        int[] arr = {12, 43, 98, 23, 23, 11};
        // int[] revArr = new int[arr.length];
        // reverse(arr, arr.length - 1, revArr, 0);
        reverseArray(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
