/*
 * Example 1:
   Input: arr[]= 1 2 3 4 5, num = 3
   Output: 2
   Explanation: 3 is present in the 2nd index
   
   Example 2:
   Input: arr[]= 5 4 3 2 1, num = 5
   Output: 0
   Explanation: 5 is present in the 0th index
 */

public class LinearSearch {
    public static int search(int[] arr, int target){
        // Time Complexity: O(N)
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        int target = 4;
        int location = search(arr, target);
        if(location != -1){
            System.out.println("Element Found At Index: " + location);
        }
        else{
            System.out.println("Element not Found!");
        }
    }
}
