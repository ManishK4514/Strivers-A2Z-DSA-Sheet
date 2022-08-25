/*
 * Find Second Smallest and Second Largest Element in an array
   Problem Statement: Given an array, find the second smallest and second largest element in the array. Print ‘-1’ in the event that either of them doesn’t exist.
   
   Examples:
   
   Example 1:
   Input: [1,2,4,7,7,5]
   Output: Second Smallest : 2
   	Second Largest : 5
   Explanation: The elements are as follows 1,2,3,5,7,7 and hence second largest of these is 5 and second smallest is 2
   
   Example 2:
   Input: [1]
   Output: Second Smallest : -1
   	Second Largest : -1
   Explanation: Since there is only one element in the array, it is the largest and smallest element present in the array.There is no second largest or second smallest element present.
 */


public class Second_Largest_Element_In_An_Array {
    public static int findSecondMaxElement(int[] arr){

        /*
           *ButeForce Approach if No duplicate element present in the Array

         * Solution 1: 
         * First we will sort the array and then return second last element if no duplicate contains.
         * Time Complexity: O(NlogN) --> for Sorting an Array.
         * 
         * Arrays.sort(arr);
           int secondMax = arr[arr.length - 2];
           return secondMax;
         */

        /*  Solution 2: 
            Time complexity: O(N)
            // First we will push greatest element at the end of the Array.
            for(int i = 0; i < arr.length - 1; i++){
                if(arr[i] > arr[i + 1]){
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            // and when Max gets its final value, its previous value which is second last assigned to the second_Max.
            int max = Integer.MIN_VALUE;
            int second_max = 0;
            for(int i = 0; i < arr.length; i++){
                if(max < arr[i]){
                    second_max = max;
                    max = arr[i];
                }
            }
            return second_max;
         * 
        */
        
        // Solution 3:
        // In first Iteration we find the maximum value from the array
        // and After that we Again do an iteration and find nearest greater maximum value, which is second greatest element.
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        int secondMax = -1;
        for(int i = 0; i < arr.length; i++){
            if(secondMax < arr[i] && arr[i] < max){
                secondMax = arr[i];
            }
        }
        return secondMax;
        
    }
    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1};
        int max = findSecondMaxElement(arr);
        System.out.println("The Second Maximum number in the array is: " + max);
    }
}
