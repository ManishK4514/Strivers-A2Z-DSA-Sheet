/*
 * Move all Zeros to the end of the array
   In this article we will learn how to solve the most asked coding interview problem: “Move all Zeros to the end of the array”
   
   Problem Statement: You are given an array of integers, your task is to move all the zeros in the array to the end of the array and move non-negative integers to the front by maintaining their order.
   
   Examples:
   
   Example 1:
   Input: 1 ,0 ,2 ,3 ,0 ,4 ,0 ,1
   Output: 1 ,2 ,3 ,4 ,1 ,0 ,0 ,0
   Explanation: All the zeros are moved to the end and non-negative integers are moved to front by maintaining order
   
   Example 2:
   Input: 1,2,0,1,0,4,0
   Output: 1,2,1,4,0,0,0
   Explanation: All the zeros are moved to the end and non-negative integers are moved to front by maintaining order

*/

      ⊛ We will traverse the Array till end, If we get zero at any index then we will increase the Zeros value by one.
      ⊛ Otherwise if we get not Zeros element then we will set that index 0 and then we will set that value to the arr[i - Zeros] by doing we will get non zeros elment at starting 
      ⊛ Time Complexity: O(N).


import java.util.Arrays;

public class Move_Zeros_to_end {
    public static void zerosToEnd(int[] arr){
        /*
         * BruteForce Appraoch:
         * Time Complexity: O(N) & Space Complexity: O(N)
         * int[] temp = new int[arr.length];
           int Zeros = 0;
           int  k = 0;
           for(int i = 0; i < arr.length; i++){
               if(arr[i] == 0){
                   Zeros++;
               }
               else{
                   temp[k++] = arr[i];
               }
           }
           for(int i = 0; i < Zeros; i++){
               temp[k++] = 0;
           }
           for(int i = 0; i < temp.length; i++){
               arr[i] = temp[i];
           }
        */
        
        // Solution 2:
        int zeros = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                zeros++;
            }
            else{
                int temp = arr[i];
                arr[i] = 0;
                arr[i - zeros] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        zerosToEnd(arr);
        System.out.println(Arrays.toString(arr));
    }
}
