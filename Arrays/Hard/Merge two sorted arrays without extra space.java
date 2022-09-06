/*
 * Merge two Sorted Arrays Without Extra Space
   Problem statement: Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order. Merge them in sorted order. Modify arr1 so that it contains the first N elements and modify arr2 so that it contains the last M elements.

   Examples:

   Example 1:
   Input: 
   n = 4, arr1[] = [1 4 8 10] 
   m = 5, arr2[] = [2 3 9]
   
   Output: 
   arr1[] = [1 2 3 4]
   arr2[] = [8 9 10]
   
   Explanation:
   After merging the two non-decreasing arrays, we get, 1,2,3,4,8,9,10.
   
   Example2:
   
   Input: 
   n = 4, arr1[] = [1 3 5 7] 
   m = 5, arr2[] = [0 2 6 8 9]
   
   Output: 
   arr1[] = [0 1 2 3]
   arr2[] = [5 6 7 8 9]
   
   Explanation:
   After merging the two non-decreasing arrays, we get, 0 1 2 3 5 6 7 8 9.
*/

import java.util.Arrays;

public class Merge_two_sorted_arrays_without_extra_space {
    static void swap(int a,int b)
    {
        int temp=a;
        a=b;
        b=temp;
    }
    public static void merge(int arr1[], int arr2[], int n, int m) 
    {
        /*
         * // solution 1: using extra Space.  
         * // Time complexity: O(n*log(n))+O(n)+O(n)) & Space complexity: O(N).
         * int[] temp = new int[m + n];
           int j = 0;
           for(int i = 0; i < n; i++){
               temp[j++] = arr1[i];
           }
           for(int i = 0; i < m; i++){
               temp[j++] = arr2[i];
           }
           Arrays.sort(temp);
           int u = 0;
           for(int i = 0; i < n; i++){
               arr1[i] = temp[u++];
           }
           for(int i = 0; i < m; i++){
               arr2[i] = temp[u++];
           }
        */

        /*
         * //Solution 2: using insertions sort:
         * // Time complexity: O(n*m) & Space complexity: O(1).
         * int k;
           for(int i = 0; i < n; i++){
               if(arr1[i] > arr2[0]){
                   int temp = arr1[i];
                   arr1[i] = arr2[0];
                   arr2[0] = temp;
               }
               int first = arr2[0];
               // insertion sort is used here
               for (k = 1; k < m && arr2[k] < first; k++) {
                 arr2[k - 1] = arr2[k];
               }
               arr2[k - 1] = first;
           }
        */
        
        // Optimized Solution: 
        // Time complexity: O(n+m) & Space Complexity: O(1) 
        int gap =(int) Math.ceil((double)(n + m) / 2.0);
        while (gap > 0) {
          int i = 0;
          int j = gap;
          while (j < (n + m)) {
            if (j < n && arr1[i] > arr1[j]) {
              swap(arr1[i], arr1[j]);
            } else if (j >= n && i < n && arr1[i] > arr2[j - n]) {
              swap(arr1[i], arr2[j - n]);
            } else if (j >= n && i >= n && arr2[i - n] > arr2[j - n]) {
              swap(arr2[i - n], arr2[j - n]);
            }
            j++;
            i++;
          }
          if (gap == 1) {
            gap = 0;
          } else {
            gap =(int) Math.ceil((double) gap / 2.0);
          }
        }
    }
    public static void main(String[] args) {
        int arr1[] = {1,4,7,8,10};
	    int arr2[] = {2,3,9};
        merge(arr1, arr2, arr1.length, arr2.length);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
