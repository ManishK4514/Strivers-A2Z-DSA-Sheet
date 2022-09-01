/*
 * Leaders in an Array
   Problem Statement: Given an array, print all the elements which are leaders. A Leader is an element that is greater than all of the elements on its right side in the array.
   
   Examples:
   
   Example 1:
   Input:
    arr = [4, 7, 1, 0]
   Output:
    7 1 0
   Explanation:
    Rightmost element is always a leader. 7 and 1 are greater than the elements in their right side.
   
   Example 2:
   Input:
    arr = [10, 22, 12, 3, 0, 6]
   Output:
    22 12 6
   Explanation:
    6 is a leader. In addition to that, 12 is greater than all the elements in its right side (3, 0, 6), also 22 is greater than 12, 3, 0, 6.
 */


import java.util.ArrayList;

public class Leaders_in_an_Array_problem {
    static ArrayList<Integer> leaders(int arr[]){
        /*
         * BruteForce Approach: Time complexity: O(N^2) & Space complexity: O(1)
         * ArrayList<Integer> ans = new ArrayList<>();
           boolean leader = false;
           for(int i = 0; i < arr.length; i++){
               leader = false;
               for(int j = i + 1; j < arr.length; j++){
                   if(arr[i] < arr[j]){
                       leader = true;
                   }
               }
               if(!leader){
                   ans.add(arr[i]);
               }
           }
           return ans;
         */
        ArrayList<Integer> ans = new ArrayList<>();
        int max = arr[arr.length - 1];
        ans.add(max);
        for(int i = arr.length - 2; i >= 0; i--){
            if(max <= arr[i]){
                max = arr[i];
                ans.add(max);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr [] = {16,17,4,3,5,2};
        ArrayList<Integer> ans = leaders(arr);
        System.out.println(ans);
    }
}
