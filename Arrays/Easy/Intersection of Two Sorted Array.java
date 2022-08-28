/*
 * Intersection of two sorted arrays
   Problem Statement: Find the intersection of two sorted arrays. OR in other words, Given 2 sorted arrays, find all the elements which occur in both the arrays.
   
   Examples:
   
   Example 1:
   Input: 
   A: [1 2 3 3 4 5 6]
   , B: [3 3 5]
   Output: 3,3,5
   Explanation: We are given two arrays A and B. 
   The elements present in both the arrays  
   are 3,3 and 5.
   
   Example 2:
   Input: 
   A: [1 2 3 3 4 5 6]
   , B: [3 5]
   Output: 3,5
   Explanation: We are given two arrays A and B. 
   The elements present in both the arrays are 3 and 5.
 */

import java.util.*;

public class Intersection_Of_Two_Sorted_Array {
    public static ArrayList<Integer> findIntersection(int[] arr1, int[] arr2, int n, int m){
        /*
         * BruteForce Approach --> Time complexity: O(N^2) & Space Complexity: O(1).
         * ArrayList<Integer> intersection = new ArrayList<>();
           for(int i = 0; i < n; i++){
               for(int j = 0; j < m; j++){
                   if(arr1[i] == arr2[j]){
                       if((intersection.size() == 0 ||intersection.get(intersection.size() - 1) != arr1[i])){
                           intersection.add(arr1[i]);
                       }
                   }
               }
           }
           return intersection;
        */

        // Optimized Solution --> Time complexity: O(N) & Space complexity: O(1).
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;
        while(i < arr1.length && j < arr2.length){
            if(arr1[i] == arr2[j]){
                ans.add(arr1[i]);
                i++;
                j++;
            }
            else if(arr1[i] < arr2[j]){
                i++;
            }
            else{
                j++;
            }
        }
        return ans;
        
    }
    public static void main(String[] args) {
        int n = 10, m = 7;
        int arr1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int arr2[] = {2, 3, 4, 4, 5, 11, 12};
        ArrayList<Integer> intersection = findIntersection(arr1, arr2, n, m);
        System.out.println("Union of arr1 and arr2 is ");
        for (int val: intersection){
          System.out.print(val+" ");
        }
    }
}
