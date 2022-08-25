/*
 * Find the Largest element in an array
 * Problem Statement: Given an array, we have to find the largest element in the array.

   Examples:
   
   Example 1:
   Input: arr[] = {2,5,1,3,0};
   Output: 5
   Explanation: 5 is the largest element in the array. 
   
   Example2: 
   Input: arr[] = {8,10,5,7,9};
   Output: 10
   Explanation: 10 is the largest element in the array. 
 */

public class Largest_Element_In_An_Array {
    public static int findMaxElement(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {34, 23, 97, 2, 23, 93, 23, 99};
        int max = findMaxElement(arr);
        System.out.println("The Maximum number in the array is: " + max);
    }
}
