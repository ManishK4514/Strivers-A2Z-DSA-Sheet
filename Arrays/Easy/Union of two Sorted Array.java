/*
 * Q.Union of Two Sorted Arrays
   Problem Statement: Given two sorted arrays, arr1 and arr2 of size n and m. Find the union of two sorted arrays.
   
   The union of two arrays can be defined as the common and distinct elements in the two arrays.NOTE: Elements in the union should be in ascending order.
   
   Examples:
   
   Example 1:
   Input:
   n = 5,m = 5.
   arr1[] = {1,2,3,4,5}  
   arr2[] = {2,3,4,4,5}
   Output:
    {1,2,3,4,5}
   
   Explanation: 
   Common Elements in arr1 and arr2  are:  2,3,4,5
   Distnict Elements in arr1 are : 1
   Distnict Elemennts in arr2 are : No distinct elements.
   Union of arr1 and arr2 is {1,2,3,4,5} 
   
   Example 2:
   Input:
   n = 10,m = 7.
   arr1[] = {1,2,3,4,5,6,7,8,9,10}
   arr2[] = {2,3,4,4,5,11,12}
   Output: {1,2,3,4,5,6,7,8,9,10,11,12}
   Explanation: 
   Common Elements in arr1 and arr2  are:  2,3,4,5
   Distnict Elements in arr1 are : 1,6,7,8,9,10
   Distnict Elemennts in arr2 are : 11,12
   Union of arr1 and arr2 is {1,2,3,4,5,6,7,8,9,10,11,12} 

 */

import java.util.*;

public class Union_Of_Two_Sorted_Array {
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        /*
         * BruteForce Approach: 
         * Time Compelxity: O(N) & Space complexity (M + N)
         * 
         * HashSet<Integer> set = new HashSet<>();
           for(int i = 0; i < n; i++){
               set.add(arr1[i]);
           }
           for(int i = 0; i < m; i++){
               set.add(arr2[i]);
           }
           int[] temp = new int[set.size()];
           int k = 0;
           for(int value: set){
               temp[k++] = value;
           }
           Arrays.sort(temp);
           ArrayList<Integer> ans = new ArrayList<>();
           for(int i = 0; i < temp.length; i++){
               ans.add(temp[i]);
           }
           return ans; 

         */
        
        /* 
           Solution 2: Using Hashmap --> Time Complexity: O(N) & Space Complexity: O(N)

           HashMap<Integer, Integer> map = new HashMap<>();
           ArrayList<Integer> ans = new ArrayList<>();
           for(int i = 0; i < n; i++){
               map.put(arr1[i], map.getOrDefault(arr1[i],0)+1);
           }
           for(int i = 0; i < m; i++){
               map.put(arr2[i], map.getOrDefault(arr2[i], 0) + 1);
           }
           for(int val: map.keySet()){
               ans.add(val);
           }
           return ans;
        */
        
        // Optimized Solution: --> Time Complexity: O(N) & Space complexity: O(1)
        int i = 0, j = 0;
        ArrayList<Integer> union = new ArrayList<>();
        while(i < n && j < m){
            if(arr1[i] <= arr2[j]){
                if(union.size() == 0 || union.get(union.size() - 1) != arr1[i]){
                    union.add(arr1[i]);
                }
                i++; // it will be outside to ignore duplicate values.
            }
            else{
                if(union.size() == 0 || union.get(union.size()-1) != arr2[j]){
                    union.add(arr2[j]);
                }
                j++; // it will be outside to ignore duplicate values.
            }
        }
        while(i < n){
            if(union.get(union.size() - 1) != arr1[i]){
                union.add(arr1[i]);
            }
            i++; // it will be outside to ignore duplicate values.
        }
        while(j < m){
            if(union.get(union.size() - 1) != arr2[j]){
                union.add(arr2[j]);
            }
            j++; // it will be outside to ignore duplicate values.
        }
        return union;
    }
    public static void main(String[] args) {
        int n = 7, m = 10;
        int arr1[] = {2, 3, 4, 4, 5, 11, 12};
        int arr2[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayList<Integer> Union = findUnion(arr1, arr2, n, m);
        System.out.println("Union of arr1 and arr2 is ");
        for (int val: Union){
          System.out.print(val+" ");
        }
    }
}
